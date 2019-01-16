package com.example.cinek.controllers;

import com.example.cinek.model.DTO.PathToVerify;
import com.example.cinek.model.DTO.Status;
import com.example.cinek.model.uzytkownik.Przodownik;
import com.example.cinek.services.interfaces.WalkVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weryfikacja")
public class VerificationController
{
    @Autowired
    WalkVerificationService walkVerificationService;

    @GetMapping("/znajdz_trase/{id}")
    @CrossOrigin
    public PathToVerify getTrasaToVerification(@PathVariable("id") Long leaderId)
    {
        return walkVerificationService.getPathToVerify(leaderId);
    }

    @GetMapping("/ustaw_status/{id}/{status}/{leaderId}/{points}")
    @CrossOrigin
    public void setStatus(@PathVariable("id") long id, @PathVariable("status") String status,
                          @PathVariable("leaderId") Long przodownikId, @PathVariable("points") Integer points)
    {
        Status stat = Enum.valueOf(Status.class, status);
        walkVerificationService.setStatus(id, stat, przodownikId, points);
    }
}
