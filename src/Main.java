import classes.*;
import classes.Character;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final Party party1 = new Party("party1");
    private static final Party party2 = new Party("party2");

    private static Party selectedParty;

    public static void main(String[] args) throws FileNotFoundException {
        mainMenu();
    }

    public static void mainMenu() throws FileNotFoundException {
        System.out.println("1 - Select parties");
        System.out.println("2 - Start battle");
        System.out.println("3 - Exit");
        System.out.println("Select option:");

        int selection = INPUT.nextInt();

        switch (selection) {
            case 1:
                selectPartiesMenu();
                break;
            case 2:
                if(party1.isVoid() || party2.isVoid()) {
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

    public static void selectPartiesMenu() throws FileNotFoundException {
        if (party1.isVoid()) {
            System.out.println("1 - Select party-1");
        } else {
            System.out.println("1 - Change party-1");
        }
        if (party2.isVoid()) {
            System.out.println("2 - Select party-2");
        } else {
            System.out.println("2 - Change party-2");
        }
        System.out.println("3 - Done");
        System.out.println("Select option:");

        int selection = INPUT.nextInt();

        switch (selection) {
            case 1 -> {
                selectedParty = party1;
                partyMenu();
            }
            case 2 -> {
                selectedParty = party2;
                partyMenu();
            }
            case 3 -> mainMenu();
            default -> {
                System.err.println("Please select one of these options:");
                selectPartiesMenu();
            }
        }
    }

    public static void partyMenu() throws FileNotFoundException {
        System.out.println(selectedParty.getName());
        System.out.println("1 - Create character");
        System.out.println("2 - Random party");
        System.out.println("3 - Import party");
        System.out.println("Select option:");

        int selection = INPUT.nextInt();

        switch (selection) {
            case 1 -> createCharacterMenu();
            case 2 -> {
                selectedParty.createRandom(3);
                System.out.println(selectedParty.getName() + " has been created: " + selectedParty.toString());
                selectPartiesMenu();
            }
            case 3 -> {
                importCSV();
                System.out.println(selectedParty.getName() + " has been imported: " + selectedParty.toString());
                selectPartiesMenu();
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
    public static void createCharacterMenu() throws FileNotFoundException {
        System.out.println(selectedParty.getName());
        System.out.println("1 - Add wizard");
        System.out.println("2 - Add warrior");
        System.out.println("3 - Done");
        System.out.println("Select option:");

        int selection = INPUT.nextInt();

        switch (selection) {
            case 1:
                selectedParty.addCharacter(createWizard());
                createCharacterMenu();
                break;
            case 2:
                selectedParty.addCharacter(createWarrior());
                createCharacterMenu();
                break;
            case 3:
                selectPartiesMenu();
                break;
        }
    }

    public static Character createWizard(){
        System.out.print("Name: ");
        INPUT.nextLine();
        String wizardName = INPUT.nextLine();
        System.out.print("HP: ");
        int hpPoints = INPUT.nextInt();
        INPUT.nextLine();
        System.out.print("Mana: ");
        int manaPoints = INPUT.nextInt();
        INPUT.nextLine();
        System.out.print("Intelligence: ");
        int intelligencePoints = INPUT.nextInt();
        INPUT.nextLine();

        Character newWizard = new Wizard(wizardName, hpPoints, manaPoints, intelligencePoints);
        System.out.println(newWizard + " has been created");

        return newWizard;
    }

    public static Character createWarrior(){
        System.out.print("Name: ");
        INPUT.nextLine();
        String warriorName = INPUT.nextLine();
        System.out.print("HP: ");
        int hpPoints = INPUT.nextInt();
        INPUT.nextLine();
        System.out.print("Stamina: ");
        int staminaPoints = INPUT.nextInt();
        INPUT.nextLine();
        System.out.print("Strength: ");
        int strengthPoints = INPUT.nextInt();
        INPUT.nextLine();

        Character newWarrior = new Warrior(warriorName, hpPoints, staminaPoints, strengthPoints);
        System.out.println(newWarrior + " has been created");

        return newWarrior;
    }

    public static void importCSV() throws FileNotFoundException {
        ArrayList<Character> importedParty = new ArrayList<>();
        File partyCSV = new File("party.csv");
        Scanner scanner = new Scanner(partyCSV);
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            //System.out.println(scanner.nextLine());
            String[] characterProperties = scanner.nextLine().split(",");
            String charType = characterProperties[0];
            String charName = characterProperties[1];
            int charHP = Integer.parseInt(characterProperties[2]);
            int charManaOrStamina = Integer.parseInt(characterProperties[3]);
            int charIntelOrStrength = Integer.parseInt(characterProperties[4]);
            if (charType.equals("wizard")) {
                importedParty.add(new Wizard(charName, charHP, charManaOrStamina, charIntelOrStrength));
            } else {
                importedParty.add(new Warrior(charName, charHP, charManaOrStamina, charIntelOrStrength));
            }
            selectedParty.setListOfCharacters(importedParty);
            characterProperties = new String[4];
        }
    }




}