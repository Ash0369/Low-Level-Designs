public class FileLoggingStrategy implements LoggingStrategy {

    @Override
    public void logData(LogMessage log) {
        System.out.println("Logged Message to File");
    }
}
