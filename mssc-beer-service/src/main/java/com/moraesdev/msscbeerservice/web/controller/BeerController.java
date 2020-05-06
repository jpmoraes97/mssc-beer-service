package com.moraesdev.msscbeerservice.web.controller;

import com.moraesdev.msscbeerservice.services.BeerService;
import com.moraesdev.msscbeerservice.web.model.BeerDto;
import com.moraesdev.msscbeerservice.web.model.BeerPagedList;
import com.moraesdev.msscbeerservice.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

// com o uso de @RequiredArgsConstructor nao precisamos de @Autowired para injetar o BeerService
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 20;

    private final BeerService beerService;

    @GetMapping
    public ResponseEntity<BeerPagedList> listBeers(@RequestParam(value = "page", required = false) Integer page,
                                                   @RequestParam(value = "size", required = false) Integer size,
                                                   @RequestParam(value = "beerName", required = false) String beerName,
                                                   @RequestParam(value = "beerStyle", required = false)BeerStyleEnum beerStyle,
                                                   @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand) {
        if (showInventoryOnHand == null) {
            showInventoryOnHand = false;
        }
        if (page == null || page < 0) {
            page = DEFAULT_PAGE_NUMBER;
        }
        if (size == null || size < 1) {
            size = DEFAULT_PAGE_SIZE;
        }

        BeerPagedList beerList = beerService
                .listBeers(beerName, beerStyle, PageRequest.of(page, size), showInventoryOnHand);

        return new ResponseEntity<>(beerList, HttpStatus.OK);

    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId,
                                               @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand) {
        if (showInventoryOnHand == null) {
            showInventoryOnHand = false;
        }
        return new ResponseEntity<>(beerService.getById(beerId, showInventoryOnHand), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable UUID beerId, @Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.updateBeer(beerId, beerDto), HttpStatus.NO_CONTENT);
    }
}