package launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class loggersdemo {
    private static Logger logger = LogManager.getLogger();


    public static void main(String[] args){


                logger.debug("This is a debug message");
                logger.info("This is an info message");
                logger.warn("This is a warn message");
                logger.error("This is an error message");
                logger.fatal("This is a fatal message");
    }
}
