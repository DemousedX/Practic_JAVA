package dz_do_practic_2;

public class Ex3 {
    public static void main(String[] args) {
        double a = 3.0;
        double b = 4.0;
        double c = 5.0;

        boolean exists = (a + b > c) && (a + c > b) && (b + c > a);
        boolean isEquilateral = (a == b) && (b == c);
        boolean isIsosceles = (a == b) || (b == c) || (a == c);
        boolean isRightAngled = (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2))
                || (Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2))
                || (Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2));

        System.out.println("Сторони трикутника: a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("--------------------------------------------------");
        System.out.println("Чи існує такий трикутник:      " + exists);
        System.out.println("Чи є рівностороннім:           " + isEquilateral);
        System.out.println("Чи є рівнобедреним:             " + isIsosceles);
        System.out.println("Чи є прямокутним:               " + isRightAngled);
    }
}
