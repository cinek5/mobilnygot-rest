package com.example.cinek.services.interfaces;

import com.example.cinek.model.DTO.PathToVerify;
import com.example.cinek.model.DTO.Status;

public interface WalkVerificationService
{
    PathToVerify getPathToVerify(Long leaderId);
    void setStatus(Long trackId, Status status, Long leaderId, Integer points);
}
