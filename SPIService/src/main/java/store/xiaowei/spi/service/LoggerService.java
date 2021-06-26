package store.xiaowei.spi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class LoggerService {

    private static final LoggerService instance = new LoggerService();
    private final Logger logger;
    private final DefaultLogger defaultLogger;

    private final List<Logger> loggerList;

    private LoggerService(){
        ServiceLoader<Logger> loader = ServiceLoader.load(Logger.class);
        List<Logger> list = new ArrayList<>();
        for(Logger logger : loader){
            list.add(logger);
        }
        loggerList = list;
        if(!list.isEmpty()) {
            logger = loggerList.get(0);
        } else {
            logger = null;
        }
        defaultLogger = new DefaultLogger();
    }

    public static LoggerService getInstance() {
        return instance;
    }

    public void info(String msg) {
        if(logger != null) {
            logger.info(msg);
        } else {
            defaultLogger.info(msg);
        }
    }

    public void debug(String msg) {
        if(logger != null) {
            logger.debug(msg);
        } else {
            defaultLogger.debug(msg);
        }
    }

}
