package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex16 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    ArrayList<Integer> scores = new ArrayList<>(List.of(45, 88, 92, 59, 74, 100, 38, 65));
    ArrayList<Integer> passed = extractPassedScores(scores, 60);
    System.out.printf("Усього: %d, не пройшли: %d, зараховано: %s%n",
        scores.size(), scores.size() - passed.size(), passed);
  }

  public static ArrayList<Integer> extractPassedScores(List<Integer> allScores, int minPassScore) {
    ArrayList<Integer> passed = new ArrayList<>();
    for (int i = 0; i < allScores.size(); i++) {
      int score = allScores.get(i);
      if (score >= minPassScore) passed.add(score);
    }
    return passed;
  }
}
