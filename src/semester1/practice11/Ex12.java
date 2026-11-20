package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex12 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    ArrayList<String> pipeline = new ArrayList<>();
    for (String stage : List.of("Compile", "Package", "Deploy")) {
      pipeline.add(stage);
      printPipeline(pipeline);
    }
    pipeline.add(0, "Checkout Git");
    printPipeline(pipeline);
    pipeline.add(2, "Run Unit Tests");
    printPipeline(pipeline);
  }

  private static void printPipeline(List<String> pipeline) {
    System.out.printf("%s, розмір: %d%n", pipeline, pipeline.size());
  }
}
