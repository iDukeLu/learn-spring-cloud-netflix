package com.idukelu.learn.learn.spring.cloud.netflix.common.response;

/**
 * 响应状态接口
 *
 * @author duke
 * @date 2020.04.25
 */
public interface IResultStatus {

    /**
     * 获取响应码
     * @return 响应码
     */
    int getCode();

    /**
     * 获取响应信息
     * @return 响应信息
     */
    String getMsg();
}
