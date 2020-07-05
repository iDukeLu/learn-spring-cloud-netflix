package com.idukelu.learn.learn.spring.cloud.netflix.eureka.server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Eureka Server 注册中心事件监听器
 * @author duke
 */
@Slf4j
@Component
public class EurekaStateChangeListener {
    /**
     * 监听服务下线事件
     * @param event 服务下线事件
     */
    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        log.info("服务下线：{} {}", event.getAppName(), event.getServerId());
    }

    /**
     * 监听服务注册事件
     * @param event 服务注册事件
     */
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        log.info("服务注册成功：{}", event.getInstanceInfo().getAppName());
    }

    /**
     * 监听服务续约事件
     * @param event 服务续约事件
     */
    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        log.info("服务续约成功：{} {}", event.getAppName(), event.getServerId());
    }

    /**
     * 监听 Eureka 注册中心是否可用
     * @param event Eureka 注册中心是否可用事件
     */
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        log.info("注册中心 启动成功！");
    }

    /**
     * 监听 Eureka Server 启动事件
     * @param event Eureka Server 启动事件
     */
    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        log.info("Eureka Server 启动成功！");
    }
}
