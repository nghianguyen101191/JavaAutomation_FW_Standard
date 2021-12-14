package log;
import org.apache.log4j.Logger;

public class LoggerMethod {
    public static void Log(String logvalue) {
        Logger log = Logger.getLogger("devpinoyLogger");
        log.debug(logvalue);
    }
}