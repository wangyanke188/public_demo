function Cart(){
    this.get=function () {
        var cart=localStorage.getItem('cart');
        if(cart){
            return JSON.parse(cart);
        }else{
            return {total:0,carNum:0,paytotal:0,totalIntegral:0,coupon:null};
        }
    };
    var goodsMap=this.get();
    this.cleanCoupon=function () {
        goodsMap.coupon=null;
        goodsMap.paytotal=goodsMap.total;
        localStorage.setItem("cart",JSON.stringify(goodsMap));
    }
    this.add=function (goodsId,goodsName,goodsPrice,goodsImg,integral) {
        var goods=goodsMap[goodsId];
        if(!goods){
            goods={quantity:0,goodsName:goodsName,goodsPrice:goodsPrice,goodsImg:goodsImg,integral:integral};
        }
        goodsPrice=parseFloat(goods.goodsPrice);
        var total=goodsMap.total;
        // total+=goodsPrice;
        total=accAdd(total,goodsPrice);
        goodsMap.total=total;
        goods.quantity++;
        goodsMap[goodsId]=goods;
        goodsMap.carNum++;
        goodsMap.paytotal=total;
        goodsMap.totalIntegral+=goods.integral;
        localStorage.setItem("cart",JSON.stringify(goodsMap));
    };
    this.sub=function (goodsId) {
        var goods=goodsMap[goodsId];
        if(!goods){
            return;
        }
        var total=goodsMap.total;
        var goodsPrice=goods.goodsPrice;
        // total-=goodsPrice;
        total=accSub(total,goodsPrice);
        goodsMap.total=total;
        goodsMap.paytotal=total;

        var quantity=goods.quantity;
        quantity--;
        if(quantity==0){
            delete goodsMap[goodsId];
        }else{
            goods.quantity=quantity;
            goodsMap[goodsId]=goods;
        }
        goodsMap.carNum--;
        goodsMap.totalIntegral-=goods.integral;
        localStorage.setItem("cart",JSON.stringify(goodsMap));
    }
    this.removeGoods=function (id) {
        var goods=goodsMap[id];
        // goodsMap.total-=goods.quantity*goods.goodsPrice;
        var goodsPriceTotal=accMul(parseFloat(goods.quantity),goods.goodsPrice);

        goodsMap.total=accSub(goodsMap.total,goodsPriceTotal);

        // goodsMap.paytotal-=goods.quantity*goods.goodsPrice;
        goodsMap.paytotal=goodsMap.total;
        goodsMap.carNum-=goods.quantity;
        delete goodsMap[id];
        localStorage.setItem("cart",JSON.stringify(goodsMap));
    }
    this.changeCoupon=function (id,type,discount) {
        // var coupon=goodsMap.coupon;
        var total=goodsMap.total;
        if(type==2){
            discount=accSub(total,accMul(total,discount));
        }
        goodsMap.paytotal=accSub(total,parseFloat(discount));
        if(goodsMap.paytotal<0){
            goodsMap.paytotal=0;
        }
        goodsMap.coupon={id:id,type:type,discount:discount};
        localStorage.setItem("cart",JSON.stringify(goodsMap));
        var submitGoods=new SubmitGoods()
        submitGoods.set(goodsMap);
    }

}

function SubmitGoods() {
    this.get=function () {
        var goodsList=localStorage.getItem("submitGoods");
        if(goodsList){
            return JSON.parse(goodsList);
        }
        return null;
    }
    this.postData=function () {
        var cart=this.get();
        var orderGoodsList=[];
        var couponId=null;
        $.each(cart,function (i,item) {
            if(parseInt(i).toString()=="NaN"){
                return false;
            }
            var orderGoods={};
            orderGoods.goodsId=parseInt(i);
            orderGoods.quantity=item.quantity;
            orderGoodsList.push(orderGoods);
        });
        if(cart.coupon&&cart.coupon.id){
            couponId=cart.coupon.id;
        }
        var data={orderGoodsList:orderGoodsList,couponId:couponId};
        return data;
    };
    this.set=function (goodsList) {
        localStorage.setItem("submitGoods",JSON.stringify(goodsList));
    }
}

//刷新购物车
function flushCart(cart) {
    var cartData=cart.get();
    $('.carNum').html(cartData.carNum);
    $('.totalPrice').html('￥'+cartData.total);
}
$(function () {
    $('.goPay').click(function () {
        var cartData=cart.get();
        if(cartData.carNum==0){
            return;
        }
        var submitGoods=new SubmitGoods();
        submitGoods.set(cartData);
        location.href="/order/submit";
    });
    $('.goCar').click(function () {
        location.href="/order/cart";
    });
})




function accAdd(arg1,arg2){
    var r1,r2,m;
    try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
    try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
    m=Math.pow(10,Math.max(r1,r2))
    return ((arg1*m+arg2*m)/m).toFixed(2);
}

//js 减法计算
//调用：Subtr(arg1,arg2)
//返回值：arg1减arg2的精确结果
function accSub(arg1,arg2){
    var r1,r2,m,n;
    try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
    try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
    m=Math.pow(10,Math.max(r1,r2));
    //last modify by deeka
    //动态控制精度长度
    n=(r1>=r2)?r1:r2;
    return ((arg1*m-arg2*m)/m).toFixed(2);
}

//js 乘法函数
//调用：accMul(arg1,arg2)
//返回值：arg1乘以arg2的精确结果
function accMul(arg1,arg2){
    var m=0,s1=arg1.toString(),s2=arg2.toString();
    try{m+=s1.split(".")[1].length}catch(e){}
    try{m+=s2.split(".")[1].length}catch(e){}
    return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)
}

//js 除法函数
//调用：accDiv(arg1,arg2)
//返回值：arg1除以arg2的精确结果
function accDiv(arg1,arg2){
    var t1=0,t2=0,r1,r2;
    try{t1=arg1.toString().split(".")[1].length}catch(e){}
    try{t2=arg2.toString().split(".")[1].length}catch(e){}
    with(Math){
        r1=Number(arg1.toString().replace(".",""))
        r2=Number(arg2.toString().replace(".",""))
        return (r1/r2)*pow(10,t2-t1);
    }
}
