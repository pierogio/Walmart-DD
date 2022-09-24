package classes;

import java.util.ArrayList;
import java.util.Random;

public class CharacterFactory {

    private final String[] names = {"Marge", "Bart", "Apu", "Lisa"};
    Random r = new Random();

    protected String getRandomName(ArrayList<Character> party) {
        int randomNum = r.nextInt((names.length - 1 ) + 1) ;
        String name = names[randomNum];
        return setRandomName(name, party);
    }

    private String setRandomName(String name, ArrayList<Character> party) {
        StringBuilder newName = new StringBuilder(name);
        for (Character character : party) if(character.getName().equals(name)) newName.append(" Jr.");
        return newName.toString();
    }
}