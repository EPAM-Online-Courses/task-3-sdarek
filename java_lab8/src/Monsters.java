public class Monsters {
    public static final Monster andariel = new Monster(10, 70) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(getDamage());
        }

        @Override
        public void takeHit(int damage) {
            health -= damage;
            decreaseMonstersHealth(damage);
        }
    };

    public static final Monster blacksmith = new Monster(100, 25) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(getDamage());
        }

        @Override
        public void takeHit(int damage) {
            health -= (5 + damage);
            decreaseMonstersHealth(5 + damage);
        }
    };

    private static int monstersHealth = andariel.getHealth() + blacksmith.getHealth();

    public static int getMonstersHealth() {
        return monstersHealth;
    }

    private static void decreaseMonstersHealth(int damage) {
        monstersHealth -= damage;
    }
}
