package si.feri.opj.Hristovski.Hiking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jovan Hristovski
 * @version 17
 *
 */

public class PlezalniCenter extends Lokacija {
    /**
     * We declare naziv, email, telefon and kraj
     */
    private String email;
    private String telefon;
    private ArrayList<PlezalnaSmer> plezalneSmeri;
    private TipSmeri smer;
    private int kapaciteta;
    private double curr;

    /**
     * Defining a constructor in which we assign just naziv and email
     * @param naziv How its called
     * @param email The email
     */

    /*private PlezalniCenter (String naziv, String email) {
        this.setNaziv(naziv);
        this.setEmail(email);
0    }*/

    /**
     *  @param naziv Some naziv name
     * @param kapaciteta
     * @param kraj Some kraj city
     * @param smer Some type smer
     * @param telefon Phone number
     */
    public PlezalniCenter(String naziv, int kapaciteta, String kraj, TipSmeri smer, String telefon){
        super(naziv, kraj, smer);
        this.telefon = telefon;
        this.kapaciteta = kapaciteta;
        this.curr = 0;
    }


    public PlezalniCenter (String naziv, int kapaciteta) throws IllegalArgumentException {
        if (kapaciteta < 0){
            throw new IllegalArgumentException();
        }
        setNaziv(naziv);
        this.plezalneSmeri = new ArrayList<>();
    }




    /**
     *
     * @param email Accepts email and sets it in the object
     */
    public void setEmail (String email) {
        this.email = email;
    }

    /**
     *
     * @return Returns the value email
     */
    public String getEmail () {
        return this.email;
    }

    /**
     *
     * @param telefon Accepts telefon and sets it in the object
     */
    public void setTelefon (String telefon) {
        this.telefon = telefon;
    }

    /**
     *
     * @return Returns the value telefon
     */
    public String getTelefon () {
        return this.telefon;
    }


    public ArrayList<PlezalnaSmer> getPlezalneSmeri() {
        return plezalneSmeri;
    }


    /**
     *
     * @param smer it creats smer in PlezalniCenter
     */
    public void ustvariSmer (PlezalnaSmer smer) {
        if (this.curr < this.kapaciteta){
            this.plezalneSmeri.add(smer);
            this.curr += 1;
        }
        // TODO what happens if there isn't enough capacity
    }

    /**
     * In PlezalniCenter gets rid of plezalne smeri
     */
    public void razdriSmer () {
        this.plezalneSmeri.clear();
    }

    /**
     *
     * @return Returns percantage occupancy PlezalniCenter with PlezalneSmeri
     */
    public double vrniZasedenost () {
        return this.curr/getPlezalneSmeri().size();
    }

    /**
     *
     * @return It returns the capacity PlezalniCenter
     */

    /**
     *
     * @return Returns the value given to it in a String format
     */
    @Override
    public String toString() {
        return "PlezalniCenter{" +
                "email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", plezalneSmeri=" + Arrays.toString(plezalneSmeri.toArray()) +
                ", smer=" + smer +
                '}';
    }
}
