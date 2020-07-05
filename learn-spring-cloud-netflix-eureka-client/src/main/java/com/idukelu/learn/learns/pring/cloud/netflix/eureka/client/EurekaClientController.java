package com.idukelu.learn.learns.pring.cloud.netflix.eureka.client;

import com.idukelu.learn.learn.spring.cloud.netflix.common.response.IResult;
import com.idukelu.learn.learn.spring.cloud.netflix.common.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Eureka Client Controller
 *
 * @author duke
 * @date 2020.07.05
 */
@Slf4j
@RestController
@RequestMapping("/eureka")
public class EurekaClientController {
    
    @GetMapping("/client")
    public IResult<?> get() {
        return Result.success();
    }
}
