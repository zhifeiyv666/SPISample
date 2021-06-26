package store.xiaowei.spi;

import store.xiaowei.spi.service.LoggerService;

public class Main {

    public static void main(String[] args) {
        LoggerService service = LoggerService.getInstance();
        service.debug("有趣");
        service.info("interesting");
    }
}
