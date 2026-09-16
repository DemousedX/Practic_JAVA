import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

/** Меню робіт Олександра Денисенка (КНД-11). */
public class Main {
    private static final FileInputStream RAW_INPUT = new FileInputStream(FileDescriptor.in);
    private static final String[] SECTIONS = {
            "", "Практична №1 — перший проєкт і консольний вивід",
            "Практична №2 — змінні й обчислення", "Практична №3 — Scanner, умови та switch",
            "Практична №4 — цикли й приведення типів", "Практична №5 — масиви",
            "Практична №6 — класи, об'єкти та інкапсуляція", "Практична №7 — конструктори та взаємодія об'єктів",
            "ДЗ до практичної №2 — валюта, числа, трикутник, геометрія, RPG",
            "ДЗ до практичної №3 — пальне, доставка, скоринг, Smart Home, квест",
            "ДЗ до практичної №4 — цикли, Fibonacci, прості числа, Brawl Stars",
            "ДЗ до практичної №5 — продажі, склад, кінотеатр, Dota 2, Roblox",
            "ДЗ до практичної №6 — дроби, рівняння, вектори, матриці, Аста"
    };

    public static void main(String[] args) {
        semester1.ConsoleOutput.useUtf8();
        printHeader();
        if (args.length >= 2) {
            launch(parse(args[0]), parse(args[1]));
            return;
        }
        while (true) {
            printMenu();
            int section = read("Оберіть роботу (0 — вихід): ");
            if (section == 0) {
                System.out.println("До зустрічі! Нехай компілятор сьогодні буде добрим.");
                return;
            }
            if (section < 1 || section >= SECTIONS.length) {
                System.out.println("Такої роботи немає.");
                continue;
            }
            System.out.println(SECTIONS[section]);
            int maxTask = section <= 7 ? 40 : 5;
            int task = read("Номер завдання (1–" + maxTask + "): ");
            if (task < 1 || task > maxTask) {
                System.out.println("Номер поза межами. Спробуйте ще раз.");
                continue;
            }
            launch(section, task);
            return;
        }
    }

    private static int read(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = readLine().trim();
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println("Введіть ціле число.");
            }
        }
    }

    /** Читає рівно один рядок, не буферизуючи ввід, потрібний дочірній програмі. */
    private static String readLine() {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try {
            int value;
            while ((value = RAW_INPUT.read()) != -1 && value != '\n') {
                if (value != '\r') bytes.write(value);
            }
        } catch (java.io.IOException e) {
            throw new IllegalStateException("Не вдалося прочитати вибір меню.", e);
        }
        return bytes.toString(StandardCharsets.UTF_8);
    }

    private static int parse(String value) {
        try { return Integer.parseInt(value); }
        catch (NumberFormatException e) { return -1; }
    }

    private static void launch(int section, int task) {
        String className;
        String[] childArgs = new String[0];
        if (section == 1) className = "semester1.practice01.Ex" + task;
        else if (section >= 2 && section <= 7) {
            className = String.format("semester1.practice%02d.Practice%02dTask%02d", section, section, task);
        } else {
            className = switch (section) {
                case 8 -> "semester1.practice02.homework." + new String[]{"", "Task1CurrencyExchange", "Task2NumberAnalysis", "Task3TriangleClassifier", "Task4HeronGeometry", "Task5RpgHero"}[task];
                case 9 -> "semester1.practice03.homework." + new String[]{"", "Task1FuelCalculator", "Task2DeliveryService", "Task3CreditScoring", "Task4SmartHomeClimate", "Task5InteractiveQuest"}[task];
                case 10 -> "semester1.practice04.homework." + new String[]{"", "Task1RangeStatistics", "Task2DigitAnalyzer", "Task3FibonacciSeries", "Task4PrimeFinder", "Task5BrawlStarsArena"}[task];
                case 11 -> "semester1.practice05.homework." + new String[]{"", "Task1DailySales", "Task2WarehouseInventory", "Task3CinemaBooking", "Task4DotaMatchStats", "Task5RobloxPetSimulator"}[task];
                case 12 -> "semester1.practice06.homework." + new String[]{"", "Task1Fraction", "Task2QuadraticEquation", "Task3Vector2D", "Task4MatrixSolver", "Task5AnimeHeroBattle"}[task];
                default -> null;
            };
        }
        if (className == null) {
            System.out.println("Невідома робота.");
            return;
        }
        try {
            String executable = System.getProperty("java.home") + "/bin/"
                    + (System.getProperty("os.name").toLowerCase().contains("win") ? "java.exe" : "java");
            ProcessBuilder process = new ProcessBuilder(executable, "-Dfile.encoding=UTF-8", "-cp",
                    System.getProperty("java.class.path"), className);
            process.command().addAll(java.util.List.of(childArgs));
            process.inheritIO();
            int exitCode = process.start().waitFor();
            if (exitCode != 0) System.out.println("Завдання завершилося з кодом " + exitCode + ".");
        } catch (Exception e) {
            System.out.println("Не вдалося запустити завдання: " + e.getMessage());
        }
    }

    private static void printHeader() {
        System.out.println("============================================================");
        System.out.println("                 ПРАКТИЧНІ ТА ДЗ З JAVA");
        System.out.println("              Олександр Денисенко | КНД-11");
        System.out.println("          Прогамування без паніки: якщо що — це демо!");
        System.out.println("============================================================");
    }

    private static void printMenu() {
        System.out.println("\nРОБОТИ:");
        for (int i = 1; i < SECTIONS.length; i++) System.out.printf("%2d — %s%n", i, SECTIONS[i]);
        System.out.println(" 0 — Вийти");
    }
}
