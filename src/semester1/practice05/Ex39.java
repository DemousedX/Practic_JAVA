package semester1.practice05;


public class Ex39 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[][][] cube = new int[3][3][3];
    for (int x = 0; x < 3; x++) {
      System.out.println("--- Шар " + x + " ---");
      for (int y = 0; y < 3; y++) {
        for (int z = 0; z < 3; z++) {
          cube[x][y][z] = x + y + z;
          System.out.print(cube[x][y][z] + " ");
        }
        System.out.println();
      }
    }
  }
}
