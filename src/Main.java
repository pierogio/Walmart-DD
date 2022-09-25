import classes.*;
import classes.Character;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final Party party1 = new Party("party1");
    private static final Party party2 = new Party("party2");

    private static Party selectedParty;

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

    public static void selectPartiesMenu() {
        int selection;
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

        selection = INPUT.nextInt();

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

    public static void partyMenu() {
        System.out.println(selectedParty.getName());
        System.out.println("1 - Create character");
        System.out.println("2 - Random party");
        System.out.println("3 - Import party");
        System.out.println("Select option:");

        int selection = INPUT.nextInt();

        switch (selection) {
            case 1 -> System.out.println("Create character"); //FUNCTIONALITY PENDING
            case 2 -> {
                selectedParty.createRandom(3);
                System.out.println(selectedParty.getName() + " has been created: " + selectedParty.toString());
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
}