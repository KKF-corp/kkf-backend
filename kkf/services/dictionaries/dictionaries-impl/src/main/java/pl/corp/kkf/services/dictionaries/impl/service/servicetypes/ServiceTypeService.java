package pl.corp.kkf.services.dictionaries.impl.service.servicetypes;

import pl.corp.kkf.services.dictionaries.api.servicetypes.dto.ServiceType;

import java.util.List;

public interface ServiceTypeService {

    ServiceType getServiceType(Long id);

    ServiceType createServiceType(ServiceType serviceType);

    ServiceType updateServiceType(ServiceType serviceType);

    void archiveServiceType(Long id);

    void unarchiveServiceType(Long id);

    List<ServiceType> getAllServiceTypes();
}