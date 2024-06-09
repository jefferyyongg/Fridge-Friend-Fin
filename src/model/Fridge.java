package model;

import java.util.*;

public class Fridge extends Observable {
    private List<String> fridge;

    public Fridge(List<String> fridge) {
        this.fridge = fridge != null ? fridge : new ArrayList<>();
    }

    public void toonFridge(){
        if(fridge.isEmpty()){
            System.out.println("Geen Ingedienten.");

        }
        else {
            for(int i = 0; i < fridge.size(); i++) {
                System.out.println(i + ". " + fridge.get(i));
            }
        }
    }

    public List<String> getFridge() {
        return fridge;
    }

    public void setFridge(List<String> fridge) {
        this.fridge = fridge;
    }

    public void addIngredient(String ingredient){
        fridge.add(ingredient);
        System.out.println("Ingredient Toegevoegd.");
    }

    public void removeIngredient(int index) {
        if (fridge.isEmpty()) {
            System.out.println("Geen Recepten\n");
        } else if (index < fridge.size()) {
            fridge.remove(index);
            System.out.println("Ingredient Verwijderd.");
        } else {
            System.out.println("Ongeldige Invoer");
        }
    }

    public void getUniqueIngredients(List<String> ingredienten){
        List<String> uniqueIngredients = new ArrayList<>();
        for(String s : ingredienten){
            uniqueIngredients.add(s);
        }

        for(int i = 0; i < uniqueIngredients.size(); i++){
            for(int j = 0; j < fridge.size(); j++){
                if(uniqueIngredients.contains(fridge.get(j))){
                    uniqueIngredients.remove(i);
                }
            }
        }
        setChanged();
        notifyObservers(uniqueIngredients);
    }
}
