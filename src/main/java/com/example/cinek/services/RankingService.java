package com.example.cinek.services;

import com.example.cinek.model.uzytkownik.Turysta;

import java.util.List;

public interface RankingService
{
    List<Turysta> getRank();
    int getPositionInList(List<Turysta> list, Long userId);
}
