package kr.co.taxnet.migration.proxystart.decorator.code;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new
                DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    void decorator1(){
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client =    new DecoratorPatternClient(messageDecorator);
        client.execute();
    }

    @Test
    void decorator2(){
        Component realcomponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realcomponent);
        Component timeDecorator = new TimeDecorator(realcomponent);
        DecoratorPatternClient client =    new DecoratorPatternClient(timeDecorator);
        client.execute();
    }

}
