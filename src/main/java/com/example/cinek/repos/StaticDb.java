package com.example.cinek.repos;

import com.example.cinek.model.Wedrowka.TrasaSkladowa;
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
        SkladowyPunktTrasy skladowyPunktTrasy1 = new SkladowyPunktTrasy(punktTrasy1, 1);
        SkladowyPunktTrasy skladowyPunktTrasy2 = new SkladowyPunktTrasy(punktTrasy2, 2);
        TrasaPunktowana trasaPunktowana = null;
        try {
           trasaPunktowana = new TrasaPunktowana(new Long(1), "Malownicza trasa", asList(skladowyPunktTrasy1, skladowyPunktTrasy2), grupaGorska, 200,
                    sdf.parse("02/10/2018"), null);
        } catch (ParseException ex) {}
        trasy.add(trasaPunktowana);
        trasyPunktowane.add(trasaPunktowana);
        grupyGorskie.add(grupaGorska);
        punktyTrasy.addAll(asList(punktTrasy1, punktTrasy2));
    }
}
