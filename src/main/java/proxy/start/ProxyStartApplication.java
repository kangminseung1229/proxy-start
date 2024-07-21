package proxy.start;

import org.springframework.context.annotation.Bean;
import proxy.start.hello.proxy.config.AppV1Config;
import proxy.start.hello.proxy.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import proxy.start.hello.proxy.config.v1_proxy.InterfaceProxyConfig;
import proxy.start.hello.proxy.trace.LogTrace;
import proxy.start.hello.proxy.trace.threadlocal.code.ThreadLocalLogTrace;


//@Import({AppV1Config.class, AppV2Config.class})
@Import(InterfaceProxyConfig.class)
@SpringBootApplication(scanBasePackages = "proxy.start.hello.proxy.app")
public class ProxyStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyStartApplication.class, args);
    }

    @Bean
    public LogTrace logTrace(){
        return new ThreadLocalLogTrace();
    }

}
