package semester1.practice06.homework;

public class Fraction {
    private int numerator;
    private int denominator = 1;
    public Fraction(int numerator,int denominator){setValues(numerator,denominator);}
    public int getNumerator(){return numerator;} public int getDenominator(){return denominator;}
    public void setValues(int num,int den){if(den==0){System.out.println("Помилка: знаменник не може дорівнювати 0!");den=1;}if(den<0){num=-num;den=-den;}numerator=num;denominator=den;simplify();}
    private int gcd(int a,int b){a=Math.abs(a);b=Math.abs(b);while(b!=0){int t=b;b=a%b;a=t;}return a==0?1:a;}
    public void simplify(){int g=gcd(numerator,denominator);numerator/=g;denominator/=g;}
    public double toDecimal(){return (double)numerator/denominator;}
    public void add(int otherNum,int otherDen){if(otherDen==0){System.out.println("Дріб із нульовим знаменником пропущено.");return;}numerator=numerator*otherDen+otherNum*denominator;denominator*=otherDen;if(denominator<0){numerator=-numerator;denominator=-denominator;}simplify();}
    public void printFraction(){System.out.println(denominator==1?numerator:numerator+"/"+denominator);}
}
