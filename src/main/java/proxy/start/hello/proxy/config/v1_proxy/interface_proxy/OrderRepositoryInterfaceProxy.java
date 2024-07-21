package proxy.start.hello.proxy.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import proxy.start.hello.proxy.app.v1.OrderRepositoryV1;
import proxy.start.hello.proxy.app.v1.OrderRepositoryV1Impl;
import proxy.start.hello.proxy.app.v1.OrderServiceV1;
import proxy.start.hello.proxy.trace.LogTrace;
import proxy.start.hello.proxy.trace.TraceStatus;

import java.security.PrivilegedAction;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;


    @Override
    public void save(String itemId) {

        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.save()"); //target 호출
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }

    }
}
