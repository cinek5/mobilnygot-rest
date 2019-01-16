package com.example.cinek.repos;

import com.example.cinek.model.Wedrowka.TrasaSkladowa;

import java.util.List;

public interface VerificationRepository
{
    List<TrasaSkladowa> getWaitingTracksWithPermissionsTo(Long verId);
    void changeStatusForCompoundTrack(Long trackId, Integer statusInt, Long leaderId, Integer points);
}
