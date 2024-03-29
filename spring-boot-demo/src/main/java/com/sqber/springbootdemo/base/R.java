package com.sqber.springbootdemo.base;

/**
 * 统一结果类
 *
 */
public class R {

    private static final int SUCCESS = 1;
    private static final int ERROR = 0;
    private static final int ValidateFailure = 2;

    private int code;
    private Object data;
    private String msg;

    private R(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 参数验证失败
     *
     * @param msg
     * @return
     */
    public static R warn(String msg) {
        return new R(ValidateFailure, msg, "");
    }

    /**
     * 出错
     *
     * @param msg
     * @return
     */
    public static R error(String msg) {
        return new R(ERROR, msg, "");
    }

    /**
     * 出错
     *
     * @return
     */
    public static R error() {
        return new R(ERROR, "服务繁忙,请稍后重试", "");
    }


    /**
     * 成功
     *
     * @return
     */
    public static R success() {
        return new R(SUCCESS, "", "");
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static R success(Object data) {
        return new R(SUCCESS, "", data);
    }

    /**
     * 成功
     *
     * @param data
     * @param msg
     * @return R
     */
    public static R success(Object data, String msg) {
        return new R(SUCCESS, msg, data);
    }

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}
