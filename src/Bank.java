import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Musteri> musteriList = new ArrayList<>();

    public List<Musteri> getMusteriList() {
        return musteriList;
    }

    public void setMusteriList(List<Musteri> musteriList) {
        this.musteriList = musteriList;
    }
}
