package pl.corp.kkf.services.dictionaries.impl.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.services.dictionaries.api.services.dto.Service;
import pl.corp.kkf.services.dictionaries.impl.dao.converters.ServiceConverter;
import pl.corp.kkf.services.dictionaries.impl.dao.repositories.ServiceRepository;
import pl.corp.kkf.services.dictionaries.model.ServiceEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Service getService(Long id) {
        ServiceEntity serviceEntity = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with id: " + id));
        return ServiceConverter.toDto(serviceEntity);
    }

    @Override
    public Service createService(Service service) {
        ServiceEntity serviceEntity = ServiceConverter.toEntity(service);
        ServiceEntity savedServiceEntity = serviceRepository.save(serviceEntity);
        return ServiceConverter.toDto(savedServiceEntity);
    }

    @Override
    public Service updateService(Service service) {
        ServiceEntity serviceEntity = ServiceConverter.toEntity(service);
        ServiceEntity updatedServiceEntity = serviceRepository.save(serviceEntity);
        return ServiceConverter.toDto(updatedServiceEntity);
    }

    @Override
    public void archiveService(Long id) {
        ServiceEntity serviceEntity = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with id: " + id));
        serviceEntity.setArchival(true);
        serviceRepository.save(serviceEntity);
    }

    @Override
    public void unarchiveService(Long id) {
        ServiceEntity serviceEntity = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with id: " + id));
        serviceEntity.setArchival(false);
        serviceRepository.save(serviceEntity);
    }

    @Override
    public List<Service> getAllServices() {
        List<ServiceEntity> serviceEntities = serviceRepository.findAll();
        return serviceEntities.stream()
                .map(ServiceConverter::toDto)
                .collect(Collectors.toList());
    }
}