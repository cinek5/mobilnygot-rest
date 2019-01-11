package com.example.cinek.services.interfaces;

import com.example.cinek.model.DTO.PathToVerify;
import com.example.cinek.model.DTO.Status;
import com.example.cinek.model.uzytkownik.Przodownik;

public interface WalkVerificationService
{
    PathToVerify getPathToVerify(Przodownik przodownik);
    void setStatus(Long id, Status status, Long przodownikId, Integer points);
}
