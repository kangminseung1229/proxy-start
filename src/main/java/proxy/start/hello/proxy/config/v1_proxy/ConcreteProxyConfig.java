package proxy.start.hello.proxy.config.v1_proxy;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import proxy.start.hello.proxy.app.v2.OrderControllerV2;
import proxy.start.hello.proxy.app.v2.OrderRepositoryV2;
import proxy.start.hello.proxy.app.v2.OrderServiceV2;
import proxy.start.hello.proxy.config.v1_proxy.concrete_proxy.OrderControllerConcreteProxy;
import proxy.start.hello.proxy.config.v1_proxy.concrete_proxy.OrderRepositoryConcreteProxy;
import proxy.start.hello.proxy.config.v1_proxy.concrete_proxy.OrderServiceConcreteProxy;
import proxy.start.hello.proxy.trace.LogTrace;

@Configuration
@Slf4j
public class ConcreteProxyConfig {
    @Bean
    public OrderControllerV2 orderControllerV2(LogTrace logTrace) {

        log.info("orderControllerV2 빈등록 완료");
        OrderControllerV2 controllerImpl = new
                OrderControllerV2(orderServiceV2(logTrace));
        return new OrderControllerConcreteProxy(controllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV2 orderServiceV2(LogTrace logTrace) {
        OrderServiceV2 serviceImpl = new
                OrderServiceV2(orderRepositoryV2(logTrace));
        return new OrderServiceConcreteProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV2 orderRepositoryV2(LogTrace logTrace) {
        OrderRepositoryV2 repositoryImpl = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(repositoryImpl, logTrace);
    }
}