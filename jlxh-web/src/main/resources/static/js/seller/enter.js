
//表单验证
function checkForm() {
    var err = "";
    if(!verificat.isNotNull($('input[name="personalName"]').val())) {
        err = "<br/>真实名称不能为空";
        qxMsg(err);
        return false;
    }
    if(!verificat.isNotNull($('input[name="telephone"]').val())||!verificat.mobileVer($('input[name="telephone"]').val())) {
        err = "<br/>联系电话非法";
        qxMsg(err);
        return false;
    }
    if(!verificat.isNotNull($('input[name="sellerName"]').val())) {
        err = "<br/>店铺名称不能为空";
        qxMsg(err);
        return false;
    }
    if(!verificat.isNotNull($('select[name="openTime"]').val())) {
        err = "<br/>请选择营业时间";
        qxMsg(err);
        return false;
    }
    if(!verificat.isNotNull($('select[name="closeTime"]').val())) {
        err = "<br/>请选择营业时间";
        qxMsg(err);
        return false;
    }
    if(!verificat.isNotNull($('input[name="address"]').val())) {
        err = "<br/>店铺地址不能为空";
        qxMsg(err);
        return false;
    }
    if(!verificat.isNotNull($('textarea[name="detailedAddress"]').val())) {
        err = "<br/>详细地址不能为空";
        qxMsg(err);
        return false;
    }
    if(!verificat.isNotNull($('input[name="shopImg"]').val())) {
        err = "<br/>店铺照片不能为空";
        qxMsg(err);
        return false;
    }
    return true;
}

function checkAddForm(){
    var err = "";
    if(!verificat.isNotNull($('input[name="idCardFront"]').val())||!verificat.isNotNull($('input[name="idCardBack"]').val())||!verificat.isNotNull($('input[name="handTheIdCard"]').val())||!verificat.isNotNull($('input[name="businessLicence"]').val())) {
            err = "<br/>图片上传不能为空";
            qxMsg(err);
            return false;
    }
   return true;
}

function nextBtn(){
    if(checkForm()){
        $("#enterForm").submit();
    }
}

function subBtn(){
    if(checkAddForm()){
        $("#enterAddForm").submit();
    }
}








