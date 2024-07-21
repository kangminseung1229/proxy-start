package proxy.start;

import proxy.start.hello.proxy.config.AppV1Config;
import proxy.start.hello.proxy.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import({AppV1Config.class, AppV2Config.class})
@SpringBootApplication(scanBasePackages = "proxy.start.hello.proxy.app")
public class ProxyStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyStartApplication.class, args);
    }

}
