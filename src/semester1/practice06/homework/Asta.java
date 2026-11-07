package semester1.practice06.homework;

public class Asta {
    private String name="Аста";
    private int hp=1000,maxHp=1000,antiMagicEnergy=0,baseAttack=120,defense=35;
    private boolean isBlackFormActive,limitPushed;
    private final String[] skills={"Удар Демоноборця","Чорний Ураган","Метеорит Демона","Форма Чорного Демона"};
    public Asta() { }
    public Asta(String name){if(name!=null&&!name.isBlank())this.name=name;}
    public int getHp(){return hp;} public int getAntiMagicEnergy(){return antiMagicEnergy;}
    public String[] getSkills(){return skills.clone();}
    public void showStatus(){int bars=(int)Math.round(10.0*hp/maxHp);System.out.printf("%s HP [%s%s] %d%% | Антимагія [%d%%] | Чорна форма: %s%n",name,"█".repeat(bars),"░".repeat(10-bars),hp*100/maxHp,antiMagicEnergy,isBlackFormActive?"активна":"ні");}
    public int basicSwordAttack(){antiMagicEnergy=Math.min(100,antiMagicEnergy+20);return isBlackFormActive?baseAttack*2:baseAttack;}
    public int useSkill(int skillIndex){if(skillIndex<0||skillIndex>=skills.length){System.out.println("Невідоме вміння.");return 0;}int[] costs={25,50,75,100},damage={220,380,550,0};if(antiMagicEnergy<costs[skillIndex]){System.out.println("Недостатньо енергії антимагії.");return 0;}antiMagicEnergy-=costs[skillIndex];if(skillIndex==3){isBlackFormActive=true;hp=Math.min(maxHp,hp+300);return 0;}return damage[skillIndex];}
    public void takeDamage(int incomingDmg){int actual=Math.max(15,incomingDmg-defense);hp=Math.max(0,hp-actual);}
    public void pushLimits(){if(!limitPushed&&hp>0&&hp<maxHp*.25){limitPushed=true;hp=Math.min(maxHp,hp+150);antiMagicEnergy=Math.min(100,antiMagicEnergy+50);System.out.println("Моя магія — ніколи не здаватися!");}}
    public boolean isAlive(){return hp>0;}
}
