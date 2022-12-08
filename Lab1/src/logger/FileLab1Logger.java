package logger;

public class FileLab1Logger implements Lab1Logger {

    @Override
    public void error(String logMessage) {
        System.out.println("ERROR: " + logMessage);
    }

    @Override
    public void debug(String logMessage) {
        System.out.println("DEBUG: " + logMessage);
    }

    @Override
    public void info(String logMessage) {
        System.out.println("INFO: " + logMessage);
    }

    @Override
    public void warn(String logMessage) {
        System.out.println("ACHTUNG: " + logMessage);
    }

}
