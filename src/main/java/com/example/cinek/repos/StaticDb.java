package com.example.cinek.repos;

import com.example.cinek.model.Wedrowka.Status;
import com.example.cinek.model.Wedrowka.TrasaSkladowa;
import com.example.cinek.model.Wedrowka.Wedrowka;
import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.model.trasa.*;
import com.example.cinek.model.uzytkownik.Przodownik;
import com.example.cinek.model.uzytkownik.Turysta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Cinek on 04.10.2018.
 */
public class StaticDb {
    public static long nextIdPunktyTrasy= 0;
    public static long nextIdTrasy=4;

    public static List<Trasa> trasy = new ArrayList<>();
    public static List<TrasaPunktowana> trasyPunktowane = new ArrayList<>();
    public static List<GrupaGorska> grupyGorskie = new ArrayList<>();
    public static List<PunktTrasy> punktyTrasy = new ArrayList<>();
    public static List<Przodownik> przodownicy = new ArrayList<>();
    public static List<Wedrowka> wedrowki = new ArrayList<>();
    public static List<Turysta> turysci = new ArrayList<>();
    public static List<TrasaSkladowa> trasySkladowe = new ArrayList<>();

    static
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        GrupaGorska grupaGorska = new GrupaGorska(1l,"Tatry");
        PunktTrasy punktTrasy1 = new PunktTrasy(nextIdPunktyTrasy++, "Punkt1", 200, 48f,39f  );
        PunktTrasy punktTrasy2 = new PunktTrasy(nextIdPunktyTrasy++, "Punkt2", 300, 58f,49f  );
        PunktTrasy punktTrasy3 = new PunktTrasy(nextIdPunktyTrasy++, "Punkt3", 234, 38f,42f );
        PunktTrasy punktTrasy4 = new PunktTrasy(nextIdPunktyTrasy++, "Punkt4", 666, 47f,29f  );
        SkladowyPunktTrasy skladowyPunktTrasy1 = new SkladowyPunktTrasy(punktTrasy1, 1);
        SkladowyPunktTrasy skladowyPunktTrasy2 = new SkladowyPunktTrasy(punktTrasy2, 2);
        SkladowyPunktTrasy skladowyPunktTrasy3 = new SkladowyPunktTrasy(punktTrasy3, 1);
        SkladowyPunktTrasy skladowyPunktTrasy4 = new SkladowyPunktTrasy(punktTrasy4, 2);
        TrasaPunktowana trasaPunktowana1 = null;
        TrasaPunktowana trasaPunktowana2 = null;
        try {
           trasaPunktowana1 = new TrasaPunktowana(1l, "Malownicza trasa", asList(skladowyPunktTrasy1, skladowyPunktTrasy2), grupaGorska, 200,
                    sdf.parse("02/10/2018"), null);
            trasaPunktowana2 = new TrasaPunktowana(3L, "Trasa króla", asList(skladowyPunktTrasy3, skladowyPunktTrasy4), grupaGorska, 676,
                    sdf.parse("04/11/2018"), null);
        } catch (ParseException ex) {}
        trasy.addAll(asList(trasaPunktowana1, trasaPunktowana2));
        trasyPunktowane.addAll(asList(trasaPunktowana1,trasaPunktowana2));
        grupyGorskie.add(grupaGorska);
        Turysta turysta = new Turysta() {{setId(1L);}};
        punktyTrasy.addAll(asList(punktTrasy1, punktTrasy2, punktTrasy3, punktTrasy4));












        Turysta turysta = new Turysta();
        turysta.setZgromadzonePunkty(100);
        Wedrowka w = new Wedrowka();
        List<SkladowyPunktTrasy> skladowePunktyTrasy = new ArrayList<SkladowyPunktTrasy>()
                                                                {{add(skladowyPunktTrasy1); add(skladowyPunktTrasy2);}};
        try  {
            w.setDataWedrowki(sdf.parse("02/10/2018"));
            TrasaSkladowa ts = new TrasaSkladowa() {{setId(1L);}};
            trasySkladowe.add(ts);
            ts.setStatus(Status.oczekujaca);
            ts.setTrasa(new TrasaPunktowana(1L, "W te i nazad", skladowePunktyTrasy, grupaGorska,
                    90, sdf.parse("02/10/2018"), sdf.parse("02/10/2018")));
            TrasaSkladowa ts2 = new TrasaSkladowa() {{setId(2L);}};
            ts2.setStatus(Status.oczekujaca);
            ts2.setTrasa(new TrasaPunktowana(2L, "W te i w tamte", skladowePunktyTrasy, grupaGorska,
                    130, sdf.parse("02/10/2015"), sdf.parse("02/10/2016")));
            trasySkladowe.add(ts2);
            w.setTrasySkladowe(new ArrayList<TrasaSkladowa>() {{add(ts); add(ts2);}});
        }
        catch (Exception e) {}
        ArrayList<Wedrowka> lw = new ArrayList<>();
        lw.add(w);
        w.setId(1L);
        turysta.setWedrowki(lw);
        turysta.setImie("Janusz");
        turysta.setNazwisko("Piotrowski");
        turysci.add(turysta);
        wedrowki.add(w);
        Przodownik przodownik = new Przodownik();
        przodownik.setId(1L);
        przodownicy.add(przodownik);
    }
}
