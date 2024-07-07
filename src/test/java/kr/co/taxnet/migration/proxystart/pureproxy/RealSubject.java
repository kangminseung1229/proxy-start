package kr.co.taxnet.migration.proxystart.pureproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject {
    @Override
    public String operation() {
        log.info("실제 객체 호출 - 데이터 베이스 쿼리 실행중");
        sleep(1000); // 데이터 베이스 쿼리 실행중
        return "data";
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
