package com.example.cinek.services.impl;

import com.example.cinek.model.DTO.wedrowka.PunktTrasyLite;
import com.example.cinek.model.DTO.wedrowka.TrasaPunktowanaLite;
import com.example.cinek.model.DTO.wedrowka.WedrowkaLite;
import com.example.cinek.model.Wedrowka.TrasaSkladowa;
import com.example.cinek.model.Wedrowka.Wedrowka;
import com.example.cinek.model.trasa.PunktTrasy;
import com.example.cinek.model.trasa.SkladowyPunktTrasy;
import com.example.cinek.model.trasa.TrasaPunktowana;
import com.example.cinek.repos.WedrowkaRepository;
import com.example.cinek.services.interfaces.CreateWedrowkaService;
import com.example.cinek.services.interfaces.TrasyService;
import com.example.cinek.utils.DistanceCalcultor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Cinek on 13.01.2019.
 */
@Service
@Transactional
public class CreateWedrowkaServiceImpl implements CreateWedrowkaService {

    @Autowired
    private TrasyService trasyService;
    @Autowired
    private WedrowkaRepository wedrowkaRepository;

    @Override
    public List<TrasaPunktowanaLite> getTrasyPktLiteStartingInPunkt(Long punktId) {
        List<TrasaPunktowana> trasyPkt = trasyService.getTrasyStartingInPunkt(punktId);
        trasyPkt.forEach(trasaPunktowana -> trasaPunktowana.getSkladowePunktyTrasy().sort((p1,p2)-> p1.getKolejnoscPunktu()-p2.getKolejnoscPunktu()));

        List<TrasaPunktowanaLite> trasyPktLites = new ArrayList<>();

        trasyPkt.forEach(trasaPunktowana -> {
            List<SkladowyPunktTrasy> skladowyPunktyTrasy = trasaPunktowana.getSkladowePunktyTrasy();
            PunktTrasy punktPoczatkowy = skladowyPunktyTrasy.get(0).getPunktTrasy();
            PunktTrasy punktKoncowy = trasaPunktowana.getSkladowePunktyTrasy().get(skladowyPunktyTrasy.size()-1).getPunktTrasy();

            DistanceCalcultor distanceCalcultor = new DistanceCalcultor();
            float distance = distanceCalcultor.calculateDistanceInKm(punktPoczatkowy, punktKoncowy);

            TrasaPunktowanaLite trasaLite = new TrasaPunktowanaLite.Builder()
                    .withIdTrasy(trasaPunktowana.getId())
                    .withNazwaTrasy(trasaPunktowana.getNazwa())
                    .withLiczbaPunktow(trasaPunktowana.getPunktyRegulaminowe())
                    .withPunktPoczatkowy(PunktTrasyLite.createFromPunktTrasy(punktPoczatkowy))
                    .withPunktKoncowy(PunktTrasyLite.createFromPunktTrasy(punktKoncowy))
                    .withDistance(distance)
                    .build();
            trasyPktLites.add(trasaLite);


        });

        return trasyPktLites;

    }

    @Override
    public void createWedrowka(WedrowkaLite wedrowkaLite) {
        List<TrasaSkladowa> trasySkladowe = new ArrayList<>();
        String nazwaWedrowki = wedrowkaLite.getNazwa();
        Wedrowka wedrowka = new Wedrowka();
        wedrowka.setNazwaWedrowki(nazwaWedrowki);
        wedrowka.setDataWedrowki(new Date());
        wedrowka.setPunktyZaWedrowke(wedrowkaLite.calcPtsSum());
        wedrowkaLite.getTrasySkladowe().forEach(trasaSkladowaLite -> {
           Long idTrasy =  trasaSkladowaLite.getTrasaPunktowanaLite().getIdTrasy();
           TrasaPunktowana trasa = trasyService.getTrasaPunktowanaById(idTrasy);
            TrasaSkladowa trasaSkladowa = new TrasaSkladowa();
            trasaSkladowa.setTrasa(trasa);
            trasaSkladowa.setWedrowka(wedrowka);
            trasySkladowe.add(trasaSkladowa);
        });
        wedrowkaRepository.insertWedrowka(wedrowka);

    }
}
