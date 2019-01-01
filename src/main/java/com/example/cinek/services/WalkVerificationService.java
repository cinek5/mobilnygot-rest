package com.example.cinek.services;

import com.example.cinek.model.Wedrowka.TrasaSkladowa;
import com.example.cinek.model.trasa.Status;
import com.example.cinek.model.uzytkownik.Przodownik;

public interface WalkVerificationService
{
    TrasaSkladowa getTrasaToVerification(Przodownik przodownik);
    void setStatus(Long id, Status status);
}
