package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
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


}
