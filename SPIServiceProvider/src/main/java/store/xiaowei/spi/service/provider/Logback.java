package store.xiaowei.spi.service.provider;

import store.xiaowei.spi.service.Logger;

public class Logback implements Logger {


    @Override
    public void info(String msg) {
        System.out.println("Logback : " + msg);
    }

    @Override
    public void debug(String msg) {
        System.out.println("\u001b[31mLogback : " + msg + "\u001b[0m");
    }
}
