package pl.corp.kkf.services.dictionaries.impl.service.services;

import pl.corp.kkf.services.dictionaries.api.services.dto.Service;

import java.util.List;

public interface ServiceService {

    Service getService(Long id);

    Service createService(Service service);

    Service updateService(Service service);

    void archiveService(Long id);

    void unarchiveService(Long id);

    List<Service> getAllServices();
}