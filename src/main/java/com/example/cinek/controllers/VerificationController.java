package com.example.cinek.controllers;

import com.example.cinek.model.Wedrowka.TrasaSkladowa;
import com.example.cinek.model.trasa.Status;
import com.example.cinek.model.uzytkownik.Przodownik;
import com.example.cinek.services.WalkVerificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weryfikacja")
public class VerificationController
{
    @Autowired
    WalkVerificationServiceImpl walkVerificationService;

    @GetMapping("/znajdztrase")
    @CrossOrigin
    public TrasaSkladowa getTrasaToVerification(@RequestBody Przodownik przodownik)
    {
        return walkVerificationService.getTrasaToVerification(przodownik);
    }

    @GetMapping("/ustaw_status/{id}/{status}")
    @CrossOrigin
    public void setStatus(@PathVariable("id") long id, @PathVariable("status") String status)
    {
        Status stat = Enum.valueOf(Status.class, status);
        walkVerificationService.setStatus(id, stat);
    }
}
