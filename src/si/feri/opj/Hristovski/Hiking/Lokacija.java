package si.feri.opj.Hristovski.Hiking;

public class Lokacija {

    private String naziv;
    private String kraj;
    private TipSmeri smer;
    private String ime;
    private String drzava;

    public Lokacija(){};

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public Lokacija(String naziv, String kraj, TipSmeri smer){
        this.naziv = naziv;
        this.kraj = kraj;
        this.smer = smer;
    }

    public Lokacija(String naziv, String kraj, TipSmeri smer, String ime, String drzava) {
        this.naziv = naziv;
        this.kraj = kraj;
        this.smer = smer;
        this.ime = ime;
        this.drzava = drzava;
    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public TipSmeri getSmer() {
        return smer;
    }

    public void setSmer(TipSmeri smer) {
        this.smer = smer;
    }

    @Override
    public String toString() {
        return "Lokacija{" +
                "naziv='" + naziv + '\'' +
                ", kraj=" + kraj +
                ", smer=" + smer +
                '}';
    }


}
