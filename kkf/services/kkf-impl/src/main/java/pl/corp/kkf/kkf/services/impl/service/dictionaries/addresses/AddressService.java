package pl.corp.kkf.kkf.services.impl.service.dictionaries.addresses;

import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.commons.rest.types.api.pages.PageRequestDTO;
import pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto.Address;
import pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto.AddressCriteria;
import pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto.AddressSearchRequest;

import java.util.List;

public interface AddressService {

    Address getAddress(long id);

    Address createAddress(Address address);

    Address updateAddress(Address address);

    void archiveAddress(long id);

    void unarchiveAddress(long id);

    List<Address> getAllAddresses();

    PageDTO<Address> findByCriteria(AddressSearchRequest request);
}