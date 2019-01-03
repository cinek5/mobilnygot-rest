package com.example.cinek.repos;

import com.example.cinek.model.Wedrowka.TrasaSkladowa;
import com.example.cinek.model.Wedrowka.Wedrowka;
import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.model.trasa.*;
import com.example.cinek.model.uzytkownik.Przodownik;
import com.example.cinek.model.uzytkownik.Turysta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Cinek on 04.10.2018.
 */
public class StaticDb {
    public static List<Trasa> trasy = new ArrayList<>();
    public static List<TrasaPunktowana> trasyPunktowane = new ArrayList<>();
    public static List<GrupaGorska> grupyGorskie = new ArrayList<>();
    public static List<PunktTrasy> punktyTrasy = new ArrayList<>();
    public static List<Przodownik> przodownicy = new ArrayList<>();
    public static List<Turysta> turysci = new ArrayList<>();
    public static List<TrasaSkladowa> trasySkladowe = new ArrayList<>();

    static
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        GrupaGorska grupaGorska = new GrupaGorska(new Long(1),"Tatry");
        PunktTrasy punktTrasy1 = new PunktTrasy(new Long(1), "Punkt1", 200, 48,39  );
        PunktTrasy punktTrasy2 = new PunktTrasy(new Long(2), "Punkt2", 300, 58,49  );
        PunktTrasy punktTrasy3 = new PunktTrasy(new Long(3), "Punkt3", 234, 38,42  );
        PunktTrasy punktTrasy4 = new PunktTrasy(new Long(3), "Punkt4", 666, 47,29  );
        SkladowyPunktTrasy skladowyPunktTrasy1 = new SkladowyPunktTrasy(punktTrasy1, 1);
        SkladowyPunktTrasy skladowyPunktTrasy2 = new SkladowyPunktTrasy(punktTrasy2, 2);
        SkladowyPunktTrasy skladowyPunktTrasy3 = new SkladowyPunktTrasy(punktTrasy3, 1);
        SkladowyPunktTrasy skladowyPunktTrasy4 = new SkladowyPunktTrasy(punktTrasy4, 2);
        TrasaPunktowana trasaPunktowana1 = null;
        TrasaPunktowana trasaPunktowana2 = null;
        try {
           trasaPunktowana1 = new TrasaPunktowana(1L, "Malownicza trasa", asList(skladowyPunktTrasy1, skladowyPunktTrasy2), grupaGorska, 200,
                    sdf.parse("02/10/2018"), null);
            trasaPunktowana2 = new TrasaPunktowana(3L, "Trasa króla", asList(skladowyPunktTrasy3, skladowyPunktTrasy4), grupaGorska, 676,
                    sdf.parse("04/11/2018"), null);
        } catch (ParseException ex) {}
        trasy.addAll(asList(trasaPunktowana1, trasaPunktowana2));
        trasyPunktowane.addAll(asList(trasaPunktowana1,trasaPunktowana2));
        grupyGorskie.add(grupaGorska);
        punktyTrasy.addAll(asList(punktTrasy1, punktTrasy2, punktTrasy3, punktTrasy4));












        Turysta turysta = new Turysta();
        turysta.setZgromadzonePunkty(100);
        Wedrowka w = new Wedrowka();
        try  {
            w.setDataWedrowki(sdf.parse("02/10/2018"));
            TrasaSkladowa ts = new TrasaSkladowa();
            ts.setStatus(Status.potwierdzona);
            ts.setTrasa(new TrasaPunktowana(2L, "W te i nazad", null, grupaGorska,
                    90, sdf.parse("02/10/2018"), sdf.parse("02/10/2018")));
            ArrayList<TrasaSkladowa> tsl = new ArrayList<>();
            tsl.add(ts);
            w.setTrasySkladowe(tsl);
        }
        catch (Exception e) {}
        ArrayList<Wedrowka> lw = new ArrayList<>();
        lw.add(w);
        turysta.setWedrowki(lw);
        turysta.setImie("Janusz");
        turysta.setNazwisko("Pawlacz");
        turysci.add(turysta);
    }
}
