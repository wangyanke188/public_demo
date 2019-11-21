

var toppath = "/"
function returnIndex(){//返回首页
    window.location.href=toppath;
}

//电话
var app_telephone=new Vue({
    el:'#navlink',
    data:{
        phone:''
    }
});
//客服二维码
var app_qrcode=new Vue({
    el:'.qrcode',
    data:{
        qrcode:''
    }
});
function QRcodeKefu(){//客服信息
    $.ajax({
        type: 'POST',
        url: toppath+"/setup/info",
        success: function(result){
            if(result.status=="100000")  {
                app_telephone.phone=result.data.serviceTelephone;
                app_qrcode.qrcode=result.data.serviceImg;
                console.log("---------------客服电话----------"+app_telephone.phone);
                console.log("---------------客服二维码----------"+app_qrcode.qrcode);
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
