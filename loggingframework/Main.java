public class Main {
    public static void main(String[] args) {
        System.out.println("Logger application");
        Logger logger = Logger.getLoggerInstance();

        logger.info("Ashish");
        logger.error("Aditi");
        logger.warn("Aditi");
        logger.fatal("Ashish");
    }
}