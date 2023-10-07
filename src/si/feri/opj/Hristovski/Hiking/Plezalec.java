package si.feri.opj.Hristovski.Hiking;

import java.util.ArrayList;

/**
 *
 * @author Jovan Hristovski
 * @version 17
 *
 */

public class Plezalec implements IPlezanje{

    /**
     * We declare ime, priimek and stevilkaLicence
     */

    private String ime;
    private String priimek;
    private int stevilkaLicence;
    private ArrayList<PlezalnaSmer> preplezalniSmeri;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public int getStevilkaLicence() {
        return stevilkaLicence;
    }

    public void setStevilkaLicence(int stevilkaLicence) {
        this.stevilkaLicence = stevilkaLicence;
    }

    /**
     * Defining a constructor in which we assign just ime and priimek
     * @param ime Name of the human
     * @param priimek Lastname of the human
     */
    public Plezalec (String ime, String priimek) {
        this.ime = ime;
        this.priimek = priimek;
        this.preplezalniSmeri = new ArrayList<>();
    }

    public Plezalec (String ime, String priimek,int stevilkaLicence) {
        this.ime = ime;
        this.priimek = priimek;
        this.stevilkaLicence = stevilkaLicence;
        this.preplezalniSmeri = new ArrayList<>();
    }



    /**
     * A constructor
     */
    public Plezalec () {

    }

    /**
     *
     * @return Returns the value given to it in a String format
     */
    @Override
    public String toString() {
        return "Plezalec{" +
                "ime='" + ime + '\'' +
                ", priimek='" + priimek + '\'' +
                ", stevilkaLicence=" + stevilkaLicence +
                '}';
    }


    // What the climber has and haven't climbed yet. So that the
    // climber adds only the direction that he didn't climb.
    public boolean alreadyHasSmer(PlezalnaSmer hassmer){
        for (int i=0; i < this.preplezalniSmeri.size(); i++){
            if (this.preplezalniSmeri.equals(hassmer)){
                return true;
            }
        }
        return false;
    }


    @Override
    public void plezaj(PlezalniCenter center) throws SmerPreplezanaException {
        ArrayList<PlezalnaSmer> plezalnaSmers = center.getPlezalneSmeri();

        if (center instanceof BalvanskiCenter) { // We use instance of to check if the object is an instance of the specified class.

             //We go through every value and we try to add it.
                for (int i = 0; i < center.getPlezalneSmeri().size(); i++)  {

                        if(this.alreadyHasSmer(center.getPlezalneSmeri().get(i))){ //alreadyHasSmer is for not repeating that ones that he climbed.
                            throw new SmerPreplezanaException();
                        }
                }
            this.preplezalniSmeri.addAll(center.getPlezalneSmeri());
            }


        else {
            //We go through every value and we try to add it.
            for (int i = 0; i < center.getPlezalneSmeri().size(); i++) {
                //In VisinskiCenter the climber can climb maximum of 3 routes.

                if (i == 3) {
                    break;
                }
                if (this.alreadyHasSmer(center.getPlezalneSmeri().get(i))) { //alreadyHasSmer is for not repeating that ones that he climbed.
                    throw new SmerPreplezanaException();
                }
                this.preplezalniSmeri.add(plezalnaSmers.get(i));
            }
        }
    }
}
