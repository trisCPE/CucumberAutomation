/*
 * Author: Tristan GUENEAU
 * Manage the logging of the different scenarios.
 * All the logs are available in an external log file
 *
 *
 */


package steps;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    private static final Logger logger = Logger.getLogger("MyLog");

    public static void startTest(String testCase) {
        FileHandler fh;
        try {
            // This block configure the logger with handler and formatter
            fh = new FileHandler("C:/temp/test/MyLogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            //Logs can be consulted in the .log file
            logger.info("################ Test case : " +  testCase +  "  ################");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void endTest() {
        FileHandler fh;
        try {
            // This block configure the logger with handler and formatter
            fh = new FileHandler("C:/temp/test/MyLogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            //Logs can be consulted in the .log file
            logger.info("################  - END OF THE TEST -  ################");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testFailed() {
        FileHandler fh;
        try {
            // This block configure the logger with handler and formatter
            fh = new FileHandler("C:/temp/test/MyLogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.severe("SCENARIO HAS FAILED ! Closing the app..." );


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void info(String message)
    {
        logger.info(message);

    }


}
