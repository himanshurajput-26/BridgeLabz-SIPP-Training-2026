class GameCharacter {
    protected String characterName; // [cite: 204]

    public GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    public void performAttack() { // [cite: 206]
        System.out.println(characterName + " performs a basic generic action.");
    }
}

class Warrior extends GameCharacter { // [cite: 208]
    public Warrior(String characterName) { super(characterName); }
    @Override
    public void performAttack() { // [cite: 211]
        System.out.println("[WARRIOR] " + characterName + " unleashes a devastating Ground Slam with their Broadsword!");
    }
}

class Mage extends GameCharacter { // [cite: 209]
    public Mage(String characterName) { super(characterName); }
    @Override
    public void performAttack() { // [cite: 211]
        System.out.println("[MAGE] " + characterName + " channels mana to cast a blazing Fireball storm!");
    }
}

class Archer extends GameCharacter { // [cite: 210]
    public Archer(String characterName) { super(characterName); }
    @Override
    public void performAttack() { // [cite: 211]
        System.out.println("[ARCHER] " + characterName + " fires a piercing volley of Sonic Arrows from afar!");
    }
}

public class AdventureGame {
    public static void startBattle(GameCharacter[] characters) { // [cite: 216]
        System.out.println("=== The Battle Begins! ===");
        int warriorCount = 0, mageCount = 0, archerCount = 0; // 

        for (GameCharacter c : characters) {
            c.performAttack(); // Polymorphic dispatch invocation [cite: 217]

            // Identifying and tracking subclass instance categories 
            if (c instanceof Warrior) warriorCount++;
            else if (c instanceof Mage) mageCount++;
            else if (c instanceof Archer) archerCount++;
        }

        System.out.println("\n=== Combat Engagement Logistics ===");
        System.out.println("Total Warriors Active: " + warriorCount);
        System.out.println("Total Mages Active: " + mageCount);
        System.out.println("Total Archers Active: " + archerCount);
    }

    public static void main(String[] args) {
        GameCharacter[] roster = { // [cite: 213]
            new Warrior("Thorin"), // [cite: 214]
            new Mage("Gandalf"), // [cite: 214]
            new Archer("Legolas"), // [cite: 214]
            new Mage("Merlin") // [cite: 214]
        };
        startBattle(roster);
    }
}