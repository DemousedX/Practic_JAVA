package semester1.practice06.homework;

public class Vector2D {
    private double x,y;
    public void set(double x,double y){this.x=x;this.y=y;}
    public double getX(){return x;} public double getY(){return y;}
    public double getLength(){return Math.hypot(x,y);}
    public void multiplyByScalar(double k){x*=k;y*=k;}
    public double dotProduct(double otherX,double otherY){return x*otherX+y*otherY;}
    public boolean isOrthogonalTo(Vector2D other){return Math.abs(dotProduct(other.x,other.y))<1e-9;}
    public void normalize(){double length=getLength();if(length>0){x/=length;y/=length;}}
}
