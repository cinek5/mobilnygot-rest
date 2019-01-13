package com.example.cinek.services.impl;

import com.example.cinek.model.DTO.wedrowka.PunktTrasyLite;
import com.example.cinek.model.DTO.wedrowka.TrasaPunktowanaLite;
import com.example.cinek.model.trasa.PunktTrasy;
import com.example.cinek.model.trasa.SkladowyPunktTrasy;
import com.example.cinek.model.trasa.TrasaPunktowana;
import com.example.cinek.services.interfaces.CreateWedrowkaService;
import com.example.cinek.services.interfaces.TrasyService;
import com.example.cinek.utils.DistanceCalcultor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cinek on 13.01.2019.
 */
@Service
@Transactional
public class CreateWedrowkaServiceImpl implements CreateWedrowkaService {

    @Autowired
    private TrasyService trasyService;

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
}
