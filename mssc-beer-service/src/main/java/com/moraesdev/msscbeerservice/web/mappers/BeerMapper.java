package com.moraesdev.msscbeerservice.web.mappers;

import com.moraesdev.msscbeerservice.domain.Beer;
import com.moraesdev.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    Beer beetDtoToBeer(BeerDto beerDto);

    BeerDto beerToBeerDto(Beer beer);

}
