import classes.Character;
import classes.RandomUtils;
import classes.WarriorFactory;
import classes.WizardFactory;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }

    public static ArrayList<Character> createRandomParty() {
        ArrayList<Character> randomParty = new ArrayList<>();
        WarriorFactory warriorFactory = new WarriorFactory();
        WizardFactory wizardFactory = new WizardFactory();

        while (randomParty.size() < 3) {
            int randomNum = RandomUtils.getRandomIntInRange(1, 0);
            if (randomNum == 1) {
                randomParty.add(warriorFactory.create(randomParty));
            } else {
                randomParty.add(wizardFactory.create(randomParty));
            }
        }

        return randomParty;
    }
}