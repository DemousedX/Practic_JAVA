package semester1.practice06.homework;

import java.util.Scanner;

final class Homework06 {
    private Homework06() { }
    static void run(int task){ semester1.ConsoleOutput.useUtf8();try(Scanner s=new Scanner(System.in)){switch(task){case 1->fraction();case 2->quadratic();case 3->vector();case 4->matrix();case 5->asta(s);default->throw new IllegalArgumentException();}}}
    private static int gcd(int a,int b){a=Math.abs(a);b=Math.abs(b);while(b!=0){int t=a%b;a=b;b=t;}return a==0?1:a;}
    private static void fraction(){Fraction f=new Fraction(8,12);System.out.print("Дріб після скорочення: ");f.printFraction();System.out.printf("Десятковий вигляд: %.4f%n",f.toDecimal());f.add(3,4);System.out.print("Після додавання 3/4: ");f.printFraction();System.out.printf("Десятковий вигляд: %.4f%n",f.toDecimal());}
    private static void quadratic(){QuadraticEquation q=new QuadraticEquation();q.setCoefficients(1,-7,10);System.out.printf("D=%.2f; дійсні корені: %s; x1=%.2f; x2=%.2f%n",q.getDiscriminant(),q.hasRealRoots(),q.getRoot1(),q.getRoot2());}
    private static void vector(){Vector2D a=new Vector2D(),b=new Vector2D();a.set(3,4);b.set(-4,3);System.out.printf("|A|=%.2f, |B|=%.2f, A·B=%.2f, ортогональні=%s%n",a.getLength(),b.getLength(),a.dotProduct(b.getX(),b.getY()),a.dotProduct(b.getX(),b.getY())==0);a.normalize();System.out.printf("Нормалізований A=(%.2f, %.2f), довжина %.2f%n",a.getX(),a.getY(),a.getLength());}
    private static void matrix(){MatrixSolver m=new MatrixSolver();m.setMatrix(new double[][]{{2,1},{5,3}});m.printMatrix();double[] result=m.solveCramer(9,24);System.out.printf("Δ=%.1f; x=%.2f, y=%.2f%n",m.determinant2x2(),result[0],result[1]);m.setMatrix(new double[][]{{1,2,3},{0,1,4},{5,6,0}});System.out.println("det 3×3 = "+m.determinant3x3());}
    private static void asta(Scanner s){Asta asta=new Asta();int bossHp=1200,round=0;System.out.println("=== Demoused: Чорний демон проти Патри ===");while(bossHp>0&&asta.isAlive()&&round<30){round++;asta.showStatus();System.out.printf("Патри HP %d | 1 — меч, 2–5 — навичка, 6 — захист: ",bossHp);int action=s.nextInt();int damage=0;if(action==1)damage=asta.basicSwordAttack();else if(action>=2&&action<=5)damage=asta.useSkill(action-2);else if(action==6)System.out.println("Аста готується зменшити шкоду.");else System.out.println("Хід пропущено.");bossHp=Math.max(0,bossHp-damage);if(bossHp>0){asta.takeDamage(action==6?80:110);asta.pushLimits();}}System.out.println(bossHp<=0?"Перемога над Патри за "+round+" раундів!":"Аста вибув із бою.");}
}
