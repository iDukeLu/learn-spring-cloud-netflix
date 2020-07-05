package com.idukelu.learn.learn.spring.cloud.netflix.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 抽象响应类
 *
 * @author duke
 * @date 2020.07.05
 */
@Getter
@AllArgsConstructor
public class Result<T> implements IResult<T> {

    public static final int MIN_SUCCESS_CODE = 1;
    public static final int MAX_SUCCESS_CODE = 999;
    public static final int MIN_FAILURE_CODE = -999;
    public static final int MAX_FAILURE_CODE = -1;
    public static final int MIN_ERROR_CODE = -1999;
    public static final int MAX_ERROR_CODE = -1000;

    private static final Result<?> DEFAULT_SUCCESS_Result =
            new Result<>(ResultStatusEnum.SUCCESS.getCode(),
                    ResultStatusEnum.SUCCESS.getMsg(), null);

    private static final Result<?> DEFAULT_FAILURE_Result =
            new Result<>(ResultStatusEnum.FAILURE.getCode(),
                    ResultStatusEnum.FAILURE.getMsg(), null);

    private static final Result<?> DEFAULT_ERROR_Result =
            new Result<>(ResultStatusEnum.INTERNAL_SERVER_ERROR.getCode(),
                    ResultStatusEnum.INTERNAL_SERVER_ERROR.getMsg(), null);

    private int code;

    private String msg;

    private T data;

    // success

    public static Result<?> success() {
        return DEFAULT_SUCCESS_Result;
    }

    public static <T> Result<T> success(String msg) {
        return success(ResultStatusEnum.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> success(int code, String msg) {
        return success(code, msg, null);
    }

    public static <T> Result<T> success(T data) {
        return success(ResultStatusEnum.SUCCESS, data);
    }

    public static <T> Result<T> success(String msg, T data) {
        return success(ResultStatusEnum.SUCCESS.getCode(), msg, data);
    }

    public static <T> Result<T> success(int code, String msg, T data) {
        assertSuccessCode(code);
        return new Result<T>(code, msg, data);
    }

    public static <T> Result<T> success(IResultStatus resultStatus) {
        return success(resultStatus, null);
    }

    public static <T> Result<T> success(IResultStatus resultStatus, T data) {
        assertSuccessCode(resultStatus.getCode());
        return new Result<T>(resultStatus.getCode(), resultStatus.getMsg(), data);
    }


    // failure

    public static Result<?> failure() {
        return DEFAULT_FAILURE_Result;
    }

    public static <T> Result<T> failure(String msg) {
        return failure(ResultStatusEnum.FAILURE.getCode(), msg);
    }

    public static <T> Result<T> failure(int code, String msg) {
        return failure(code, msg, null);
    }

    public static <T> Result<T> failure(T data) {
        return failure(ResultStatusEnum.FAILURE, data);
    }

    public static <T> Result<T> failure(String msg, T data) {
        return failure(ResultStatusEnum.FAILURE.getCode(), msg, data);
    }

    public static <T> Result<T> failure(int code, String msg, T data) {
        assertFailureCode(code);
        return new Result<>(code, msg, data);
    }

    public static <T> Result<T> failure(IResultStatus resultStatus) {
        return failure(resultStatus, null);
    }

    public static <T> Result<T> failure(IResultStatus resultStatus, T data) {
        assertFailureCode(resultStatus.getCode());
        return new Result<>(resultStatus.getCode(), resultStatus.getMsg(), data);
    }


    // error

    public static Result<?> error() {
        return DEFAULT_ERROR_Result;
    }

    public static <T> Result<T> error(String msg) {
        return error(ResultStatusEnum.INTERNAL_SERVER_ERROR.getCode(), msg);
    }

    public static <T> Result<T> error(int code, String msg) {
        assertErrorCode(code);
        return new Result<>(code, msg, null);
    }

    public static <T> Result<T> error(IResultStatus resultStatus) {
        assertErrorCode(resultStatus.getCode());
        return new Result<>(resultStatus.getCode(), resultStatus.getMsg(), null);
    }


    /**
     * 判断成功码有些范围
     * @param code 成功码
     */
    private static void assertSuccessCode(int code) {
        if (code < MIN_SUCCESS_CODE || code > MAX_SUCCESS_CODE) {
            throw new RuntimeException("the success code range must be 1 ~ 999");
        }
    }

    /**
     * 判断失败码有些范围
     * @param code 成功码
     */
    private static void assertFailureCode(int code) {
        if (code < MIN_FAILURE_CODE || code > MAX_FAILURE_CODE) {
            throw new RuntimeException("the success code range must be -999 ~ -1");
        }
    }

    /**
     * 判断错误码有些范围
     * @param code 成功码
     */
    private static void assertErrorCode(int code) {
        if (code < MIN_ERROR_CODE || code > MAX_ERROR_CODE) {
            throw new RuntimeException("the error code range must be -1999 ~ -1000");
        }
    }
}
