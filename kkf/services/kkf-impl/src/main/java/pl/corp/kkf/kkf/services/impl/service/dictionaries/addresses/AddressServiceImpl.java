package pl.corp.kkf.kkf.services.impl.service.dictionaries.addresses;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.base.service.rest.PageUtils;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto.Address;
import pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto.AddressSearchRequest;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.AddressConverter;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.AddressException;
import pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries.AddressRepository;
import pl.corp.kkf.kkf.services.impl.dao.validators.dictionaries.AddressValidator;
import pl.corp.kkf.kkf.services.model.dictionaries.AddressEntity;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.AddressConverter.toDto;
import static pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.AddressConverter.toEntity;

@Service
public class AddressServiceImpl implements AddressService {

    public static final Supplier<@NotNull AddressException> ADDRESS_NOT_FOUND_EXCEPTION_SUPPLIER = () -> new AddressException("Nie znaleziono adresu kontrahenta o podanym identyfikatorze");

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address getAddress(long id) {
        AddressEntity addressEntity = addressRepository.findById(id)
                .orElseThrow(ADDRESS_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(addressEntity);
    }

    @Override
    public Address createAddress(Address address) {
        AddressValidator.validateForCreation(address);
        AddressEntity entity = toEntity(new AddressEntity(), address);
        return toDto(addressRepository.save(entity));
    }

    @Override
    public Address updateAddress(Address address) {
        AddressValidator.validateForUpdate(address);
        AddressEntity entity = addressRepository.findById(address.getId())
                .orElseThrow(ADDRESS_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(addressRepository.save(toEntity(entity, address)));
    }

    @Override
    public void archiveAddress(long id) {
        AddressEntity entity = addressRepository.findById(id)
                .orElseThrow(ADDRESS_NOT_FOUND_EXCEPTION_SUPPLIER);
        addressRepository.save(entity);
    }

    @Override
    public void unarchiveAddress(long id) {
        AddressEntity entity = addressRepository.findById(id)
                .orElseThrow(ADDRESS_NOT_FOUND_EXCEPTION_SUPPLIER);
        addressRepository.save(entity);
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
        Pageable pageable = PageUtils.convertTo(request.getPageRequestDTO());
        Specification<AddressEntity> specification = addressRepository.getSpecification(request.getCriteria());
        Page<AddressEntity> entities = addressRepository.findAll(specification, pageable);
        return PageUtils.convertTo(entities.map(AddressConverter::toDto));
    }
}