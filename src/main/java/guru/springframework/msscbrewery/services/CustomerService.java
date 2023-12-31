package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID id);

    CustomerDto addNewCustomer(CustomerDto customer);
    void changeCustomerInfo(UUID id, CustomerDto customer);

    void deleteCustomer(UUID id);
}
