//保存反馈的问题
function saveFeedBack(){

var value=$("#saveValue").val();
var content=$("#content").val();
var phoneS;
var emailS;
if(content==null||content==''){
    layer.open({
        content: '您的意见或建议！'
        ,skin: 'msg'
        ,time: 2 //2秒后自动关闭
    });
    return false;
}
if(value==null||value==''){
    layer.open({
        content: '请输入您的手机号或邮箱！'
        ,skin: 'msg'
        ,time: 2 //2秒后自动关闭
    });
    return false;
}else {
    var emailflag=emailUtil(value);
    var phoneflag=phoneUtil(value);

    if(phoneflag){
        phoneS=value;
    }
    if(emailflag){
        emailS=value;
    }
    if(!phoneflag&&!emailflag){
        layer.open({
            content: '请输入有效的邮箱或手机号！'
            ,skin: 'msg'
            ,time: 2 //2秒后自动关闭
        });
        return false;
    }
}
var data_param={
    content:content,
    phone:phoneS,
    email:emailS
}

    $.ajax({
        type: 'POST',
        url:"/wx/shop/feedback/save",
        data:JSON.stringify(data_param),
        contentType:"application/json",
        datatype:"json",
        async : false,
        success: function(result){
            if(result.status=="100000")  {
                layer.open({
                    content:result.message,
                    skin:'msg',
                    time:2
                })
                //返回页
                window.location.href='/member/mine';
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