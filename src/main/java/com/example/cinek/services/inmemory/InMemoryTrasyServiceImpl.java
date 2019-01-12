package com.example.cinek.services.inmemory;

import com.example.cinek.exceptions.DuplicateNazwaTrasyException;
import com.example.cinek.exceptions.ExceptionMessages;
import com.example.cinek.exceptions.NotValidOrderInSkladowePunktyException;
import com.example.cinek.model.trasa.PunktTrasy;
import com.example.cinek.model.trasa.SkladowyPunktTrasy;
import com.example.cinek.model.trasa.TrasaPunktowana;
import com.example.cinek.repos.StaticDb;
import com.example.cinek.services.interfaces.TrasyService;
import com.example.cinek.validators.TrasaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Cinek on 29.12.2018.
 */
public class InMemoryTrasyServiceImpl implements TrasyService {
    @Autowired
    private TrasaValidator trasaValidator;

    @Override
    public List<TrasaPunktowana> getAllTrasyPuntkowane() {
        return StaticDb.trasyPunktowane;
    }

    @Override
    public TrasaPunktowana getTrasaPunktowanaById(Long id) {
        Optional<TrasaPunktowana> trasaPunktowanaOptional = StaticDb.trasyPunktowane.stream()
                .filter(trasa -> trasa.getId().equals(id)).findAny();
        if (trasaPunktowanaOptional.isPresent()) {
            return trasaPunktowanaOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public void updateTrasaPunktowana(Long id, TrasaPunktowana trasaPunktowana, Date dataModyfikacji) {
        TrasaPunktowana oldTrasa = getTrasaPunktowanaById(id);
        if (oldTrasa != null) {
            trasaPunktowana.setPoprzedniaWersjaId(oldTrasa.getId());
            insertTrasaPunktowanaToDb(trasaPunktowana, dataModyfikacji);
            deleteTrasaPunktowana(id, dataModyfikacji);
        }


    }

    @Override
    public void insertTrasaPunktowana(TrasaPunktowana trasaPunktowana) {
        insertTrasaPunktowanaToDb(trasaPunktowana, new Date());
    }

    private void insertTrasaPunktowanaToDb(TrasaPunktowana trasaPunktowana, Date dataDodania) {
        trasaPunktowana.setId(StaticDb.nextIdTrasy++);
        trasaPunktowana.setDataDodania(dataDodania);

        if(!trasaValidator.hasValidPunktyOrder(trasaPunktowana))
        {
            throw new NotValidOrderInSkladowePunktyException(ExceptionMessages.NOT_VALID_ORDER);
        }

        if(StaticDb.trasyPunktowane.stream().filter(trasa -> trasa.getNazwa().equals(trasaPunktowana.getNazwa())).findAny().isPresent())
        {
            throw new DuplicateNazwaTrasyException(ExceptionMessages.DUPLICATE_NAZWA);
        }


        for (SkladowyPunktTrasy skladowyPunktTrasy : trasaPunktowana.getSkladowePunktyTrasy()) {
            PunktTrasy punktTrasy = skladowyPunktTrasy.getPunktTrasy();
            if (!StaticDb.punktyTrasy
                    .stream()
                    .filter(punkt -> punkt.getNazwaPunktu().equals(punktTrasy.getNazwaPunktu()))
                    .findAny()
                    .isPresent()  )
            {
                punktTrasy.setId(StaticDb.nextIdPunktyTrasy++);
                StaticDb.punktyTrasy.add(punktTrasy);
            }
        }

        StaticDb.trasyPunktowane.add(trasaPunktowana);
        StaticDb.trasy.add(trasaPunktowana);
    }

    @Override
    public void deleteTrasaPunktowana(Long id, Date dataUsuniecia) {
        TrasaPunktowana trasaPunktowana = getTrasaPunktowanaById(id);
        if (trasaPunktowana != null) {
            trasaPunktowana.setDataUsuniecia(dataUsuniecia);
        }
    }

    @Override
    public List<TrasaPunktowana> getTrasyStartingInPunkt(Long punktId) {
        return null;
    }

}
