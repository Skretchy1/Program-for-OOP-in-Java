package si.feri.opj.Hristovski.Hiking;

public class BalvanskiCenter extends PlezalniCenter{

    private boolean moznostRazsiritve;


    public BalvanskiCenter(String naziv, String telefon, String kraj,  int kapaciteta, TipSmeri smer) {
        super(naziv, kapaciteta, kraj, smer, telefon);
    }

    public BalvanskiCenter(String naziv, int kapaciteta, boolean razsiritev) {
        super(naziv, kapaciteta);
        this.moznostRazsiritve = razsiritev;

        super.setSmer(TipSmeri.BALVANSKI);
    }


    public void setMoznostRazsiritve (boolean moznostRazsiritve) {
        this.moznostRazsiritve = moznostRazsiritve;
    }

    public boolean isMoznostRazsiritve() {
        return this.moznostRazsiritve;
    }


    /**
     *
     * @return It returns kapaciteta BalvanskiCenter
     */

    public int vrniKapaciteta() {
        int multi = 1;
        if (this.moznostRazsiritve) {
            multi = 2;
        }
        return super.getPlezalneSmeri().size() * multi;
    }


    @Override
    public String toString() {
        return "BalvanskiCenter{" +
                "moznostRazsiritve=" + moznostRazsiritve +
                '}';
    }
}
