import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

/** Меню домашніх завдань Олександра Денисенка (КНД-11). */
public class Main {
    private static final FileInputStream RAW_INPUT = new FileInputStream(FileDescriptor.in);
    private static final String[] HOMEWORKS = {
            "", "ДЗ до практичної №2 — валюта, числа, трикутник, геометрія, RPG",
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
            int homework = read("Оберіть ДЗ (0 — вихід): ");
            if (homework == 0) {
                System.out.println("До зустрічі! Нехай компілятор сьогодні буде добрим.");
                return;
            }
            if (homework < 1 || homework >= HOMEWORKS.length) {
                System.out.println("Такого ДЗ немає.");
                continue;
            }
            System.out.println(HOMEWORKS[homework]);
            int task = read("Номер завдання (1–5): ");
            if (task < 1 || task > 5) {
                System.out.println("Номер поза межами. Спробуйте ще раз.");
                continue;
            }
            launch(homework, task);
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

    /** Читає рівно один рядок, не буферизуючи ввід для дочірньої програми. */
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

    private static void launch(int homework, int task) {
        String[] classes = switch (homework) {
            case 1 -> new String[]{"", "Task1CurrencyExchange", "Task2NumberAnalysis", "Task3TriangleClassifier", "Task4HeronGeometry", "Task5RpgHero"};
            case 2 -> new String[]{"", "Task1FuelCalculator", "Task2DeliveryService", "Task3CreditScoring", "Task4SmartHomeClimate", "Task5InteractiveQuest"};
            case 3 -> new String[]{"", "Task1RangeStatistics", "Task2DigitAnalyzer", "Task3FibonacciSeries", "Task4PrimeFinder", "Task5BrawlStarsArena"};
            case 4 -> new String[]{"", "Task1DailySales", "Task2WarehouseInventory", "Task3CinemaBooking", "Task4DotaMatchStats", "Task5RobloxPetSimulator"};
            case 5 -> new String[]{"", "Task1Fraction", "Task2QuadraticEquation", "Task3Vector2D", "Task4MatrixSolver", "Task5AnimeHeroBattle"};
            default -> null;
        };
        if (classes == null || task < 1 || task >= classes.length) {
            System.out.println("Невідоме ДЗ або завдання.");
            return;
        }
        String packageName = String.format("semester1.practice%02d.homework", homework + 1);
        String className = packageName + "." + classes[task];
        try {
            String executable = System.getProperty("java.home") + "/bin/"
                    + (System.getProperty("os.name").toLowerCase().contains("win") ? "java.exe" : "java");
            ProcessBuilder process = new ProcessBuilder(executable, "-Dfile.encoding=UTF-8", "-cp",
                    System.getProperty("java.class.path"), className);
            process.inheritIO();
            int exitCode = process.start().waitFor();
            if (exitCode != 0) System.out.println("Завдання завершилося з кодом " + exitCode + ".");
        } catch (Exception e) {
            System.out.println("Не вдалося запустити завдання: " + e.getMessage());
        }
    }

    private static void printHeader() {
        System.out.println("============================================================");
        System.out.println("                    ДОМАШНІ ЗАВДАННЯ З JAVA");
        System.out.println("              Олександр Денисенко | КНД-11");
        System.out.println("             Прогамування без паніки: це демо!");
        System.out.println("============================================================");
    }

    private static void printMenu() {
        System.out.println("\nДОМАШНІ ЗАВДАННЯ:");
        for (int i = 1; i < HOMEWORKS.length; i++) System.out.printf("%2d — %s%n", i, HOMEWORKS[i]);
        System.out.println(" 0 — Вийти");
    }
}
