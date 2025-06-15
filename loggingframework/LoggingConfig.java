public class LoggingConfig {
    private LogLevelType logLevel;
    private LogDestinationType logDestination;
    private LoggingStrategy loggingStrategy;

    public LoggingConfig(LogLevelType logLevel, LogDestinationType logDestination) {
        this.logLevel = logLevel;
        this.logDestination = logDestination;
    }

    public LogLevelType getLogLevelType() {
        return logLevel;
    }

    public void setLogLevelType(LogLevelType logLevel) {
        this.logLevel = logLevel;
    }

    public LogDestinationType getLogDestinationType() {
        return logDestination;
    }

    public void setLogDestinationType(LogDestinationType logDestination) {
        this.logDestination = logDestination;
    }

    public void setLoggingStrategy(LoggingStrategy loggingStrategy) {
        this.loggingStrategy = loggingStrategy;
    }

    public LoggingStrategy getLoggingStrategy() {
        return loggingStrategy;
    }



}
