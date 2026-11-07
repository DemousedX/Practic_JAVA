package semester1.practice08;

public class Ex34 {
  static class GradeSheet {
    private String studentName;
    protected int[] grades;

    public GradeSheet(String studentName, int[] grades) {
      this.studentName = studentName;
      this.grades = grades.clone();
    }

    public double calculateScore() {
      if (grades.length == 0) return 0;
      int sum = 0;
      for (int g : grades) sum += g;
      return (double) sum / grades.length;
    }

    public String toString() {
      return studentName + " | " + calculateScore();
    }
  }

  static class WeightedGradeSheet extends GradeSheet {
    private double[] weights;

    public WeightedGradeSheet(String studentName, int[] grades, double[] weights) {
      super(studentName, grades);
      if (weights.length != grades.length)
        throw new IllegalArgumentException("Довжини мають збігатися");
      for (double w : weights)
        if (w < 0) throw new IllegalArgumentException("Вага не може бути від'ємною");
      this.weights = weights.clone();
    }

    @Override
    public double calculateScore() {
      double sum = 0, total = 0;
      for (int i = 0; i < grades.length; i++) {
        sum += grades[i] * weights[i];
        total += weights[i];
      }
      return total == 0 ? 0 : sum / total;
    }

    @Override
    public String toString() {
      return "Зважений бал: " + super.toString();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[] grades = {88, 74, 96};
    System.out.println(new GradeSheet("Олександр", grades));
    System.out.println(new WeightedGradeSheet("Олександр", grades, new double[] {1, 2, 3}));
  }
}
