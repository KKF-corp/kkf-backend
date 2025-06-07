package pl.corp.kkf.services.dictionaries.impl.service.servicetypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.services.dictionaries.api.servicetypes.ServiceTypeApiService;
import pl.corp.kkf.services.dictionaries.api.servicetypes.dto.ServiceType;
import pl.corp.kkf.services.dictionaries.impl.dao.converters.ServiceTypeConverter;
import pl.corp.kkf.services.dictionaries.impl.dao.repositories.ServiceTypeRepository;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceTypeApiServiceImpl implements ServiceTypeApiService {

    private final ServiceTypeService serviceTypeService;

    @Autowired
    public ServiceTypeApiServiceImpl(ServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }

    @Override
    public ServiceType getServiceType(Long id) {
        return serviceTypeService.getServiceType(id);
    }

    @Override
    public ServiceType createServiceType(ServiceType serviceType) {
        return serviceTypeService.createServiceType(serviceType);
    }

    @Override
    public ServiceType updateServiceType(ServiceType serviceType) {
        return serviceTypeService.updateServiceType(serviceType);
    }

    @Override
    public GeneralResponse archiveServiceType(Long id) {
        serviceTypeService.archiveServiceType(id);
        return new GeneralResponse();
    }

    @Override
    public GeneralResponse unarchiveServiceType(Long id) {
        serviceTypeService.unarchiveServiceType(id);
        return new GeneralResponse();
    }

    @Override
    public List<ServiceType> getAllServiceTypes() {
        return serviceTypeService.getAllServiceTypes();
    }
}