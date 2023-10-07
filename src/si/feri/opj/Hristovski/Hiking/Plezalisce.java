package si.feri.opj.Hristovski.Hiking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jovan Hristovski
 * @version 17
 *
 */

public class Plezalisce extends Lokacija {

    /**
     * We declare naziv, kraj, jeUrejeno, plezalneSmeri
     */


    private boolean jeUrejeno;
    private ArrayList<PlezalnaSmer> plezalneSmeri;
    private TipSmeri smer;
    private String Kraj ;

    @Override
    public String getDrzava() {
        return drzava;
    }

    @Override
    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    private String drzava;

    @Override
    public String getKraj() {
        return Kraj;
    }

    @Override
    public void setKraj(String kraj) {
        Kraj = kraj;
    }




    /**
     *
     * @param naziv We declare how its called
     * @param kraj We declare the town
     */
    /*private Plezalisce(String naziv, Kraj kraj) {
        this.setKraj(kraj);
        this.setNaziv(naziv);
    }*/

    /**
     *
     * @param naziv Some name naziv
     * @param kraj  Some city and state kraj
     * @param jeUrejeno Some jeUrejen parametar
     * @param smer Type smeri
     */
    public Plezalisce (String naziv, String kraj, boolean jeUrejeno, TipSmeri smer, String drzava) {
        super(naziv, kraj, smer);
        setJeUrejeno(jeUrejeno);
        plezalneSmeri = new ArrayList<>();
        this.drzava = drzava;
    }

    public boolean isJeUrejeno() {
        return jeUrejeno;
    }

    public ArrayList<PlezalnaSmer> getPlezalneSmeri() {
        return plezalneSmeri;
    }

    public void setPlezalneSmeri(ArrayList<PlezalnaSmer> plezalneSmeri) {
        this.plezalneSmeri = plezalneSmeri;
    }
    public Plezalisce(){}

    @Override
    public TipSmeri getSmer() {
        return smer;
    }

    @Override
    public void setSmer(TipSmeri smer) {
        this.smer = smer;
    }

    /**
     * It checks the time in teh moment
     * @param plezalnaSmer We declare parameter plezalnaSmer
     * @return Returns a value of the date
     */
    public void smerUrejena (PlezalnaSmer plezalnaSmer) throws SmerNeurejenaException {
        LocalDate zadnjiPregled = plezalnaSmer.getZadnjiPregled();
        LocalDate date = LocalDate.now().minusDays(31);
        if(date.isBefore(zadnjiPregled)) {
          throw new SmerNeurejenaException();
        }
    }


    /**
     *
     * @param jeUrejeno Accepts jeUrejeno and sets it in the object
     */
    public void setJeUrejeno (boolean jeUrejeno) {
        this.jeUrejeno = jeUrejeno;
    }

    /**
     *
     * @return Returns the value jeUrejeno
     */
    public boolean getJeUrejeno () {
        return this.jeUrejeno;
    }




    /**
     * Method which adds the smer to the array plezalne smeri
     * @param plezalnaSmeri We declare the parameter array plezalnaSmeri
     * @return Returns either the value true or false
     */
    public boolean dodajPlezalnoSmer (PlezalnaSmer plezalnaSmeri)  throws  TipSmeriException {
        if(plezalnaSmeri.getTipSmeri() != null && !(plezalnaSmeri.getTipSmeri().equals(this.smer))){
            throw new TipSmeriException();
        }

        plezalneSmeri.add(plezalnaSmeri);
        return true;

    }

    /**
     * Method which gets rid of the smer from the array plezalna smeri
     * @param plezalnaSmeri We declare the parameter array plezalnaSmeri
     */
    public void odstraniPlezalnoSmer (PlezalnaSmer plezalnaSmeri) {
        for (int i=0; i < this.plezalneSmeri.size(); i++) {
            if (this.plezalneSmeri.get(i).equals(plezalnaSmeri)) {
                    this.plezalneSmeri.remove(i);
                break;
            }
        }
    }


    /**
     * Method which allows to get rid of smeri from the array plezalne smeri
     * @param oznaka We declare the parameter int oznaka
     * @return Returns either the value true or false
     */
    public boolean odstraniPlezalnoSmer (int oznaka) {
        for (int i=0; i < this.plezalneSmeri.size(); i++)
            if (this.plezalneSmeri.get(i).getOznaka() == oznaka) {
                this.plezalneSmeri.remove(i);
                return true;
            }
        return false;
    }


    /**
     * Method which returns the number smeri in plezalisce
     * @return Returns the number
     */
    public int vrniSteviloSmeri() {
        return this.plezalneSmeri.size();
    }


    /**
     * Method that checks if smer with specific tag already exists in plezalisce
     * @param oznaka We declare the parameter oznaka
     * @return Returns either true or false
     */
    public boolean smerObstaja(int oznaka) {
        for(int i=0; i < this.plezalneSmeri.size(); i++) {
            if(this.plezalneSmeri.get(i).getOznaka() == oznaka)
                return true;
        }
        return false;

    }


    @Override
    public String toString() {
        return "Plezalisce{" +
                "jeUrejeno=" + jeUrejeno +
                ", plezalneSmeri=" + Arrays.toString(plezalneSmeri.toArray()) +
                ", smer=" + smer +
                '}';
    }
}
