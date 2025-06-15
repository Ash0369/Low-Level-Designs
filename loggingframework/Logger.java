import java.time.LocalDateTime;

public class Logger {

    private final static Logger instance = new Logger();
    private LoggingConfig loggingConfig;

    private Logger() {
        loggingConfig = new LoggingConfig(LogLevelType.INFO, LogDestinationType.CONSOLE);
        loggingConfig.setLoggingStrategy(new ConsoleLoggingStrategy(new DefaultFormat()));
    }

    public static Logger getLoggerInstance() {
        return instance;
    }

    public void setLoggingConfig(LoggingConfig loggingConfig) {
        this.loggingConfig = loggingConfig;
    }

    public LoggingConfig getLoggingConfig() {
        return loggingConfig;
    }

    public void logMessage(LogLevelType logLevel, String message) {
        LogMessage logMessage = new LogMessage(message, LocalDateTime.now(), logLevel);
        loggingConfig.getLoggingStrategy().logData(logMessage);


    }

    public void debug(String message) {
        logMessage(LogLevelType.DEBUG, message);
    }

    public void info(String message) {
        logMessage(LogLevelType.INFO, message);
    }

    public void warn(String message) {
        logMessage(LogLevelType.WARN, message);
    }

    public void error(String message) {
        logMessage(LogLevelType.ERROR, message);
    }

    public void fatal(String message) {
        logMessage(LogLevelType.FATAL, message);
    }
}
