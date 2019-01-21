package com.example.cinek.services.inmemory;

import com.example.cinek.exceptions.ExceptionMessages;
import com.example.cinek.exceptions.TrasaNotFoundException;
import com.example.cinek.model.DTO.PathToVerify;
import com.example.cinek.model.DTO.Status;
import com.example.cinek.model.Wedrowka.TrasaSkladowa;
import com.example.cinek.model.trasa.TrasaNiepunktowana;
import com.example.cinek.model.uzytkownik.Przodownik;
import com.example.cinek.repos.StaticDb;
import com.example.cinek.services.interfaces.WalkVerificationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InMemoryWalkVerificationServiceImpl implements WalkVerificationService
{
    @Override
    public PathToVerify getPathToVerify(Przodownik przodownik)
    {/*
        Optional<TrasaSkladowaLite> trasaPunktowanaOptional = StaticDb.trasySkladowe.stream()
                .filter(trasa -> trasa.getVerifyPrzodownik() == null
                        && przodownik.getAuthorizedGrupy().contains(trasa.getTrasa().getGrupaGorska())).findAny();

        if(trasaPunktowanaOptional.isPresent())
        {
            Optional<Wedrowka> wedrowkaOptional = StaticDb.wedrowki.stream()
                    .filter(w -> w.getTrasySkladowe().contains(trasaPunktowanaOptional.get())).findAny();

            Optional<Turysta> turystaOptional = StaticDb.turysci.stream()
                    .filter(t -> t.getWedrowki().contains(wedrowkaOptional.get())).findAny();

            return new PathToVerify(turystaOptional.get(), wedrowkaOptional.get(), trasaPunktowanaOptional.get());
        }*/
        return null;
    }

    @Override
    public void setStatus(Long id, Status status, Long przodownikId, Integer points)
    {
        Optional<TrasaSkladowa> trasaSkladowaOptional = StaticDb.trasySkladowe.stream()
                .filter(trasa -> trasa.getId().equals(id)).findAny();
        if (trasaSkladowaOptional.isPresent())
        {
            trasaSkladowaOptional.get().setStatus(status);
            if(trasaSkladowaOptional.get().getTrasa() instanceof TrasaNiepunktowana)
            {
                trasaSkladowaOptional.get().getTrasa().setPunktyRegulaminowe(points);
            }
            Optional<Przodownik> przodownikOptional = StaticDb.przodownicy.stream()
                    .filter(p -> p.getId().equals(przodownikId)).findAny();
            przodownikOptional.ifPresent(przodownik -> trasaSkladowaOptional.get().setVerifyPrzodownik(przodownikOptional.get()));
        }
        else
        {
            throw new TrasaNotFoundException(ExceptionMessages.TRASA_NOT_FOUND);
        }
    }
}
