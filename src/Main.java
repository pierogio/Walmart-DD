import classes.Character;
import classes.RandomUtils;
import classes.WarriorFactory;
import classes.WizardFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String PARTY1_NAME = "party1";
    private static final String PARTY2_NAME = "party2";
    private static final Scanner INPUT = new Scanner(System.in);
    private static ArrayList<Character> party1 = new ArrayList<>();
    private static ArrayList<Character> party2 = new ArrayList<>();
    private static String selectedPartyName;

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        int selection;
        System.out.println("1 - Select parties");
        System.out.println("2 - Start battle");
        System.out.println("3 - Exit");
        System.out.println("Select option:");

        selection = INPUT.nextInt();

        switch (selection) {
            case 1:
                selectPartiesMenu(party1, party2);
                break;
            case 2:
                if(party1.size() == 0 || party2.size() == 0) {
                    System.err.println("Select parties");
                    mainMenu();
                }
                else battleMenu();
                break;
            case 3:
                INPUT.close();
                break;
            default:
                System.out.println("Please select one of these options:");
                mainMenu();
        }
    }

    public static void selectPartiesMenu(ArrayList<Character> party1, ArrayList<Character> party2) {
        int selection;
        if (party1.size() > 0) {
            System.out.println("1 - Change party-1");
        } else {
            System.out.println("1 - Select party-1");
        }
        if (party2.size() > 0) {
            System.out.println("2 - Change party-2");
        } else {
            System.out.println("2 - Select party-2");
        }
        System.out.println("3 - Done");
        System.out.println("Select option:");

        selection = INPUT.nextInt();

        switch (selection) {
            case 1 -> {
                selectedPartyName = PARTY1_NAME;
                partyMenu();
            }
            case 2 -> {
                selectedPartyName = PARTY2_NAME;
                partyMenu();
            }
            case 3 -> mainMenu();
            default -> {
                System.err.println("Please select one of these options:");
                selectPartiesMenu(party1, party2);
            }
        }
    }

    public static void partyMenu() {
        System.out.println(selectedPartyName);
        System.out.println("1 - Create character");
        System.out.println("2 - Random party");
        System.out.println("3 - Import party");
        System.out.println("Select option:");

        int selection = INPUT.nextInt();

        switch (selection) {
            case 1 -> System.out.println("Create character"); //FUNCTIONALITY PENDING
            case 2 -> {
                if (selectedPartyName.equals(PARTY1_NAME)) {
                    party1 = createRandomParty();
                    System.out.println(selectedPartyName + " has been created: " + party1.toString());
                } else {
                    party2 = createRandomParty();
                    System.out.println(selectedPartyName + " has been created: " + party2.toString());
                }
                selectPartiesMenu(party1, party2);
            }
        }
    }

    public static void battleMenu() {

        System.out.println("1 - Show graveyard");
        System.out.println("2 - Choose party-1 Character");
        System.out.println("3 - Choose party-2 Character");
        System.out.println("4 - Start!");
        System.out.println("Select option:");

        int selection = INPUT.nextInt();

        switch (selection) {
            case 1:
                System.out.println("show graveyard"); //PENDING
                break;
            case 2:
                //Chose character method pending
                battleMenu();
                break;
            case 3:
                //Chose character method pending
                battleMenu();
                break;
            case 4:
               //Battle method pending
        }
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