package com.example.cinek.services.impl;

import com.example.cinek.exceptions.*;
import com.example.cinek.model.trasa.Trasa;
import com.example.cinek.model.trasa.TrasaPunktowana;
import com.example.cinek.repos.TrasyRepository;
import com.example.cinek.services.interfaces.TrasyService;
import com.example.cinek.validators.TrasaValidator;
import org.springframework.beans.factory.annotation.Autowired;
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

        trasaPunktowana.setDataUsuniecia(dataUsuniecia);
        trasyRepository.updateTrasa(trasaPunktowana);

    }
    private void insertTrasaPunktowanaToDb(TrasaPunktowana trasaPunktowana, Date dataDodania) {
        trasaPunktowana.setDataDodania(dataDodania);

        validateTrasa(trasaPunktowana);

        trasyRepository.insertTrasa(trasaPunktowana);
    }

    private void validateTrasa(Trasa trasa)
    {
        if(!trasaValidator.hasValidPunktySize(trasa))
        {
            throw new TrasaNotEnoughPunktyException(ExceptionMessages.TRASA_NOT_ENOUGH_PUNKTY);
        }

        if(!trasaValidator.hasValidPunktyOrder(trasa))
        {
            throw new NotValidOrderInSkladowePunktyException(ExceptionMessages.NOT_VALID_ORDER);
        }
        if(!trasaValidator.hasPunktySameGrupaAsTrasa(trasa))
        {
            throw new TrasaAndPunktDifferentGroupsException(ExceptionMessages.TRASA_PUNT_DIFFERENT_GROUPS);
        }

        if(trasa instanceof TrasaPunktowana && trasyRepository.findTrasaPunktowanaByNazwa(((TrasaPunktowana)trasa).getNazwa())!=null)
        {
            throw new DuplicateNazwaTrasyException(ExceptionMessages.DUPLICATE_NAZWA);
        }
    }
    @Override
    public List<TrasaPunktowana> getTrasyStartingInPunkt(Long punktId) {
        return trasyRepository.findTrasyPunktowaneStartingAtPunkt(punktId);
    }

    @Override
    public List<TrasaPunktowana> getTrasyPunktowaneByQuery(String query) {
        return trasyRepository.findTrasyPunktowaneByQuery(query);
    }
}
