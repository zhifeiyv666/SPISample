package store.xiaowei.spi.service;

public class DefaultLogger implements Logger{

    @Override
    public void info(String msg) {
        System.out.println(msg);
    }

    @Override
    public void debug(String msg) {
        System.out.println("\u001B[31m" + msg + "\u001B[0m");
    }


}
