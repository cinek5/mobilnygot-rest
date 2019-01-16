package com.example.cinek.services.impl;

import com.example.cinek.model.Converters.StatusToIntConverter;
import com.example.cinek.model.DTO.Pair;
import com.example.cinek.model.DTO.PathToVerify;
import com.example.cinek.model.DTO.Status;
import com.example.cinek.model.Wedrowka.Pamiatka;
import com.example.cinek.model.Wedrowka.TrasaSkladowa;
import com.example.cinek.model.trasa.PunktTrasy;
import com.example.cinek.model.trasa.SkladowyPunktTrasy;
import com.example.cinek.model.trasa.TrasaNiepunktowana;
import com.example.cinek.model.uzytkownik.Turysta;
import com.example.cinek.repos.VerificationRepository;
import com.example.cinek.services.interfaces.WalkVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class WalkVerificationServiceImpl implements WalkVerificationService
{
    @Autowired
    private VerificationRepository verificationRepository;

    @Override
    public PathToVerify getPathToVerify(Long verId)
    {
        List<TrasaSkladowa> waitingTracks =
                verificationRepository.getWaitingTracksWithPermissionsTo(verId);

        if(waitingTracks.size() == 0)
        {
            return null;
        }
        TrasaSkladowa ct = waitingTracks.get(0);
        Turysta t = ct.getWedrowka().getTurysta();
        List<SkladowyPunktTrasy> cpps = ct.getTrasa().getSkladowePunktyTrasy();
        List<Pair<String, String>> cppNamesAndCords = new ArrayList<>(cpps.size());

        cpps.sort(Comparator.comparingInt(SkladowyPunktTrasy::getKolejnoscPunktu));
        for(SkladowyPunktTrasy cpp : cpps)
        {
            PunktTrasy tp = cpp.getPunktTrasy();
            String name = tp.getNazwaPunktu();
            String cords = calculateCordinates(tp.getWysokoscGeograficzna(),
                    tp.getSzerokoscGeograficzna());

            cppNamesAndCords.add(new Pair<>(name, cords));
        }

        List<byte[]> pics = new ArrayList<>();
        for(Pamiatka s : ct.getPamiatki())
        {
            if(s.getCzyDokumentujaca())
            {
                pics.add(s.getZdjecie());
            }
        }
        PathToVerify pathToVerify = new PathToVerify(ct.getId(), t.getId(), t.getImie(), t.getNazwisko(),
                ct.getWedrowka().getDataWedrowki(), cppNamesAndCords, pics,
                ct.getTrasa().getPunktyRegulaminowe(), ct.getTrasa() instanceof TrasaNiepunktowana);

        return pathToVerify;
    }

    private String calculateCordinates(Float longitude, Float latitude)
    {
        return "21 N 37 E";
    }

    @Override
    public void setStatus(Long trackId, Status status, Long leaderId, Integer points)
    {
        StatusToIntConverter converter = new StatusToIntConverter();
        Integer statusInt = converter.convertToDatabaseColumn(status);
        verificationRepository.changeStatusForCompoundTrack(trackId, statusInt, leaderId, points);
    }
}
