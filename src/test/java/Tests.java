import exceptions.HighLevelException;
import exceptions.LowLevelException;
import exceptions.MiddleLevelException;
import excepts.ExceptionTool;
import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void exceptionHandlingDemo() {
        try {
            throwLowLevelException();
        }
        catch (HighLevelException e) {
            Assert.fail();
        }
        catch (MiddleLevelException e) {
            ExceptionTool.printStackTraceToConsole(e);
            Assert.fail();
        }
        catch (LowLevelException e) {
            ExceptionTool.printStackTraceToConsole(e);
            ExceptionTool.printStackTraceToFile(e, "Log.txt");
            Assert.assertTrue(true);
        }
    }

    private void throwLowLevelException() throws LowLevelException {
        throw new LowLevelException();
    }

}
