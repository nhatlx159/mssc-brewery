package guru.springframework.msscbrewery.web.controller.v2;
import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDtoV2> postBeer(@RequestBody BeerDtoV2 beer){
        BeerDtoV2 savedBeer = beerServiceV2.savedNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "http://localhost:8080/api/v2/beer/" + savedBeer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("{beerId}")
    public ResponseEntity<BeerDtoV2> putBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beer) {
        beerServiceV2.updateBeer(beerId, beer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID id){
        beerServiceV2.deleteBeerById(id);
    }
}
