import java.time.LocalDateTime;

public class LogMessage {
    private String message;
    private LocalDateTime timeStamp;
    private LogLevelType logLevelType;

    public LogMessage(String message, LocalDateTime timeStamp, LogLevelType logLevelType) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.logLevelType = logLevelType;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public LogLevelType getLogLevelType() {
        return logLevelType;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setLogLevelType(LogLevelType logLevelType) {
        this.logLevelType = logLevelType;
    }
}
