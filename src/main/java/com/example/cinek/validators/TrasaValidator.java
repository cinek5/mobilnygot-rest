package com.example.cinek.services.validators;

import com.example.cinek.model.trasa.Trasa;
import com.example.cinek.model.trasa.TrasaPunktowana;

/**
 * Created by Cinek on 06.01.2019.
 */
public interface TrasaValidator {
    boolean hasValidPunktyOrder(Trasa trasa);
}
