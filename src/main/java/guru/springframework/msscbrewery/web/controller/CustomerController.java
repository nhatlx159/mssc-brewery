package guru.springframework.msscbrewery.web.controller;

import com.sun.net.httpserver.Headers;
import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@Controller
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id")UUID id){
        return new ResponseEntity<CustomerDto>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> postCustomer(@RequestBody CustomerDto customer){
        CustomerDto savedCustomer = customerService.addNewCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","http://localhost:8080/api/v1/customer/" + savedCustomer.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> putCustomer(@PathVariable("customerId") UUID id ,@RequestBody CustomerDto customer){
        customerService.changeCustomerInfo(id, customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID id){
        customerService.deleteCustomer(id);
    }
}
