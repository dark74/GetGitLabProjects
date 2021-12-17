package utils;

import org.apache.log4j.Logger;

public class LogUtils {
    private static Logger logger = Logger.getLogger(LogUtils.class);

    public static void e(String msg) {
        logger.error(msg);
    }

    public static void d(String msg) {
        logger.debug(msg);
    }

    public static void i(String msg) {
        logger.info(msg);
    }
}
