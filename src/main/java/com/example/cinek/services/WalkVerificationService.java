package com.example.cinek.services;

import com.example.cinek.model.trasa.TrasaSkladowa;

public interface WalkVerificationService
{
    TrasaSkladowa getTrasaToVerification(Long przodownikId);
    void confirmTrasa(Long id);
    void discardTrasa(Long id);
    void reconsiderTrasa(Long id);
}
