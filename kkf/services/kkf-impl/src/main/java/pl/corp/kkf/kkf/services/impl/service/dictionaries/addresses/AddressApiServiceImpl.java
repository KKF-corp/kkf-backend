package pl.corp.kkf.kkf.services.impl.service.dictionaries.addresses;

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

    @Override
    public AddressResponse getAddress(long id) {
        Address address = addressService.getAddress(id);
        AddressResponse response = new AddressResponse();
        response.setAddress(address);
        return response;
    }

    @Override
    public AddressResponse createAddress(Address address) {
        Address createdAddress = addressService.createAddress(address);
        AddressResponse response = new AddressResponse();
        response.setAddress(createdAddress);
        return response;
    }

    @Override
    public AddressResponse updateAddress(Address address) {
        Address updatedAddress = addressService.updateAddress(address);
        AddressResponse response = new AddressResponse();
        response.setAddress(updatedAddress);
        return response;
    }

    @Override
    public GeneralResponse archiveAddress(long id) {
        addressService.archiveAddress(id);
        return new GeneralResponse();
    }

    @Override
    public GeneralResponse unarchiveAddress(long id) {
        addressService.unarchiveAddress(id);
        return new GeneralResponse();
    }

    @Override
    public AddressListResponse getAllAddresses() {
        AddressListResponse response = new AddressListResponse();
        response.setAddress(addressService.getAllAddresses());
        return response;
    }

    @Override
    public AddressSearchResponse findByCriteria(AddressSearchRequest request) {
        addressService.findByCriteria(request);
        throw new UnsupportedOperationException("Wyszukiwanie po kryteriach niezaimplementowane");
    }
}