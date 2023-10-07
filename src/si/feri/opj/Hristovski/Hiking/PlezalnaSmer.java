package si.feri.opj.Hristovski.Hiking;

import java.time.LocalDate;

/**
 *
 * @author Jovan Hristovski
 * @version 17
 *
 */

public class PlezalnaSmer implements IPlezanje{
    /**
     * We declare oznaka, ime, tezavnost and zadnjiPregled
     */
    private int oznaka;
    private String ime;
    private String tezavnost;
    private LocalDate zadnjiPregled;
    private TipSmeri smer;


    /**
     * Defining a constructor in which we assign all the attributes
     * @param oznaka Some number oznaka
     * @param ime Name of the human
     * @param tezavnost Some value tezavnost
     * @param zadnjiPregled The last checkup
     */
    public PlezalnaSmer (int oznaka, String ime, String tezavnost, LocalDate zadnjiPregled, TipSmeri smer) {
        this.oznaka=oznaka;
        this.zadnjiPregled=zadnjiPregled;
        this.tezavnost = tezavnost;
        this.ime = ime;
        this.smer = smer;
    }


    /**
     * Defining a private constructor in which we declare two attributes
     */
    public PlezalnaSmer(int oznaka, LocalDate zadnjiPregled) {
        this.setOznaka(oznaka);
        this.setZadnjiPregled(zadnjiPregled);
    }

    public PlezalnaSmer(TipSmeri smer){
        this.smer = smer;
    }




    public void setSmer(TipSmeri smer) {
        this.smer = smer;
    }

    public TipSmeri getSmer() {
        return smer;
    }

    /**
     *
     * @param oznaka Accepts oznaka and sets it in the object
     */
    public void setOznaka (int oznaka) {
        this.oznaka = oznaka;
    }

    /**
     *
     * @return Returns the value oznaka
     */
    public int getOznaka () {
        return this.oznaka;
    }

    /**
     *
     * @param ime Accepts ime and sets it in the object
     */
    public void setIme (String ime) {
        this.ime = ime;
    }

    /**
     *
     * @return Returns the value ime
     */
    public String getIme () {
        return this.ime;
    }

    /**
     *
     * @param tezavnost Accepts tezavnost and sets it in the object
     */
    public void setTezavnost (String tezavnost) {
        this.tezavnost = tezavnost;
    }

    /**
     *
     * @return Returns the value tezavnost
     */
    public String getTezavnost () {
        return this.tezavnost;
    }

    /**
     *
     * @param zadnjiPregled Accepts zadnjiPrelged and sets it in the object
     */
    public void setZadnjiPregled (LocalDate zadnjiPregled) {
        this.zadnjiPregled = zadnjiPregled;
    }

    /**
     *
     * @return Returns the value zadnjiPregled
     */
    public LocalDate getZadnjiPregled () {
        return this.zadnjiPregled;
    }

    public TipSmeri getTipSmeri (){
        return this.smer;
    }

    /**
     *
     * @return Returns the value given to it in a String format
     */
    @Override
    public String toString() {
        return "PlezalnaSmer{" +
                "oznaka=" + oznaka +
                ", ime='" + ime + '\'' +
                ", tezavnost='" + tezavnost + '\'' +
                ", zadnjiPregled=" + zadnjiPregled +
                '}';
    }


    @Override
    public void plezaj(PlezalniCenter center) { //It checks if the climbing route is in that picked climbing center.
        for (int i=0; i < center.getPlezalneSmeri().size();i++) {
            if (this.equals(center.getPlezalneSmeri().get(i))) {
                System.out.println("Plezalna smer se nahaja v centru " + center.getNaziv()); // And getNaziv for the name.
                break;
            }
        }
    }
}
