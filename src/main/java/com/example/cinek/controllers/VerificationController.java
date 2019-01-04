package com.example.cinek.controllers;

import com.example.cinek.model.DTO.PathToVerify;
import com.example.cinek.model.trasa.Status;
import com.example.cinek.model.uzytkownik.Przodownik;
import com.example.cinek.services.WalkVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weryfikacja")
public class VerificationController
{
    @Autowired
    WalkVerificationService walkVerificationService;

    @GetMapping("/znajdz_trase")
    @CrossOrigin
    public PathToVerify getTrasaToVerification(@RequestBody Przodownik przodownik)
    {
        return walkVerificationService.getPathToVerify(przodownik);
    }

    @GetMapping("/ustaw_status/{id}/{status}/{przodownikId}/{points}")
    @CrossOrigin
    public Integer setStatus(@PathVariable("id") long id, @PathVariable("status") String status,
                          @PathVariable("przodownikId") Long przodownikId, @PathVariable("points") Integer points)
    {
        Status stat = Enum.valueOf(Status.class, status);
        walkVerificationService.setStatus(id, stat, przodownikId, points);
        return 666;
    }
}
