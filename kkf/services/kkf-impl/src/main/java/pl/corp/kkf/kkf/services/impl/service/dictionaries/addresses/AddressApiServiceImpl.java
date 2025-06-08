package pl.corp.kkf.kkf.services.impl.service.dictionaries.addresses;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.addresses.AddressApiService;
import pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto.*;

@Service
public class AddressApiServiceImpl implements AddressApiService {

    private final AddressService addressService;

    @Autowired
    public AddressApiServiceImpl(AddressService addressService) {
        this.addressService = addressService;
    }

    @DenyAll
    @Override
    public AddressResponse getAddress(long id) {
        Address address = addressService.getAddress(id);
        AddressResponse response = new AddressResponse();
        response.setAddress(address);
        return response;
    }

    @DenyAll
    @Override
    public AddressResponse createAddress(Address address) {
        Address createdAddress = addressService.createAddress(address);
        AddressResponse response = new AddressResponse();
        response.setAddress(createdAddress);
        return response;
    }

    @DenyAll
    @Override
    public AddressResponse updateAddress(Address address) {
        Address updatedAddress = addressService.updateAddress(address);
        AddressResponse response = new AddressResponse();
        response.setAddress(updatedAddress);
        return response;
    }

    @DenyAll
    @Override
    public GeneralResponse archiveAddress(long id) {
        addressService.archiveAddress(id);
        return new GeneralResponse();
    }

    @DenyAll
    @Override
    public GeneralResponse unarchiveAddress(long id) {
        addressService.unarchiveAddress(id);
        return new GeneralResponse();
    }

    @DenyAll
    @Override
    public AddressListResponse getAllAddresses() {
        AddressListResponse response = new AddressListResponse();
        response.setAddress(addressService.getAllAddresses());
        return response;
    }

    @DenyAll
    @Override
    public AddressSearchResponse findByCriteria(AddressSearchRequest request) {
        addressService.findByCriteria(request);
        throw new UnsupportedOperationException("Wyszukiwanie po kryteriach niezaimplementowane");
    }
}