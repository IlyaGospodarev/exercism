import java.util.Locale;

public class LogLevels {
    
    public static String message(String logLine) {
        return logLine.replace(logLine.substring(logLine.indexOf("["), logLine.indexOf(":") + 1), "")
                .replace("\\r\\n", "")
                .trim();
    }

    public static String logLevel(String logLine) {
        return logLine.substring(logLine.indexOf("[") + 1, logLine.indexOf("]"))
                .toLowerCase(Locale.ROOT);
    }

    public static String reformat(String logLine) {
        String str = logLine.substring(logLine.indexOf("["), logLine.indexOf("]") + 1)
                .replace("[", "(")
                .replace("]", ")")
                .toLowerCase(Locale.ROOT);
        return message(logLine) + " " + str;
    }
}
