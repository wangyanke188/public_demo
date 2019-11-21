$(function () {
    var classid=$(".scroller ul  .cur").attr("data-id");
    var url=pageSgoodsurlUrl(classid,false);
    setDataList(url);

})

function setDataList(url) {
    var page=new PageData(url);
    loadDatasg();
    function loadDatasg(){
        var list=page.getList().data;

        if(list==null){
            return;
        }

        $.each(list,function (i, item) {
            var dl=item;
            $('.scoreCount').append(
                '<li onclick="goodsDetail(this)" data-id="'+dl.id+'">'
                /*+'<i class="fl_tit">'+dl.typename+'</i>'*/
                +'<a href="javascript:;">'
                +'<img src="'+dl.img+'" />'
                +'<div class="gms">'
                +'<p>'+dl.title+'</p>'
                +'<span>'+dl.score+'<b>积分</b></span>'
                +'</div>'
                +'</a>'
                +'</li>'

            );
        });
    }


    //滚动条到页面底部加载更多案例 
    $(window).scroll(function(){
        var scrollTop = parseFloat($(this).scrollTop());    //滚动条距离顶部的高度
        var scrollHeight = parseFloat($(document).height());   //当前页面的总高度
        var clientHeight = parseFloat($(this).height());    //当前可视的页面高度
        // console.log("top:"+scrollTop+",doc:"+scrollHeight+",client:"+clientHeight);
        if(scrollTop + clientHeight >= scrollHeight){   //距离顶部+当前高度 >=文档总高度 即代表滑动到底部 
            //滚动条到达底部
                loadDatasg();


        }
//                else if(scrollTop<=0){
// //滚动条到达顶部
//                    alert(4)
//                    //滚动条距离顶部的高度小于等于0 TODO
//
//                }
    });
}


/**
 * 获取积分商品
 */
var app_SGoodsL=new Vue({
    el: '.scoreCount',
    data:{
       sGoodsL:[]
    }
});

function getScoreSGoods() {
    $.ajax({
        type: 'POST',
        url: "/wx/shop/sGoods/list/0",
        success: function(result){
            if(result.status=="100000")  {
                var list=result.data;
                app_SGoodsL.sGoodsL=list;
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
function getScoreSGoodsByClassId(node) {
    var classid= $(node).attr("data-id");

    $(".scoreCount").empty();
    var flag=false;
    if($('.pxBtn').hasClass("cur")){
        flag=true;
    }

    setDataList(pageSgoodsurlUrl(classid,flag));
}

/**
 * 分页数据url
 * @param classid
 * flag  是否倒序
 */
function pageSgoodsurlUrl(classid,flag){
    var x = 100;
    var y = 0;
    var rand = parseInt(Math.random() * (x - y + 1) + y);
    if(flag){
        return "/wx/shop/sGoods/list?sort=desc&classid="+classid+"&v="+rand;
    }else{
        return "/wx/shop/sGoods/list?classid="+classid+"&v="+rand;
    }
}
/**
 * 商品详情
 * @param _getdetail
 */
function goodsDetail(_getdetail) {
        var id= $(_getdetail).attr("data-id");
        window.location.href="/wx/shop/sGoods/detail/"+id;

}

/**
 * 我的积分明细
 */
function myScoreOrder(){
   window.location.href="/member/integral";
}

/**
 * 兑换过的商品
 */
function myScoreGoods(){
    window.location.href="/member/integral/ex";

}

