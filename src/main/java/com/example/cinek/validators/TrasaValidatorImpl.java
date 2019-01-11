package com.example.cinek.validators;

import com.example.cinek.model.grupa.GrupaGorska;
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
    public boolean hasValidPunktySize(Trasa trasa) {
        return trasa.getSkladowePunktyTrasy().size() >= 2;
    }

    @Override
    public boolean hasValidPunktyOrder(Trasa trasa) {
        List<SkladowyPunktTrasy> skladowePunktyTrasy = trasa.getSkladowePunktyTrasy();
        sortSkladowePunkty(skladowePunktyTrasy);
        int currentPos = 1;
        for (SkladowyPunktTrasy punkt : skladowePunktyTrasy) {
            if (punkt.getKolejnoscPunktu() != currentPos) {
                return false;
            }
            currentPos++;
        }
        return true;
    }

    @Override
    public boolean hasPunktySameGrupaAsTrasa(Trasa trasa) {
        List<SkladowyPunktTrasy> skladowePunktyTrasy = trasa.getSkladowePunktyTrasy();
        String grupaGorska = trasa.getGrupaGorska().getNazwaGrupy();
        return skladowePunktyTrasy
                .stream()
                .filter(skladowyPunktTrasy -> !skladowyPunktTrasy
                        .getPunktTrasy()
                        .getGrupaGorska()
                        .getNazwaGrupy().equals(grupaGorska)).findAny().isPresent();


    }

    private void sortSkladowePunkty(List<SkladowyPunktTrasy> skladowePunktyTrasy)
    {
        skladowePunktyTrasy.sort((p1, p2) -> Integer.compare(p1.getKolejnoscPunktu(), p2.getKolejnoscPunktu()));
    }
}
