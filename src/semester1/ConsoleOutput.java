package semester1;

import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileDescriptor;
import java.nio.charset.StandardCharsets;

public final class ConsoleOutput {
    private ConsoleOutput() { }
    public static void useUtf8() {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));
    }
}
