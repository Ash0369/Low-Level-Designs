public class ConsoleLoggingStrategy implements LoggingStrategy {

    private  final LogFormater logFormater;

    public ConsoleLoggingStrategy(LogFormater logFormater) {
        this.logFormater = logFormater;
    }

    @Override
    public void logData(LogMessage log) {
        System.out.println(logFormater.format(log));
    }
}
