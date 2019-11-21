package com.fzy.shop.util;

public enum  ErrorCode {
	SYSTEM_ERROR(100002, "系统错误"),
    PARAMETER_CHECK_ERROR(400, "参数校验错误"),
    AUTH_VALID_ERROR(701, "用户权限不足"),
    UNLOGIN_ERROR(401, "用户未登录或登录状态超时失效"),
    /*
    100001	一般错误
    100002	系统错误
    100003	配置缺少
    100004	文件上传错误
    100101	签名参数缺失
    100102	接口签名验证失败
    100301	用户已被禁用
    100302	用户不存在
    100303	用户密码错误
    100305	用户在其它设备登录
    100306	用户访问令牌缺失
    100307	用户访问令牌过期
    */

    ;

    private final Integer value;
    private final String message;

    ErrorCode(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public String getCode() {
        return value.toString();
    }

    public static ErrorCode getByCode(Integer value) {
        for (ErrorCode _enum : values()) {
            if (_enum.getValue() == value) {
                return _enum;
            }
        }
        return null;
    }
}
