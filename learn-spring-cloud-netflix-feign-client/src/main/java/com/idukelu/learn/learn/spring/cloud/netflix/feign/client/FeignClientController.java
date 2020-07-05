package com.idukelu.learn.learn.spring.cloud.netflix.feign.client;

import com.idukelu.learn.learn.spring.cloud.netflix.common.response.IResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/feign")
public class FeignClientController {

    @Autowired
    private FeignService feignService;
    
    @GetMapping("/client")
    public IResult<?> get() {
        return feignService.get();
    }
}
