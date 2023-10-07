package si.feri.opj.Hristovski.Hiking;

public class VisinskiCenter extends PlezalniCenter{

    public VisinskiCenter(String naziv, int kapaciteta) {
        super(naziv, kapaciteta);
    }



    public int vrniKapaciteta() {
        return getPlezalneSmeri().size();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
