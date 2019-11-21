//分页工具
function Page(url,limit) {
    var offset=0;
    var hasMore=true;
    limit=limit==null?10:limit;
    this.getList=function getList(){
        if(!hasMore){
            return null;
        }
        layer.open({type: 2});
        var postData={offset:offset,limit:limit};
        var result=null;
        $.ajax({
            url:url,
            type:'get',
            data:postData,
            async:false,
            success:function(data){
                var datalength=data.length;
                result=data;
                if(datalength==0||datalength<limit){
                    hasMore=false;
                }
                offset+=limit;
            }
        })
        setTimeout(function () {
            layer.closeAll();
        },500);
        return result;
    };
}