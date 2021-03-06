package com.moraesdev.msscbeerservice.bootstrap;

import com.moraesdev.msscbeerservice.domain.Beer;
import com.moraesdev.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;

//@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0005957498620";
    public static final String BEER_2_UPC = "0005957498644";
    public static final String BEER_3_UPC = "0005957498685";

    public static final String BEER_1_UUID  = "a712d914-61ea-4623-8bd0-32c0f6545bfd";


    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {

            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal("12.90"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("12.90"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("No Hammers On The Bar")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("12.90"))
                    .build());
        }
    }
}
