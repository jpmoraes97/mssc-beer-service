package com.moraesdev.msscbeerservice.web.controller;

import com.moraesdev.msscbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId){
        //TODO: IMPL
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@Valid @RequestBody BeerDto beerDto){
        //TODO: IMPL
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public  ResponseEntity updateBeer(@PathVariable UUID beerId, @Valid @RequestBody BeerDto beerDto){
        //TODO: IMPL
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}