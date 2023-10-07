package si.feri.opj.Hristovski.Zagon;

import java.time.LocalDate;
import si.feri.opj.Hristovski.Hiking.*;

/**
 *
 * @author Jovan Hristovski
 * @version 17
 *
 */

public class Zagonski {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        /*
        Kraj kraj = new Kraj("Skopje", "Macedonia");
        //Plezalisce plezalisce = new Plezalisce("Plezalisce Skopje", kraj, true);
        //PlezalniCenter plezalniCenter = new PlezalniCenter("MountainClimbers10", "mountainclimb23@gmail.com");
        LocalDate date = LocalDate.parse("2022-03-15");
        //PlezalnaSmer plezalnaSmer = new PlezalnaSmer(1000, date);
        //System.out.println(plezalisce.smerUrejena(plezalnaSmer));
        Kraj kr = new Kraj();
        //System.out.println(kr.getDrzava());
        Plezalisce pl = new Plezalisce("Skopje", kr, true, TipSmeri.KOMBINACIJA);
        //System.out.println(pl);
        //PlezalniCenter pc = new PlezalniCenter("RockyMountains5","rocky123@gmail.com", "069 722 222", kraj);
        //System.out.println(pc.getEmail());

        //pl.dodajPlezalnoSmer(plezalnaSmer);
        //pl.odstraniPlezalnoSmer(plezalnaSmer);
        //pl.odstraniPlezalnoSmer(plezalnaSmer);
        //pl.vrniSteviloSmeri();
        //pl.smerObstaja(plezalnaSmer.getOznaka());


//        Plezalisce plez = new Plezalisce("Galicnik", kraj, true, TipSmeri.KOMBINACIJA);
//        BalvanskiCenter bc = new BalvanskiCenter("Italyboulder","090 221 567", new Kraj("Milano","Italy"),TipSmeri.BALVANSKI);
//        PlezalnaSmer plezSmer = new PlezalnaSmer(1,"Mario","2",date,TipSmeri.VISINSKA);
//        System.out.println(plez);
//        System.out.println(bc);
//        System.out.println(plezSmer);


        try{
            BalvanskiCenter bc = new BalvanskiCenter("Italyboulder",-2,true);

        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }

        try{
            PlezalnaSmer ps = new PlezalnaSmer(TipSmeri.VISINSKA);
            Plezalisce p = new Plezalisce("Galicnik", kraj, true, TipSmeri.KOMBINACIJA);
            p.setSmer(TipSmeri.BALVANSKI);
            p.dodajPlezalnoSmer(ps);
        }catch(TipSmeriException e){
            e.printStackTrace();
        }

        try{
            //LocalDate ld = LocalDate.parse("2020-03-30");
            Plezalisce p = new Plezalisce("Galicnik", kraj, true, TipSmeri.KOMBINACIJA);
            p.setSmer(TipSmeri.BALVANSKI);
            PlezalnaSmer pz = new PlezalnaSmer(1,"Mario","2",date,TipSmeri.VISINSKA);
            p.smerUrejena(pz);
        } catch (SmerNeurejenaException e) {
            e.printStackTrace();
        }



*/
    }


}
