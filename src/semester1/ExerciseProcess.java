// Потрібен для Main і інших PracticeN, бо деякі вправи після виконання задачі закривають Scanner

package semester1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public final class ExerciseProcess {
  private ExerciseProcess() {}

  public static int run(String className, String... args) throws IOException, InterruptedException {
    String javaCommand = File.separatorChar == '\\' ? "java.exe" : "java";
    String executable = Path.of(System.getProperty("java.home"), "bin", javaCommand).toString();
    ProcessBuilder process =
        new ProcessBuilder(
            executable,
            "-Dfile.encoding=UTF-8",
            "-cp",
            System.getProperty("java.class.path"),
            className);
    process.command().addAll(List.of(args));
    return process.inheritIO().start().waitFor();
  }
}
