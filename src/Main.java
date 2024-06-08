import model.Fridge;
import model.Recept;
import model.ZoekObject;
import util.HandleJSON;
import util.QueryService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void menuKeuze(){
        System.out.println("\nMenu:\n1. \uD83C\uDF5DReceptenBoek Opties\n2. ❄\uFE0FFridge Opties\n3. Boodschappen\n4. EXIT");
    }
    public static void menuKeuzeRecept(){
        System.out.println("\nReceptenBoek Menu:\n1. toon ReceptenBoek\n2. add Recept\n3. remove Recept");
    }
    public static void menuKeuzeFridge(){
        System.out.println("\nFridge Menu:\n1. toon Fridge\n2. add Ingredient\n3. remove Ingredient\n");
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        HandleJSON handleJSON = new HandleJSON();
        ReceptenBoek receptenBoek = new ReceptenBoek(handleJSON.getReceptenBoek());
        Fridge fridge = new Fridge(handleJSON.getFridge());
        QueryService queryService = new QueryService();

        while(true){
            menuKeuze();
            String input = scanner.nextLine();
            switch (input){
                //Receptenboek keuze
                case "1":
                    menuKeuzeRecept();
                    String receptKeuze = scanner.nextLine();
                    switch (receptKeuze) {
                        case "1":
                            System.out.println("=== ReceptenBoek ===");
                            receptenBoek.toonReceptenBoek();
                            break;
                        case "2":
                            System.out.println("=== Recept Toevoegen ===");
                            System.out.println("Geef Ingredient of gerecht: ");
                            String receptZoekenInput = scanner.nextLine();
                            List<ZoekObject.ZoekResultaten> zoekResultaten = queryService.handleResponse(queryService.handleRequest(receptZoekenInput)).getResults();
                            for (int i = 0; i < zoekResultaten.size(); i++) {
                                System.out.println(i + ". " + zoekResultaten.get(i).getTitle());
                            }

                            System.out.println("Voer index nummer in: ");
                            int receptToevoegenIndex = Integer.valueOf(scanner.nextLine());
                            if(receptToevoegenIndex < zoekResultaten.size()){
                                Recept recept = queryService.getRecept(zoekResultaten.get(receptToevoegenIndex));
                                receptenBoek.addRecept(recept);
                            } else {
                                System.out.println("Ongeldige Invoer");
                            }
                            break;
                        case "3":
                            System.out.println("=== Recept Verwijderen ===");
                            if(receptenBoek.getReceptenBoek().isEmpty()){
                                System.out.println("Geen Recepten.\n");
                                break;
                            } else {
                                receptenBoek.toonReceptenBoek();
                                int receptVerwijderIndex = Integer.valueOf(scanner.nextLine());
                                if(receptVerwijderIndex > receptenBoek.getReceptenBoek().size()){
                                    System.out.println("Ongeldige Invoer.");
                                } else {
                                    receptenBoek.removeRecept(receptVerwijderIndex);
                                }
                            }
                            break;
                        default:
                            System.out.println("Ongeldige Invoer.");
                            break;
                    }
                    handleJSON.saveReceptenBoek(receptenBoek.getReceptenBoek());
                    break;
                //Fridge Keuze
                case "2":
                    menuKeuzeFridge();
                    String fridgeKeuze = scanner.nextLine();
                    switch (fridgeKeuze) {
                        case "1":
                            System.out.println("=== Fridge ===");
                            fridge.toonFridge();
                            break;
                        case "2":
                            System.out.println("=== Ingredient Toevoegen ===");
                            System.out.println("Geef Ingredient: ");
                            String ingredientToevoegenInput = scanner.nextLine();
                            fridge.addIngredient(ingredientToevoegenInput);
                            handleJSON.saveFridge(fridge.getFridge());
                            break;
                        case "3":
                            System.out.println("=== Ingredient Verwijeren ===");
                            if(fridge.getFridge().isEmpty()){
                                System.out.println("Geen Ingredienten.");
                                break;
                            } else {
                                fridge.toonFridge();
                                int ingredientVerwijderIndex = Integer.valueOf(scanner.nextLine());
                                if(ingredientVerwijderIndex > fridge.getFridge().size()){
                                    System.out.println("Ongeldige Invoer.");
                                } else {
                                    fridge.removeIngredient(ingredientVerwijderIndex);
                                }
                            }
                            handleJSON.saveFridge(fridge.getFridge());
                            break;
                        default:
                            System.out.println("Ongeldige Invoer.");
                            break;
                    }
                    handleJSON.saveFridge(fridge.getFridge());
                    break;
                case "3":
                    break;
                case "4":
                    handleJSON.saveReceptenBoek(receptenBoek.getReceptenBoek());
                    handleJSON.saveFridge(fridge.getFridge());
                    System.out.println("Programma afsluiten...");
                    return;
                default:
                    System.out.println("ongeldige invoer.");
            }
        }
    }
}