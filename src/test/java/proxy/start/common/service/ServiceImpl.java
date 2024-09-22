package proxy.start.common.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceImpl implements ServiceInterface{
    @Override
    public void save() {
        log.info("save 메소드 호출");
    }

    @Override
    public void find() {
        log.info("find 메소드 호출");
    }
}
