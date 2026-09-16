import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {
        String launchDate = LocalDate.now().format(DATE_FORMAT);

        System.out.println("==================================================");
        System.out.println("Дата: " + launchDate);
        System.out.println("Назва: Домашнє завдання до Практичної роботи №2");
        System.out.println("Тема: Змінні, типи даних, оператори та математичні обчислення в Java");
        System.out.println("==================================================");

        runHomeworkForPractice2();
    }

    private static void runHomeworkForPractice2() {
        Runnable[] tasks = {
                () -> dz_do_practic_2.Ex1.main(new String[0]),
                () -> dz_do_practic_2.Ex2.main(new String[0]),
                () -> dz_do_practic_2.Ex3.main(new String[0]),
                () -> dz_do_practic_2.Ex4.main(new String[0]),
                () -> dz_do_practic_2.Ex5.main(new String[0])
        };

        String[] taskNames = {
                "Конвертер валют із банківською комісією",
                "Математичний аналіз та реверс тризначного числа",
                "Логічний класифікатор властивостей трикутника",
                "Формула Герона та геометрія кіл",
                "Генератор героя RPG та симулятор битви"
        };

        for (int i = 0; i < tasks.length; i++) {
            System.out.println();
            System.out.println("--------------------------------------------------");
            System.out.println("ЗАВДАННЯ " + (i + 1));
            System.out.println(taskNames[i]);
            System.out.println("--------------------------------------------------");

            tasks[i].run();

            System.out.println("--------------------------------------------------");
            System.out.println("КІНЕЦЬ ЗАВДАННЯ " + (i + 1));
        }

        System.out.println();
        System.out.println("==================================================");
        System.out.println("ДЗ до практичної роботи №2 завершено.");
        System.out.println("==================================================");
    }
}
