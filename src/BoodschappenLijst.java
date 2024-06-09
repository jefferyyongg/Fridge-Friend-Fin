import model.Fridge;
import util.HandleJSON;

import java.util.*;

public class BoodschappenLijst implements Observer {
    List<String> boodschappenLijst;

    public BoodschappenLijst(List<String> boodschappenLijst, Fridge fridge){
        this.boodschappenLijst = boodschappenLijst;
        fridge.addObserver(this);
    }
    public List<String> getBoodschappenLijst() {
        return boodschappenLijst;
    }

    public void setBoodschappenLijst(List<String> boodschappenLijst) {
        this.boodschappenLijst = boodschappenLijst;
    }

    @Override
    public void update(Observable o, Object arg) {
        List<String> unique = (List<String>) arg;
        this.boodschappenLijst = unique;
    }
}