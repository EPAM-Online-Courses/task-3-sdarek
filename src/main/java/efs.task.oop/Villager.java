package efs.task.oop;
public class Villager implements Fighter {
    private String name;
    private int age;
    protected int health;

    public Villager(String name, int age) {
        this.name = name;
        this.age = age;
        this.health = 100;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void attack(Fighter victim) {
        int damage = (int) ((100 - age * 0.5) / 10);
        victim.takeHit(damage);
    }

    @Override
    public void takeHit(int damage) {
        health -= damage;
    }

    public void sayHello() {
        System.out.println("Greetings traveler... I'm " + name + " and I'm " + age + " years old.");
    }
}
