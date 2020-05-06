package com.moraesdev.msscbeerservice.services;

import com.moraesdev.msscbeerservice.web.model.BeerDto;
import com.moraesdev.msscbeerservice.web.model.BeerPagedList;
import com.moraesdev.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);

    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
