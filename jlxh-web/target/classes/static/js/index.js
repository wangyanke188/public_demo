// var prefix = "/wx/sGoods"
//
// $(function() {
//     load();
// });
// function load() {
//     $.ajax({
//         type: 'POST',
//         url: prefix+"/list/0",
//         success: function(result){
//             if(result.status=="100000")  {
//                 var list=result.data;
//             for (var i = 0; i <list.length ; i++) {
//
//                 var data=list[i];
//                 var imgurl=data.img;
//                 var html='';
//
//                 html+='<li >';
//                     html+='<a href="javascript:;">';
//                     html+='<img  src="'+imgurl+'" />';
//                     html+='<div class="gms">';
//                     html+='<p>'+data.title+'</p>';
//                     html+='<span>'+data.score+'<b>积分</b></span>';
//                     html+='</div>';
//                     html+='</a>';
//                     html+='</li>';
//                 $(".scoreCount").append(html);
//             }
//             }else{
//                 layer.open({
//                     content:result.message,
//                     skin:'msg',
//                     time:2
//                 })
//             }
//         }
//
//     });
// }
/*
* 注意：
* 1. 所有的JS接口只能在公众号绑定的域名下调用，公众号开发者需要先登录微信公众平台进入“公众号设置”的“功能设置”里填写“JS接口安全域名”。
* 2. 如果发现在 Android 不能分享自定义内容，请到官网下载最新的包覆盖安装，Android 自定义分享接口需升级至 6.0.2.58 版本及以上。
* 3. 常见问题及完整 JS-SDK 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
*
* 开发中遇到问题详见文档“附录5-常见错误及解决办法”解决，如仍未能解决可通过以下渠道反馈：
* 邮箱地址：weixin-open@qq.com
* 邮件主题：【微信JS-SDK反馈】具体问题
* 邮件内容说明：用简明的语言描述问题所在，并交代清楚遇到该问题的场景，可附上截屏图片，微信团队会尽快处理你的反馈。
*/


