package guru.springframework.msscbrewery.services.v2;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    void deleteBeerById(UUID id);

    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 savedNewBeer(BeerDtoV2 beer);

    void updateBeer(UUID beerId, BeerDtoV2 beer);
}
