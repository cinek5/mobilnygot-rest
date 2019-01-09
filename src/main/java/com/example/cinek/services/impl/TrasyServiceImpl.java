package com.example.cinek.services.impl;

import com.example.cinek.Utils;
import com.example.cinek.exceptions.DuplicateNazwaTrasyException;
import com.example.cinek.exceptions.ExceptionMessages;
import com.example.cinek.exceptions.NotValidOrderInSkladowePunktyException;
import com.example.cinek.exceptions.TrasaAlreadyDeletedException;
import com.example.cinek.model.trasa.PunktTrasy;
import com.example.cinek.model.trasa.SkladowyPunktTrasy;
import com.example.cinek.model.trasa.TrasaPunktowana;
import com.example.cinek.repos.StaticDb;
import com.example.cinek.repos.TrasyRepository;
import com.example.cinek.services.interfaces.TrasyService;
import com.example.cinek.validators.TrasaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by Cinek on 07.01.2019.
 */
@Service
@Transactional
public class TrasyServiceImpl implements TrasyService {
    @Autowired
    private TrasyRepository trasyRepository;
    @Autowired
    private TrasaValidator trasaValidator;

    @Override
    public List<TrasaPunktowana> getAllTrasyPuntkowane() {
        return trasyRepository.findAllTrasyPunktowane();
    }

    @Override
    public TrasaPunktowana getTrasaPunktowanaById(Long id) {
        return trasyRepository.findTrasaPunktowanaById(id);
    }

    @Override
    public void updateTrasaPunktowana(Long id, TrasaPunktowana trasaPunktowana, Date dataModyfikacji) {
        TrasaPunktowana oldTrasa = trasyRepository.findTrasaPunktowanaById(id);
        oldTrasa.setDataUsuniecia(dataModyfikacji);
        trasaPunktowana.setPoprzedniaWersjaId(id);
        trasaPunktowana.setDataDodania(dataModyfikacji);
        trasyRepository.updateTrasa(oldTrasa);
        trasyRepository.insertTrasa(trasaPunktowana);
    }

    @Override
    public void insertTrasaPunktowana(TrasaPunktowana trasaPunktowana) {
        insertTrasaPunktowanaToDb(trasaPunktowana, new Date());
    }

    @Override
    public void deleteTrasaPunktowana(Long id, Date dataUsuniecia) {
        TrasaPunktowana trasaPunktowana = trasyRepository.findTrasaPunktowanaById(id);

        if(dataUsuniecia!=null)
        {
            throw new TrasaAlreadyDeletedException(ExceptionMessages.TRASA_ALREADY_DELETED);
        }

        trasaPunktowana.setDataUsuniecia(dataUsuniecia);
        trasyRepository.updateTrasa(trasaPunktowana);

    }
    private void insertTrasaPunktowanaToDb(TrasaPunktowana trasaPunktowana, Date dataDodania) {
        trasaPunktowana.setDataDodania(dataDodania);

        if(!trasaValidator.hasValidPunktyOrder(trasaPunktowana))
        {
            throw new NotValidOrderInSkladowePunktyException(ExceptionMessages.NOT_VALID_ORDER);
        }
        if(trasyRepository.findTrasaPunktowanaByNazwa(trasaPunktowana.getNazwa())!=null)
        {
            throw new DuplicateNazwaTrasyException(ExceptionMessages.DUPLICATE_NAZWA);
        }
        trasyRepository.insertTrasa(trasaPunktowana);
    }
}
