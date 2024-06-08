package kr.co.taxnet.migration.proxystart;

import kr.co.taxnet.migration.proxystart.hello.proxy.config.AppV1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import(AppV1Config.class)
@SpringBootApplication(scanBasePackages = "hello.proxy.app.v3")
public class ProxyStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyStartApplication.class, args);
    }

}
