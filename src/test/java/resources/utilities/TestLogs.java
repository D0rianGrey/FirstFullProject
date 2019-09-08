package resources.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.text.SimpleDateFormat;

import java.util.Date;

public class TestLogs {
    static{

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }

    final static Logger log = Logger.getLogger(TestLogs.class);

    public static void main(String[] args) {

        log.trace("This is Trace Message.");
        log.debug("This is Debug Message.");
        log.info("This is Info Message.");
        log.warn("This is Warn Message.");
        log.error("This is Error Message.");
        log.fatal("This is Fatal Message.");
    }
}
