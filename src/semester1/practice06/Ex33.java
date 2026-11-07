package semester1.practice06;

public class Ex33 {
  static class GradeBook {
    private String studentName;
    private int[] grades = new int[0];

    public void setData(String name, int[] g) {
      studentName = name;
      grades = g.clone();
    }

    public double getAverage() {
      if (grades.length == 0) return 0;
      int sum = 0;
      for (int x : grades) sum += x;
      return (double) sum / grades.length;
    }

    public int getHighestGrade() {
      if (grades.length == 0) return 0;
      int max = grades[0];
      for (int x : grades) max = Math.max(max, x);
      return max;
    }

    public int getLowestGrade() {
      if (grades.length == 0) return 0;
      int min = grades[0];
      for (int x : grades) min = Math.min(min, x);
      return min;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    GradeBook g = new GradeBook();
    g.setData("Олександр", new int[] {85, 92, 78, 96, 65});
    System.out.println(
        g.studentName
            + " | "
            + g.getAverage()
            + " | "
            + g.getHighestGrade()
            + " | "
            + g.getLowestGrade());
  }
}
