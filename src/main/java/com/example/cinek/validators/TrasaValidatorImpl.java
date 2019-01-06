package com.example.cinek.validators;

import com.example.cinek.model.trasa.SkladowyPunktTrasy;
import com.example.cinek.model.trasa.Trasa;
import com.example.cinek.validators.TrasaValidator;
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
        int currentPos=1;
        for (SkladowyPunktTrasy punkt : skladowePunktyTrasy)
        {
            if (punkt.getKolejnoscPunktu()!=currentPos) {
                return false;
            }
            currentPos++;
        }
        return true;
    }
}
