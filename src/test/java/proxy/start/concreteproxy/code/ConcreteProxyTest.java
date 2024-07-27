package proxy.start.concreteproxy.code;

import org.junit.jupiter.api.Test;


import javax.crypto.Cipher;
import java.util.concurrent.TimeoutException;

public class ConcreteProxyTest {

    @Test
    void noProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient concreteClient = new ConcreteClient(concreteLogic);
        concreteClient.excute();
    }

    @Test
    void addProxy(){
        // 클라이언트에 타임프록시를 넣음. 상속받은 객체를 내가 커스텀에서 넣었음.
        // 다형성은 인터페이스, 클래스를 구분하지 않는다.
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient concreteClient = new ConcreteClient(timeProxy);
        concreteClient.excute();
    }
}
