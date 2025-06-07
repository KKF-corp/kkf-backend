package pl.corp.kkf.kkf.services.impl.service.dictionaries.addresses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto.Address;
import pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto.AddressSearchRequest;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.AddressConverter;
import pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries.AddressRepository;
import pl.corp.kkf.kkf.services.model.dictionaries.AddressEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address getAddress(long id) {
        AddressEntity addressEntity = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
        return AddressConverter.toDto(addressEntity);
    }

    @Override
    public Address createAddress(Address address) {
        AddressEntity addressEntity = AddressConverter.toEntity(address);
        AddressEntity savedAddressEntity = addressRepository.save(addressEntity);
        return AddressConverter.toDto(savedAddressEntity);
    }

    @Override
    public Address updateAddress(Address address) {
        AddressEntity addressEntity = AddressConverter.toEntity(address);
        AddressEntity updatedAddressEntity = addressRepository.save(addressEntity);
        return AddressConverter.toDto(updatedAddressEntity);
    }

    @Override
    public void archiveAddress(long id) {
        AddressEntity addressEntity = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
        addressEntity.setArchival(true);
        addressRepository.save(addressEntity);
    }

    @Override
    public void unarchiveAddress(long id) {
        AddressEntity addressEntity = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
        addressEntity.setArchival(false);
        addressRepository.save(addressEntity);
    }

    @Override
    public List<Address> getAllAddresses() {
        List<AddressEntity> addressEntities = addressRepository.findAll();
        return addressEntities.stream()
                .map(AddressConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PageDTO<Address> findByCriteria(AddressSearchRequest request) {
        // TODO: Implementacja wyszukiwania po kryteriach i paginacji
        throw new UnsupportedOperationException("Wyszukiwanie po kryteriach niezaimplementowane");
    }
}