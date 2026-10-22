package semester1.practice06.homework;

public class MatrixSolver {
    private double[][] data;
    public void setMatrix(double[][] data){if(data==null||data.length==0)throw new IllegalArgumentException("Матриця не може бути порожньою.");this.data=new double[data.length][];for(int i=0;i<data.length;i++)this.data[i]=data[i].clone();}
    public void printMatrix(){for(double[] row:data){System.out.print("[");for(int c=0;c<row.length;c++)System.out.printf("%9.2f%s",row[c],c+1<row.length?" ":"");System.out.println("]");}}
    public double determinant2x2(){if(data.length!=2||data[0].length!=2||data[1].length!=2)throw new IllegalStateException("Потрібна матриця 2×2.");return data[0][0]*data[1][1]-data[0][1]*data[1][0];}
    public double determinant3x3(){if(data.length!=3||data[0].length!=3||data[1].length!=3||data[2].length!=3)throw new IllegalStateException("Потрібна матриця 3×3.");return data[0][0]*(data[1][1]*data[2][2]-data[1][2]*data[2][1])-data[0][1]*(data[1][0]*data[2][2]-data[1][2]*data[2][0])+data[0][2]*(data[1][0]*data[2][1]-data[1][1]*data[2][0]);}
    public double[][] transpose(){double[][] out=new double[data[0].length][data.length];for(int r=0;r<data.length;r++)for(int c=0;c<data[r].length;c++)out[c][r]=data[r][c];return out;}
    /** Розв'язує a1*x+b1*y=c1, a2*x+b2*y=c2; null означає Δ=0. */
    public double[] solveCramer(double c1,double c2){double det=determinant2x2();if(Math.abs(det)<1e-12)return null;double dx=c1*data[1][1]-data[0][1]*c2,dy=data[0][0]*c2-c1*data[1][0];return new double[]{dx/det,dy/det};}
}
