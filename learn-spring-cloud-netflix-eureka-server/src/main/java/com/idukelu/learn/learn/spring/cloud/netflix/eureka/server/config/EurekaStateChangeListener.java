package com.idukelu.learn.learn.spring.cloud.netflix.eureka.server.config;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Eureka Server 注册中心事件监听器
 * @author duke
 */
@Component
public class EurekaStateChangeListener {
    /**
     * 监听服务下线事件
     * @param event 服务下线事件
     */
    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        System.out.println(event.getServerId() + "\t" + event.getAppName() + " 服务下线");
    }

    /**
     * 监听服务注册事件
     * @param event 服务注册事件
     */
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.out.println(instanceInfo.getAppName() + "进行注册");
    }

    /**
     * 监听服务续约事件
     * @param event 服务续约事件
     */
    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        System.out.println(event.getServerId() + "\t" + event.getAppName() + " 服务进行续约");
    }

    /**
     * 监听 Eureka 注册中心是否可用
     * @param event Eureka 注册中心是否可用事件
     */
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        System.out.println("注册中心 启动");
    }

    /**
     * 监听 Eureka Server 启动事件
     * @param event Eureka Server 启动事件
     */
    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        System.out.println("Eureka Server 启动");
    }
}
