//验证手机号
function phoneUtil(phone){
    var flag=true;
    //手机号正则
    var phoneReg = /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/;
    //电话
    if (!phoneReg.test(phone)) {
        layer.open({
            content: '请输入有效的手机号码或邮箱！'
            ,skin: 'msg'
            ,time: 2 //2秒后自动关闭
        });
        flag=false;
    }
    return flag;
}
//邮箱验证
function emailUtil(email){
    // var regex=/^[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])+$/;

    var regex = /^[\w\-\.]+@[\w\-\.]+(\.\w+)+$/;
    //判断
    if(!regex.test(email)){

        return false;
    }
    return true;


}
//分页工具
function PageData(url,limit) {
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



