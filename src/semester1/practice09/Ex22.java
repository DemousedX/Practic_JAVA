package semester1.practice09;

public class Ex22 {
  static class CourseModule {
    private final String topic;
    private final int lectureHours, practiceHours;
    private double maxScore;

    public CourseModule(String topic, int lectureHours, int practiceHours, double maxScore) {
      this.topic = topic;
      this.lectureHours = lectureHours;
      this.practiceHours = practiceHours;
      this.maxScore = maxScore;
    }
  }

  static class UniversityCourse {
    private final String courseTitle;
    private final CourseModule[] modules;
    private int moduleCount;

    public UniversityCourse(String courseTitle, int capacity) {
      this.courseTitle = courseTitle;
      modules = new CourseModule[capacity];
    }

    public void addModule(CourseModule module) {
      if (module != null && moduleCount < modules.length) modules[moduleCount++] = module;
    }

    public double getCredits() {
      int hours = 0;
      for (int i = 0; i < moduleCount; i++)
        hours += modules[i].lectureHours + modules[i].practiceHours;
      return hours / 30.0;
    }

    public boolean isScoreValid() {
      double sum = 0;
      for (int i = 0; i < moduleCount; i++) sum += modules[i].maxScore;
      return Math.abs(sum - 100) < 1e-9;
    }

    public String toString() {
      return courseTitle + " | ECTS=" + getCredits() + " | valid=" + isScoreValid();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    UniversityCourse c = new UniversityCourse("Java", 3);
    c.addModule(new CourseModule("ООП", 20, 20, 40));
    System.out.println(c);
    c.addModule(new CourseModule("Масиви", 20, 30, 60));
    System.out.println(c);
  }
}
