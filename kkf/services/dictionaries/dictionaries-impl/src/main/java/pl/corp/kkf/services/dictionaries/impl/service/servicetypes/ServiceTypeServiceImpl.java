package pl.corp.kkf.services.dictionaries.impl.service.servicetypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.services.dictionaries.api.servicetypes.dto.ServiceType;
import pl.corp.kkf.services.dictionaries.impl.dao.converters.ServiceTypeConverter;
import pl.corp.kkf.services.dictionaries.impl.dao.repositories.ServiceTypeRepository;
import pl.corp.kkf.services.dictionaries.model.ServiceTypeEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    private final ServiceTypeRepository serviceTypeRepository;

    @Autowired
    public ServiceTypeServiceImpl(ServiceTypeRepository serviceTypeRepository) {
        this.serviceTypeRepository = serviceTypeRepository;
    }

    @Override
    public ServiceType getServiceType(Long id) {
        ServiceTypeEntity serviceTypeEntity = serviceTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceType not found with id: " + id));
        return ServiceTypeConverter.toDto(serviceTypeEntity);
    }

    @Override
    public ServiceType createServiceType(ServiceType serviceType) {
        ServiceTypeEntity serviceTypeEntity = ServiceTypeConverter.toEntity(serviceType);
        ServiceTypeEntity savedServiceTypeEntity = serviceTypeRepository.save(serviceTypeEntity);
        return ServiceTypeConverter.toDto(savedServiceTypeEntity);
    }

    @Override
    public ServiceType updateServiceType(ServiceType serviceType) {
        ServiceTypeEntity serviceTypeEntity = ServiceTypeConverter.toEntity(serviceType);
        ServiceTypeEntity updatedServiceTypeEntity = serviceTypeRepository.save(serviceTypeEntity);
        return ServiceTypeConverter.toDto(updatedServiceTypeEntity);
    }

    @Override
    public void archiveServiceType(Long id) {
        ServiceTypeEntity serviceTypeEntity = serviceTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceType not found with id: " + id));
        serviceTypeEntity.setArchival(true);
        serviceTypeRepository.save(serviceTypeEntity);
    }

    @Override
    public void unarchiveServiceType(Long id) {
        ServiceTypeEntity serviceTypeEntity = serviceTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceType not found with id: " + id));
        serviceTypeEntity.setArchival(false);
        serviceTypeRepository.save(serviceTypeEntity);
    }

    @Override
    public List<ServiceType> getAllServiceTypes() {
        List<ServiceTypeEntity> serviceTypeEntities = serviceTypeRepository.findAll();
        return serviceTypeEntities.stream()
                .map(ServiceTypeConverter::toDto)
                .collect(Collectors.toList());
    }
}