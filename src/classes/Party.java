package classes;

import java.util.ArrayList;

public class Party {
    private String name;
    private ArrayList<Character> listOfCharacters = new ArrayList<>();

    public Party(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Character> getListOfCharacters() {
        return listOfCharacters;
    }

    public Character getCharacter(int index) {
        return listOfCharacters.get(index);
    }


    public void setListOfCharacters(ArrayList<Character> listOfCharacters) {
        this.listOfCharacters = listOfCharacters;
    }

    public void addCharacter(Character character){
        listOfCharacters.add(character);
    }

    public void removeCharacter(Character character){
        listOfCharacters.remove(character);
    }

    public void removeCharacter(int index){
        listOfCharacters.remove(index);
    }

    public String toString() {
        return "Party {" +
                "name='" + name + '\'' +
                ", listOfCharacters=" + listOfCharacters +
                '}';
    }
}

