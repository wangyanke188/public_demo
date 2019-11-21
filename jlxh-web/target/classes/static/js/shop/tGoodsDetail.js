

var goodsPath="/wx/shop/tGoods"
//获取商品的详情根据id
var app_tGoodsDetail=new Vue({
    el:"#goodsInfo",
    data:{
        tgoods:'',
        bannerList:[]
    }
});
var goods=null;
function getTGoodsListByClassId(id) {

    $.ajax({
        type: 'POST',
        url: goodsPath+"/find/"+id,
        success: function(result){
            goods=result.data;
            if(result.status=="100000")  {
                app_tGoodsDetail.tgoods=result.data;
               var imgmore=result.data.imgmore;
               if(imgmore!=null){
                   var imgs=imgmore.split(',');
                   console.log(imgs instanceof Array);//true
                   app_tGoodsDetail.bannerList=imgs;
               }

            }else{
                layer.open({
                    content:result.message,
                    skin:'msg',
                    time:2
                })
            }
        }

    });
}