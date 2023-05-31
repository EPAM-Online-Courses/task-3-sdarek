package efs.task.oop;
public abstract class Monster implements Fighter {
    protected int health;
    private int damage;

    public Monster(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    // Implementacje metod z interfejsu Fighter
    public abstract void attack(Fighter victim);
    public abstract void takeHit(int damage);
}
