package com.example.cinek.services;

import com.example.cinek.exceptions.TrasaNotFoundException;
import com.example.cinek.model.trasa.Status;
import com.example.cinek.model.Wedrowka.TrasaSkladowa;
import com.example.cinek.model.uzytkownik.Przodownik;
import com.example.cinek.repos.StaticDb;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalkVerificationServiceImpl implements WalkVerificationService
{
    @Override
    public TrasaSkladowa getTrasaToVerification(Przodownik przodownik)
    {
        Optional<TrasaSkladowa> trasaPunktowanaOptional = StaticDb.trasySkladowe.stream()
                .filter(trasa -> trasa.getVerifyPrzodownik() == null
                        && przodownik.getAuthorizedGrupy().contains(trasa.getTrasa().getGrupaGorska())).findAny();
        return trasaPunktowanaOptional.orElse(null);
    }

    @Override
    public void setStatus(Long id, Status status)
    {
        Optional<TrasaSkladowa> trasaSkladowaOptional = StaticDb.trasySkladowe.stream()
                .filter(trasa -> trasa.getId().equals(id)).findAny();
        if (trasaSkladowaOptional.isPresent())
        {
            trasaSkladowaOptional.get().setStatus(status);
        }
        else
        {
            throw new TrasaNotFoundException();
        }
    }
}