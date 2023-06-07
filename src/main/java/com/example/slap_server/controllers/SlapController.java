package com.example.slap_server.controllers;

import com.example.slap_server.models.Slap;
import com.example.slap_server.repositories.SlapRepository;
import com.example.slap_server.services.SlapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/slaps")
public class SlapController {

    @Autowired
    SlapService slapService;

    @Autowired
    SlapRepository slapRepository;

    @GetMapping
    public ResponseEntity<List<Slap>> getAllSlaps(){
        return new ResponseEntity<>(slapService.findAllSlaps(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Slap> getSlapById(@PathVariable Long id){
        return new ResponseEntity<>(slapService.findSlapById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<List<Slap>> getSlapByUser(@PathVariable Long userId){
        return new ResponseEntity<>(slapService.findSlapByUser(userId), HttpStatus.OK);
    }

}
