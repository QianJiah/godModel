package com.loong.base.error;

/**
 * author: Hao
 * date: 2019/10/9 16:08
 * description:
 */
public class ErrorMsgBean extends RuntimeException {
    /**
     * 登录错误的回复
     * {"data":null,"errorCode":-1,"errorMsg":"账号密码不匹配！"}
     */

    private int code;
    private String msg;

    public ErrorMsgBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
