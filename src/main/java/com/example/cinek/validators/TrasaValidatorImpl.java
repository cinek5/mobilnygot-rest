package com.example.cinek.services.validators;

import com.example.cinek.model.trasa.SkladowyPunktTrasy;
import com.example.cinek.model.trasa.Trasa;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Cinek on 06.01.2019.
 */
@Component
public class TrasaValidatorImpl implements TrasaValidator {
    @Override
    public boolean hasValidPunktyOrder(Trasa trasa) {
        List<SkladowyPunktTrasy> skladowePunktyTrasy = trasa.getSkladowePunktyTrasy();
        skladowePunktyTrasy.sort((p1,p2) -> Integer.compare(p1.getKolejnoscPunktu(), p2.getKolejnoscPunktu()));
        int kolejnosc=1;
        for (SkladowyPunktTrasy punkt : skladowePunktyTrasy)
        {
            if (punkt.getKolejnoscPunktu()!=kolejnosc) {
                return false;
            }
        }
        return true;
    }
}
