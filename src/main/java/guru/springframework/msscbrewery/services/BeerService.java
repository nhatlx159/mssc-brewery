package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
public interface BeerService {
    void deleteBeerById(UUID id);

    BeerDto getBeerById(UUID beerId);

    BeerDto savedNewBeer(BeerDto beer);

    void updateBeer(UUID beerId, BeerDto beer);
}
