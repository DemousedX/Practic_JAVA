package semester1.practice06.homework;

public class QuadraticEquation {
    private double a,b,c;
    public void setCoefficients(double a,double b,double c){if(a==0){System.out.println("Увага: a не може дорівнювати 0; використано 1.0.");a=1.0;}this.a=a;this.b=b;this.c=c;}
    public double getDiscriminant(){return b*b-4*a*c;}
    public boolean hasRealRoots(){return getDiscriminant()>=0;}
    public double getRoot1(){double d=getDiscriminant();return d<0?Double.NaN:(-b+Math.sqrt(d))/(2*a);}
    public double getRoot2(){double d=getDiscriminant();return d<0?Double.NaN:(-b-Math.sqrt(d))/(2*a);}
}
