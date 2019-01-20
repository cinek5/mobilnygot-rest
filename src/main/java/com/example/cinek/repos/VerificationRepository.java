package com.example.cinek.repos;

import com.example.cinek.model.DTO.Status;
import com.example.cinek.model.Wedrowka.TrasaSkladowa;

import java.util.List;

public interface VerificationRepository
{
    List<TrasaSkladowa> getWaitingTracksWithPermissionsTo(Long verId);
    void changeStatusForCompoundTrack(Long trackId, Status status, Long leaderId, Integer points);
}
