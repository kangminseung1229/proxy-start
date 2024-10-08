package proxy.start.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import proxy.start.jdkdynamic.code.*;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {


    @Test
    void dynamicA() {
        AInterface target = new AInterfaceImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        AInterface proxy = (AInterface)
                Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]
                        {AInterface.class}, handler);
        proxy.call();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }

    @Test
    void dynamicB() {
        BInterface target = new BInterfaceImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        BInterface proxy = (BInterface)
                Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]
                        {BInterface.class}, handler);
        proxy.call();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }
}
