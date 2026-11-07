package semester1.practice04.homework;

import java.util.Scanner;

public final class Ex5 {
  private Ex5() {}

  private static void battle(Scanner s) {
    System.out.println("Обери бійця: 1 Шеллі, 2 Кольт, 3 Ель Прімо");
    int pick = read(s, "Твій вибір: ");
    String name;
    int hp, maxHp, attack, superAttack;
    switch (pick) {
      case 1 -> {
        name = "Шеллі";
        hp = maxHp = 4000;
        attack = 1200;
        superAttack = 2800;
      }
      case 2 -> {
        name = "Кольт";
        hp = maxHp = 3000;
        attack = 1600;
        superAttack = 3600;
      }
      default -> {
        name = "Ель Прімо";
        hp = maxHp = 6000;
        attack = 1100;
        superAttack = 2200;
      }
    }
    int boss = 10000, ammo = 3, charge = 0, round = 0;
    double boost = 1;
    boolean knock = false, stun = false;
    while (hp > 0 && boss > 0 && round < 100) {
      round++;
      int bars = (int) (10.0 * boss / 10000);
      System.out.printf("Раунд %d | %s %d/%d HP | Boss %d/10000 [", round, name, hp, maxHp, boss);
      for (int b = 0; b < 10; b++) System.out.print(b < bars ? '#' : '-');
      System.out.println("]");
      int action = read(s, "1 атака, 2 супер, 3 захист, 4 куб: ");
      switch (action) {
        case 1 -> {
          if (ammo > 0) {
            boss -= Math.min(boss, (int) (attack * boost));
            ammo--;
            charge = Math.min(100, charge + 35);
            System.out.println(name + " атакує!");
          } else System.out.println("Немає набоїв - перезарядка");
        }
        case 2 -> {
          if (charge >= 100) {
            boss -= Math.min(boss, (int) (superAttack * boost));
            charge = 0;
            if (pick == 1) knock = true;
            if (pick == 3) stun = true;
          } else System.out.println("Супер ще не заряджений");
        }
        case 3 -> {
          ammo = Math.min(3, ammo + 2);
          hp = Math.min(maxHp, hp + (int) (maxHp * .15));
        }
        case 4 -> {
          if (Math.random() < .6) {
            boost += .15;
            System.out.println("Power Cube! Шкода +15%.");
          } else System.out.println("Куб не знайшовся");
        }
        default -> System.out.println("Хід втрачено");
      }
      if (boss > 0 && stun) {
        System.out.println("Бос оглушений");
        stun = false;
      } else if (boss > 0) {
        double fraction = boss / 10000.0;
        int damage = fraction > .6 ? 700 : fraction >= .3 ? (int) (700 * 1.3) : (int) (700 * 1.7);
        if (knock) {
          damage /= 2;
          knock = false;
        }
        if (Math.random() < .15) System.out.println("Ухилення!");
        else hp -= damage;
      }
      ammo = Math.min(3, ammo + 1);
    }
    if (boss <= 0)
      System.out.printf("Перемога за %d раундів! +10 трофеїв, 100 Starr Drops%n", round);
    else System.out.println("Поразка. Сейф зруйновано; спробуй витривалішого бійця!");
  }

  private static int read(Scanner s, String p) {
    System.out.print(p);
    while (!s.hasNextInt()) {
      System.out.println("Введіть ціле число");
      s.next();
      System.out.print(p);
    }
    return s.nextInt();
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- ДЗ до практичної N4, завдання 5 ---%n");
    try (Scanner s = new Scanner(System.in)) {
      battle(s);
    }
  }
}
