$().ready(function() {
    Date.prototype.format = function(format){
        var o = {
            "M+" : this.getMonth()+1, //month
            "d+" : this.getDate(),    //day
            "h+" : this.getHours(),   //hour
            "m+" : this.getMinutes(), //minute
            "s+" : this.getSeconds(), //second
            "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
            "S" : this.getMilliseconds() //millisecond
        }
            if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
                (this.getFullYear()+"").substr(4 - RegExp.$1.length));
            for(var k in o)if(new RegExp("("+ k +")").test(format))
                format = format.replace(RegExp.$1,
                    RegExp.$1.length==1 ? o[k] :
                        ("00"+ o[k]).substr((""+ o[k]).length));
            return format;
        }
        var start = {
            elem : "#prizeStartTime",
            format : "YYYY-MM-DD ",
            max : "2099-06-16 23:59:59",
            istime : false,
            istoday : true,
            choose : function(datas) {
                end.min = datas;
                end.start = datas
            }
        };
    var end = {
        elem : "#prizeEndTime",
        format : "YYYY-MM-DD ",
        max : "2099-06-16 23:59:59",
        istime : false,
        istoday : true,
        choose : function(datas) {
            end.min = datas;
            end.start = datas
        }
    };
        laydate(start);
        laydate(end);
    $('.summernote').summernote({
        height : '220px',
        lang : 'zh-CN',
        callbacks: {
            onImageUpload: function(files, editor, $editable) {
                sendFile(files);
            }
        }
    });
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
    var content_sn = $("#content_sn").summernote('code');
    $("#aboutUsContent").val(content_sn);
	$.ajax({
		cache : true,
		type : "POST",
		url : "/sys/setup/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				layer.msg("操作成功");
			} else {

			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}