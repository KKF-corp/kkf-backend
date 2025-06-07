package pl.corp.kkf.services.dictionaries.impl.service.addresses;

import pl.corp.kkf.services.dictionaries.api.addresses.dto.Address;
import pl.corp.kkf.services.dictionaries.api.addresses.dto.AddressCriteria;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.commons.rest.types.api.pages.PageRequestDTO;

import java.util.List;

public interface AddressService {

    Address getAddress(Long id);

    Address createAddress(Address address);

    Address updateAddress(Address address);

    void archiveAddress(Long id);

    void unarchiveAddress(Long id);

    List<Address> getAllAddresses();

    PageDTO<Address> findByCriteria(AddressCriteria criteria, PageRequestDTO pageRequestDTO);
}