package com.example.cinek.services.impl;

import com.example.cinek.model.DTO.GroupList;
import com.example.cinek.model.DTO.Pair;
import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.repos.GrupyRepository;
import com.example.cinek.services.interfaces.GrupyGorskieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cinek on 12.01.2019.
 */
@Service
public class GrupaGorskaServiceImpl implements GrupyGorskieService {

    @Autowired
    private GrupyRepository grupyRepository;
    @Override
    public List<GrupaGorska> getAllGrupyGorskie() {
        return grupyRepository.findAllGrupyGorskie();
    }

    @Override
    public GroupList getAllGrupyGorskieLite()
    {
        List<GrupaGorska> mgs =  grupyRepository.findAllGrupyGorskie();
        GroupList groupList = new GroupList(mgs.size());
        for(GrupaGorska mg : mgs)
        {
            groupList.add(mg.getId(), mg.getNazwaGrupy());
        }
        return groupList;
    }

    @Override
    public List<GrupaGorska> getGrupyGorskieAssociatedWithAnyTrasa() {
        return grupyRepository.findGrupyGorskieThatAreAssociatedWithAnyTrasa();
    }
}
