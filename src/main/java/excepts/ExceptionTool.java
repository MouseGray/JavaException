package excepts;

import java.io.*;

public class ExceptionTool {

    public static <T extends Throwable> RuntimeException wrapException(T exception) {
        return new RuntimeException(exception);
    }

    public static RuntimeException wrapToExChain(Throwable...cause) {
        if (cause.length > 0) {
            Throwable curCause = cause[cause.length - 1];
            for (int i = cause.length - 2; i >= 0; i--) {
                curCause = cause[i].initCause(curCause);
            }
            return new RuntimeException(curCause);
        }
        return new RuntimeException();
    }

    public static <T extends Throwable> void printStackTraceToConsole(T exception) {
        printException(exception, System.out);
    }

    public static <T extends Throwable> void printStackTraceToFile(T exception, String filename) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename, true)) {
            printException(exception, new PrintStream(fileOutputStream));
        } catch (IOException ignored) { }
    }

    public static <T extends Throwable> void printException(T exception, PrintStream ...printStreams) {
        for (PrintStream ps: printStreams){
            exception.printStackTrace(ps);
        }
    }
}
