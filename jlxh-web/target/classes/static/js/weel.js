$(function(){
	var turnplate={
		restaraunts:[],				//大转盘奖品名称
		colors:[],	                //大转盘奖品区块对应背景颜色
		fontcolors:[],				//大转盘奖品区块对应文字颜色
		outsideRadius:255,			//大转盘外圆的半径
		textRadius:185,				//大转盘奖品位置距离圆心的距离
		insideRadius:85,			//大转盘内圆的半径
		startAngle:0,				//开始角度
		bRotate:false				//false:停止;ture:旋转
	};
		
	var lock=true;
	var angles=0;//
	var arry=new Array();
    $.ajax({
        url:"/activity/getPrizeList",    //请求的url地址
        dataType:"json",   //返回格式为json
        async:false,//请求是否异步，默认为异步，这也是ajax重要特性
        type:"POST",   //请求方式
        success:function(result){
            if(result.status=="100000")  {
                var prizeList=result.data;

                $.each(prizeList,function (i,item) {
                    arry.push(item.prizeName)
                })
                arry.push("谢谢惠顾");
            }else{
                layer.open({
                    content:result.message,
                    skin:'msg',
                    time:2
                })
            }
        },
        error:function(){
            layer.open({
                content:'请求错误',
                skin:'msg',
                time:2
            })
        }
    });
turnplate.restaraunts = arry;
colorsArr = ['#ffffff','#fdb449','#ffffff','#fdb449','#ffffff',];
returnColor();
function returnColor(){
	var a=turnplate.restaraunts.length;
	var color=turnplate.restaraunts.map(function(item,index,array){
			if(a%2){
				return (index+1)==a? colorsArr[2]:colorsArr[index%2]
			}else{
				return colorsArr[index%2];
			}
		})
	turnplate.colors=color;
}

/*
function rnd(n, m){
	var random = Math.floor(Math.random()*(m-n+1)+n);
	return random;
}*/
var rotateTimeOut = function (){
	$('#wheelcanvas').rotate({
		angle:0,
		animateTo:2160,
		duration:8000,
		callback:function (){
			alert('网络超时，请检查您的网络设置！');
		}
	});
};




//旋转转盘 item:奖品位置; txt：提示语;
var rotateFn = function (item, txt,status){
	var angles = item * (360 / turnplate.restaraunts.length) - (360 / (turnplate.restaraunts.length*2));
	if(angles<270){
		angles = 270 - angles; 
	}else{
		angles = 360 - angles + 270;
	}
	$('#wheelcanvas').stopRotate();
	$('#wheelcanvas').rotate({
		angle:0,
		animateTo:angles+1800,
		duration:8000,
		callback:function (){
			turnplate.bRotate = !turnplate.bRotate;
            if(status==0){
            	var html="<p class=\"captit\">谢谢参与</p>很遗憾 <br />没有中奖";
            }
            if(status==1){
                var html="<p class=\"captit\">中奖了</p>获得"+txt+" <br />在我的奖品中查看";
            }
            $("#result").html(html);
            $('.nozjCount').show();
            $('#tupBtn').click(function (){
                roll();
            })
		}
	});
};





function drawRouletteWheel() {    
	var canvas = $('body').find("#wheelcanvas").get(0);
	if (canvas.getContext) {
	  //根据奖品个数计算圆周角度
	  var arc = Math.PI / (turnplate.restaraunts.length/2);
	  var ctx = canvas.getContext("2d");
	  //在给定矩形内清空一个矩形
	  ctx.clearRect(0,0,510,510);
	  //strokeStyle 属性设置或返回用于笔触的颜色、渐变或模式  
	  ctx.strokeStyle = "#333333";
	  //font 属性设置或返回画布上文本内容的当前字体属性
	  ctx.font = '24px Microsoft YaHei';      
	  for(var i = 0; i < turnplate.restaraunts.length; i++) {       
		  var angle = turnplate.startAngle + i * arc;
		  ctx.fillStyle = turnplate.colors[i];
		  ctx.beginPath();
		  //arc(x,y,r,起始角,结束角,绘制方向) 方法创建弧/曲线（用于创建圆或部分圆）    
		  ctx.arc(255, 255, turnplate.outsideRadius, angle, angle + arc, false);    
		  ctx.arc(255, 255, turnplate.insideRadius, angle + arc, angle, true);
		  ctx.stroke();  
		  ctx.fill();
		  //锁画布(为了保存之前的画布状态)
		  ctx.save();   
		  //----绘制奖品开始----
		  ctx.fillStyle = "#333333";
		  var text = turnplate.restaraunts[i];
		  var line_height = 28;
		  //translate方法重新映射画布上的 (0,0) 位置
		  ctx.translate(255 + Math.cos(angle + arc / 2) * turnplate.textRadius, 255 + Math.sin(angle + arc / 2) * turnplate.textRadius);
		  //rotate方法旋转当前的绘图
		  ctx.rotate(angle + arc / 2 + Math.PI / 2);
		  /** 下面代码根据奖品类型、奖品名称长度渲染不同效果，如字体、颜色、图片效果。(具体根据实际情况改变) **/
		 
		  	if(text.length>6){//奖品名称长度超过一定范围 
			  	text = text.substring(0,4)+"||"+text.substring(4);
			  	var texts = text.split("||");
			  	for(var j = 0; j<texts.length; j++){
				  	ctx.fillText(texts[j], -ctx.measureText(texts[j]).width / 2, j * line_height);
			  	}
		  	}else{
		  		//在画布上绘制填色的文本。文本的默认颜色是黑色
			  	//measureText()方法返回包含一个对象，该对象包含以像素计的指定字体宽度
			  	ctx.fillText(text, -ctx.measureText(text).width / 2, 0);
		  	}
		  	
		  	ctx.restore();
		  //----绘制奖品结束----
	  }     
	} 
}
	function myPrize(){
        $.ajax({
            url:"/activity/myPrize",    //请求的url地址
            dataType:"json",   //返回格式为json
            async:false,
            type:"POST",   //请求方式
            success:function(result){
                if(result.status=="100000")  {
                    $("#my_prize").html("");
                    var html="";
                    var dataList=result.data;
                    $.each(dataList,function(i,item){
                        html+='<li>' +
                                '<p>'+item.prizeName+'</p>' +
                                '<span>'+item.createTime+'</span>' +
                            '</li>'
                    })
                    $("#my_prize").append(html);
                }
            },
        });
    }
	
	

	window.onload=function(){
		drawRouletteWheel();
	};

	$(document).ready(function(){
        roll();
	});

	function roll(){
        $('#tupBtn').click(function (){
            var item;
            $.ajax({
                url:"/activity/roll",    //请求的url地址
                dataType:"json",   //返回格式为json
                async:false,//请求是否异步，默认为异步，这也是ajax重要特性
                type:"POST",   //请求方式
                beforeSend:function(){
                    $("#tupBtn").unbind("click");
                },
                success:function(result){
                    if(result.status=="100000")  {
                        item=result.data.index;
                        if(turnplate.bRotate)return;
                        turnplate.bRotate = !turnplate.bRotate;
                        //获取随机数(奖品个数范围内)
                        //奖品数量等于10,指针落在对应奖品区域的中心角度[252, 216, 180, 144, 108, 72, 36, 360, 324, 288]
                        rotateFn(item, turnplate.restaraunts[item-1],result.data.status);
                        myPrize();
                    }else{
                        var html='<p class="captit"></p>很遗憾 <br/>'+result.data;
                        $("#result").html(html);
                        $('.nozjCount').show();
                        roll();
                    }
                    $("#tupBtn").attr('disabled',true)//在提交成功之后重新启用该按钮
                },
                error:function(){
                    layer.open({
                        content:'请求错误',
                        skin:'msg',
                        time:2
                    })
                    roll();
                }
            });
        })

    }

});
