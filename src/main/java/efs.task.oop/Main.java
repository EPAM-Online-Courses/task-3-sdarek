package efs.task.oop;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Villager kashya = new Villager("Kashya", 30);
        ExtraordinaryVillager akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);
        Villager gheed = new Villager("Gheed", 50);
        ExtraordinaryVillager deckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        Villager warriv = new Villager("Warriv", 35);
        Villager flawia = new Villager("Flawia", 25);

        kashya.sayHello();
        akara.sayHello();
        gheed.sayHello();
        deckardCain.sayHello();
        warriv.sayHello();
        flawia.sayHello();

        // Ukrywanie ExtraordinaryVillager jako obiekty typu Object
        Object objectDeckardCain = deckardCain;
        Object objectAkara = akara;

        // Przeprowadzenie bitwy
        int monstersHealth = Monsters.getMonstersHealth();
        Fighter currentFighter = getNextFighter(kashya, akara, gheed, deckardCain, warriv, flawia);

        while (monstersHealth > 0 && currentFighter.getHealth() > 0) {
            if (currentFighter instanceof Villager) {
                Villager villager = (Villager) currentFighter;
                if (villager.getHealth() > 0) {
                    villager.attack(Monsters.andariel);
                    System.out.println("Aktualnie walczacy osadnik to " + villager.getName());
                }
            } else if (currentFighter instanceof ExtraordinaryVillager) {
                ExtraordinaryVillager extraordinaryVillager = (ExtraordinaryVillager) currentFighter;
                if (extraordinaryVillager.getHealth() > 0) {
                    extraordinaryVillager.attack(Monsters.blacksmith);
                    System.out.println("Aktualnie walczacy ExtraordinaryVillager to " + extraordinaryVillager.getName());
                }
            } else if (currentFighter instanceof Monster) {
                Monster monster = (Monster) currentFighter;
                if (monster.getHealth() > 0) {
                    monster.attack(getRandomVillager(kashya, akara, gheed, deckardCain, warriv, flawia));
                    System.out.println("Aktualnie walczacy potwor to " + monster.getClass().getSimpleName());
                }
            }

            monstersHealth = Monsters.getMonstersHealth();
            System.out.println("Potwory posiadaja jeszcze " + monstersHealth + " punktow zycia.");

            currentFighter = getNextFighter(kashya, akara, gheed, deckardCain, warriv, flawia);
        }

        System.out.println("Obozowisko ocalone!");

        // Przywrócenie mocy ExtraordinaryVillager'om przez zrzutowanie
        deckardCain = (ExtraordinaryVillager) objectDeckardCain;
        akara = (ExtraordinaryVillager) objectAkara;

        // Wywołanie metod z klasy ExtraordinaryVillager
        deckardCain.sayHello();
        akara.sayHello();
    }

    private static Villager getRandomVillager(Villager... villagers) {
        Random random = new Random();
        return villagers[random.nextInt(villagers.length)];
    }

    private static Fighter getNextFighter(Fighter... fighters) {
        Random random = new Random();
        return fighters[random.nextInt(fighters.length)];
    }
}
