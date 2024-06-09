package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Fridge;
import model.Recept;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HandleJSON {

    public List<Recept> getReceptenBoek(){
        List<Recept> receptenBoek;
        try(FileReader reader = new FileReader("src/util/ReceptenBoek.json")){
            Gson gson = new Gson();
            Type recipeListType = new TypeToken<List<Recept>>(){}.getType();
            receptenBoek = gson.fromJson(reader, recipeListType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return receptenBoek;
    }

    public void saveReceptenBoek(List<Recept> receptenBoek){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("src/util/ReceptenBoek.json")) {
            gson.toJson(receptenBoek, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getFridge(){
        List<String> fridge;
        try(FileReader reader = new FileReader("src/util/Fridge.json")){
            Gson gson = new Gson();
            fridge = gson.fromJson(reader, List.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fridge;
    }

    public void saveFridge(List<String> fridge){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("src/util/Fridge.json")) {
            gson.toJson(fridge, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getBoodschappenLijst(){
        List<String> boodschappenLijst;
        try(FileReader reader = new FileReader("src/util/Boodschappenlijst.json")){
            Gson gson = new Gson();
            boodschappenLijst = gson.fromJson(reader, List.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return boodschappenLijst;
    }

    public void saveBoodschappenLijst(List<String> boodschappenLijst){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("src/util/BoodschappenLijst.json")) {
            gson.toJson(boodschappenLijst, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
