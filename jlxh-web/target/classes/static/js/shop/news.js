$(function () {
    load();
})
function addcur(_class) {
    $(".listCount").empty();
    $(".cur").removeClass("cur");
    $(_class).addClass("cur");
    load();
}
function load() {
    var type=$(".cur").attr("data-type");
    var url="/wx/shop/news/list/"+type;
    var page=new Page(url);
    loadData();
    function loadData(){
        var list=page.getList();
        if(list==null){
            return;
        }
        $.each(list,function (i, item) {
            var dl=item;
            $('.listCount').append('<li  onclick="msgDeatail(this)" data-id="'+dl.id+'" data-type="'+type+'">'
                +'<a href="javascript:;">'
                +'<p>'+dl.title+'</p>'
                +'<span>'+dl.newstime+'</span>'
                +'</a>'
                +'</li>'

            );
        });
    }
    //滚动条到页面底部加载更多案例 
    $(window).scroll(function(){
        var scrollTop = $(this).scrollTop();    //滚动条距离顶部的高度
        var scrollHeight = $(document).height();   //当前页面的总高度
        var clientHeight = $(this).height();    //当前可视的页面高度
        // console.log("top:"+scrollTop+",doc:"+scrollHeight+",client:"+clientHeight);
        if(scrollTop + clientHeight >= scrollHeight){   //距离顶部+当前高度 >=文档总高度 即代表滑动到底部 
            //滚动条到达底部
            loadData();

        }
//                else if(scrollTop<=0){
// //滚动条到达顶部
//                    alert(4)
//                    //滚动条距离顶部的高度小于等于0 TODO
//
//                }
    });
}
function msgDeatail(_dataDetail) {
    var id=$(_dataDetail).attr("data-id");
    var type=$(_dataDetail).attr("data-type");
    window.location.href="/wx/shop/news/detail/"+id+"/"+type;
}