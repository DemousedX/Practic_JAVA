package dz_do_practic_2;

public class Ex5 {
    public static void main(String[] args) {
        String characterName = "Денисенко Олександр";
        String characterClass = "Ассасін";

        int strength = (int) (Math.random() * (18 - 8 + 1)) + 8;
        int agility = (int) (Math.random() * (18 - 8 + 1)) + 8;
        int intelligence = (int) (Math.random() * (18 - 8 + 1)) + 8;

        int healthPoints = strength * 10 + agility * 2;
        int manaPoints = intelligence * 15;
        int armor = agility / 2;

        int dice1 = (int) (Math.random() * 6) + 1;
        int dice2 = (int) (Math.random() * 6) + 1;
        final int MONSTER_ATTACK = 22;
        int playerAttack = dice1 + dice2 + strength;
        boolean isPlayerVictory = playerAttack > MONSTER_ATTACK;

        System.out.println("****************************************************");
        System.out.println("*                 ПАСПОРТ ГЕРОЯ RPG                *");
        System.out.println("****************************************************");
        System.out.println("Ім'я персонажа:          " + characterName);
        System.out.println("Клас:                    " + characterClass);
        System.out.println();
        System.out.println("[ХАРАКТЕРИСТИКИ]");
        System.out.println("Сила (STR):              " + strength);
        System.out.println("Спритність (AGI):        " + agility);
        System.out.println("Інтелект (INT):          " + intelligence);
        System.out.println();
        System.out.println("[ПОХІДНІ АТРИБУТИ]");
        System.out.println("Очки здоров'я (HP):      " + healthPoints);
        System.out.println("Очки мани (MP):          " + manaPoints);
        System.out.println("Клас броні (Armor):      " + armor);
        System.out.println();
        System.out.println("[СИМУЛЯЦІЯ БОЮ]");
        System.out.println("Кидок кубиків гравця:    " + dice1 + " + " + dice2
                + " (бонус сили: +" + strength + ")");
        System.out.println("Загальна атака гравця:   " + playerAttack);
        System.out.println("Сила удару монстра:      " + MONSTER_ATTACK);
        System.out.println("Чи переміг гравець?      " + isPlayerVictory);
        System.out.println("\\**************************************************/");
    }
}
