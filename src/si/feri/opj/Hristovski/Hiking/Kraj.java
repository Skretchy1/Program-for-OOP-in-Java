package si.feri.opj.Hristovski.Hiking;
/**
 *
 * @author Jovan Hristovski
 * @version 17
 *
 */
public class Kraj {
    /**
     * We declare kraj and drzava
     */
     private String kraj;
     private String drzava;

    /**
     *
     * @param kraj Accepts kraj and sets it in the object
     */
    public void setKraj(String kraj){
        this.kraj = kraj;
    }

    /**
     *
     * @return Returns the value kraj
     */
    public String getKraj() {
        return this.kraj;
    }

    /**
     *
     * @param drzava Accepts naziv and sets it in the object
     */
    public void setDrzava(String drzava){
        this.drzava = drzava;
    }

    /**
     *
     * @return Returns the value kraj
     */
    public String getDrzava() {
        return this.drzava;
    }

    /**
     * Defining a constructor in which we assign kraj and drzava
     * @param kraj Some town kraj
     * @param drzava Some country drzava
     */
    public Kraj (String kraj, String drzava) {
        this.kraj = kraj;
        this.drzava = drzava;
    }

    /**
     * Defining a constructor in which we declare two attributes
     */
    public Kraj () {
        this("Skopje", "Macedonia");
    }

    /**
     *
     * @return Returns the value given to it in a String format
     */
    @Override
    public String toString() {
        return "Kraj{" +
                "kraj='" + kraj + '\'' +
                ", drzava='" + drzava + '\'' +
                '}';
    }
}


