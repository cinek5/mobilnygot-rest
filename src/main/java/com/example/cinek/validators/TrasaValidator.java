package com.example.cinek.validators;

import com.example.cinek.model.trasa.Trasa;

/**
 * Created by Cinek on 06.01.2019.
 */
public interface TrasaValidator {
    boolean hasValidPunktySize(Trasa trasa);
    boolean hasValidPunktyOrder(Trasa trasa);
    boolean hasPunktySameGrupaAsTrasa(Trasa trasa);
}
