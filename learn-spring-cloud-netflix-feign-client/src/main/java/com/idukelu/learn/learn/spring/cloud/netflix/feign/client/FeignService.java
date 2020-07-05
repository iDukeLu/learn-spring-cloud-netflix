package com.idukelu.learn.learn.spring.cloud.netflix.feign.client;

import com.idukelu.learn.learn.spring.cloud.netflix.common.response.IResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TODO: 编辑说明信息
 *
 * @author duke
 * @date 2020.07.05
 */
@FeignClient("eureka-client")
public interface FeignService {

    @GetMapping("/eureka/client")
    IResult<?> get();
}
