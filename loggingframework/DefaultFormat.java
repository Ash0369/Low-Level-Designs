public class DefaultFormat implements LogFormater {
    @Override
    public String format(LogMessage log) {
        return "["+ log.getLogLevelType().toString() + "] " +
                log.getTimeStamp() + " : " + log.getMessage();
    }
}
