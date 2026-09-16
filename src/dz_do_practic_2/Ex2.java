package dz_do_practic_2;

public class Ex2 {
    public static void main(String[] args) {
        int number = 742;

        int hundreds = number / 100;
        int tens = number / 10 % 10;
        int units = number % 10;

        int digitSum = hundreds + tens + units;
        int digitProduct = hundreds * tens * units;
        int reversedNumber = units * 100 + tens * 10 + hundreds;
        boolean isSumEven = digitSum % 2 == 0;

        System.out.println("Початкове число:            " + number);
        System.out.println("Розряди:                    Сотні = " + hundreds
                + ", Десятки = " + tens + ", Одиниці = " + units);
        System.out.println("Сума цифр:                  " + digitSum);
        System.out.println("Добуток цифр:               " + digitProduct);
        System.out.println("Перевернуте число:          " + reversedNumber);
        System.out.println("Чи є сума цифр парною?      " + isSumEven);
    }
}
