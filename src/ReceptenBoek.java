import model.Recept;
import util.HandleJSON;

import java.util.ArrayList;
import java.util.List;

public class ReceptenBoek {
    private List<Recept> receptenBoek;

    public ReceptenBoek(List<Recept> receptenBoek) {
        this.receptenBoek = receptenBoek != null ? receptenBoek : new ArrayList<>();
    }

    public void toonRecepten(){
        if(receptenBoek.isEmpty()){
            System.out.println("Geen Recepten\n");
        } else {
            for (int i = 0; i < receptenBoek.size(); i++) {
                System.out.println(i + ". " + receptenBoek.get(i).getTitle());
            }
        }
    }
    public void addRecept(Recept recept){
        receptenBoek.add(recept);
    }

    public void removeRecept(int index){
        if(receptenBoek.isEmpty()){
            System.out.println("Geen Recepten\n");
        }
        else if(index < receptenBoek.size()){
            receptenBoek.remove(index);
        } else {
            System.out.println("ongeldige invoer");
        }
    }

    public List<Recept> getReceptenBoek() {
        return receptenBoek;
    }

    public void setReceptenBoek(List<Recept> receptenBoek) {
        receptenBoek = receptenBoek;
    }
}
