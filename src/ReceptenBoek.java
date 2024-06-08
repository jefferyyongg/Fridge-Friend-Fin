import model.Recept;

import java.util.ArrayList;
import java.util.List;

public class ReceptenBoek {
    private List<Recept> receptenBoek;

    public ReceptenBoek(List<Recept> receptenBoek) {
        this.receptenBoek = receptenBoek != null ? receptenBoek : new ArrayList<>();
    }

    public void toonReceptenBoek(){
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
        System.out.println("Recept Toegevoegd.");
    }

    public void removeRecept(int index){
        if(receptenBoek.isEmpty()){
            System.out.println("Geen Recepten\n");
        }
        else if(index < receptenBoek.size()){
            receptenBoek.remove(index);
            System.out.println("Recept Verwijderd.");
        } else {
            System.out.println("Ongeldige Invoer");
        }
    }

    public List<Recept> getReceptenBoek() {
        return receptenBoek;
    }

    public void setReceptenBoek(List<Recept> receptenBoek) {
        receptenBoek = receptenBoek;
    }
}
