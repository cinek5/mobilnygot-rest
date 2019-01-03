package com.example.cinek.services;

import com.example.cinek.model.trasa.TrasaPunktowana;
import com.example.cinek.repos.StaticDb;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Cinek on 29.12.2018.
 */
@Service
public class TrasyServiceImpl implements TrasyService {
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
       }
       else
       {
           return null;
       }
    }

    @Override
    public void updateTrasaPunktowana(Long id, TrasaPunktowana trasaPunktowana, Date dataModyfikacji) {
        TrasaPunktowana oldTrasa = getTrasaPunktowanaById(id);
        if (oldTrasa!=null) {
            trasaPunktowana.setPoprzedniaWersjaId(oldTrasa.getId());
            insertTrasaPunktowanaToDb(trasaPunktowana, dataModyfikacji);
            deleteTrasaPunktowana(id, dataModyfikacji);
        }


    }

    @Override
    public void insertTrasaPunktowana(TrasaPunktowana trasaPunktowana) {
        insertTrasaPunktowanaToDb(trasaPunktowana, new Date());
    }

    private void insertTrasaPunktowanaToDb(TrasaPunktowana trasaPunktowana, Date dataDodania)
    {
        trasaPunktowana.setId(new Long(StaticDb.trasyPunktowane.size()+1));
        trasaPunktowana.setDataDodania(dataDodania);
        StaticDb.trasyPunktowane.add(trasaPunktowana);
    }

    @Override
    public void deleteTrasaPunktowana(Long id, Date dataUsuniecia) {
        TrasaPunktowana trasaPunktowana = getTrasaPunktowanaById(id);
        if (trasaPunktowana!=null)
        {
            trasaPunktowana.setDataUsuniecia(dataUsuniecia);
        }
    }
}
