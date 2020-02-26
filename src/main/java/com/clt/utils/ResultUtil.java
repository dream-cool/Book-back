package com.clt.utils;


import com.clt.enums.ResultEnum;

/**
 * @author clt
 * @create 2020/2/26 10:45
 */
public class ResultUtil<T> {
    private long code;
    private String message;
    private T data;

    protected ResultUtil() {
    }

    protected ResultUtil(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResultUtil<T> success(T data) {
        return new ResultUtil<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> ResultUtil<T> success(T data, String message) {
        return new ResultUtil<T>(ResultEnum.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param error 错误码
     */
    public static <T> ResultUtil<T> failed(ResultEnum error) {
        return new ResultUtil<T>(error.getCode(), error.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> ResultUtil<T> failed(String message) {
        return new ResultUtil<T>(ResultEnum.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> ResultUtil<T> failed() {
        return failed(ResultEnum.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> ResultUtil<T> validateFailed() {
        return failed(ResultEnum.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> ResultUtil<T> validateFailed(String message) {
        return new ResultUtil<T>(ResultEnum.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ResultUtil<T> unauthorized(T data) {
        return new ResultUtil<T>(ResultEnum.UNAUTHORIZED.getCode(), ResultEnum.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ResultUtil<T> forbidden(T data) {
        return new ResultUtil<T>(ResultEnum.FORBIDDEN.getCode(), ResultEnum.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
