var prefix="/wx/shop/tGoods";
var loading;
var app_goods=new Vue({
    el:".claffy",
    data: {
        item:{}
    },updated: function () {
        layer.close(loading);
        flushGoodsNum();
    }
});
//根据类型id获取 类下的商品
function getTGoodsListByClassId(_result) {
    loading = layer.open({type: 2,shadeClose:false});
    var id= $(_result).attr("data-id");
    $.ajax({
        type: 'POST',
        url: prefix+"/list/"+id,
        success: function(result){
            if(result.status=="100000")  {
                app_goods.item=result.data;

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
//商品详情
function tGoodsDetail(_dataInfo){
    var id= $(_dataInfo).attr("data-id");
    window.location.href=prefix+"/tGoodsDetail/"+id;
}

//根据购物车数量刷新商品数量
function flushGoodsNum() {
    var cartData = cart.get();
    var goodsList = $(".goosList");
    $.each(goodsList, function (i, item) {
        var itemId = $(item).attr('data-id');
        console.log(itemId);
        var numItem = $(item).find('.num');
        if (cartData[itemId]) {
            $(item).find('.subBtn').removeClass('yincang');
            numItem.removeClass("yincang");
            numItem.html(cartData[itemId].quantity);
        } else {
            $(item).find('.subBtn').addClass('yincang');
            numItem.addClass("yincang");
            numItem.html('0');
        }

    })
}


    /**
     * 暂时没用
     * @param _result
     */
    function load(_result) {
        var id = $(_result).attr("data-id");
        var url = prefix + "/list/" + id;
        var page = new Page(url);
        loadData();
        function loadData() {
            var list = page.getList();
            if (list == null) {
                return;
            }
            $.each(list, function (i, item) {
                var dl = item;
                $('.claffy').append(
                    '<div class="goosList"   data-id="' + dl.id + '" data-img="' + dl.img + '" data-score="' + dl.score + '">'
                    + '<div onclick="tGoodsDetail(this)">'
                    + '<img src="' + dl.img + '" />'
                    + '<div class="priceName">'
                    + ' <p>' + dl.title + '</p>'
                    + '<span>￥' + dl.prices + '</span>'
                    + '</div>'
                    + '</a>'
                    + '</div>'
                    + '<div class="numBox centerboth">'
                    + '<a href="javascript:;" class="subBtn yincang" onclick="subBtn(this)"></a>'
                    + '<span class="num yincang">0</span>'
                    + '<a href="javascript:;" class="addBtn" onclick="addBtn(this)"></a>'
                    + '</div>'
                    + '</div>'
                );
            });
        }

        //滚动条到页面底部加载更多案例 
        $(window).scroll(function () {
            var scrollTop = $(this).scrollTop();    //滚动条距离顶部的高度
            var scrollHeight = $(document).height();   //当前页面的总高度
            var clientHeight = $(this).height();    //当前可视的页面高度
            // console.log("top:"+scrollTop+",doc:"+scrollHeight+",client:"+clientHeight);
            if (scrollTop + clientHeight >= scrollHeight) {   //距离顶部+当前高度 >=文档总高度 即代表滑动到底部 
                //滚动条到达底部
                loadData();

            }
        });
    }
