package com.example.cinek.services;

import com.example.cinek.model.Wedrowka.TrasaSkladowa;
import com.example.cinek.model.uzytkownik.Przodownik;

public interface WalkVerificationService
{
    TrasaSkladowa getTrasaToVerification(Przodownik przodownik);
    void confirmTrasa(Long id);
    void discardTrasa(Long id);
    void reconsiderTrasa(Long id);
}
