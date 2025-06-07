package pl.corp.kkf.services.billings.impl.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.services.billings.api.services.ServiceApiService;
import pl.corp.kkf.services.billings.api.services.dto.Service;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.services.billings.impl.dao.converters.ServiceConverter;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceApiServiceImpl implements ServiceApiService {

    private final ServiceService serviceService;

    @Autowired
    public ServiceApiServiceImpl(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @Override
    public Service getService(Long id) {
        return serviceService.getService(id);
    }

    @Override
    public Service createService(Service service) {
        return serviceService.createService(service);
    }

    @Override
    public Service updateService(Service service) {
        return serviceService.updateService(service);
    }

    @Override
    public GeneralResponse archiveService(Long id) {
        serviceService.archiveService(id);
        return new GeneralResponse();
    }

    @Override
    public GeneralResponse unarchiveService(Long id) {
        serviceService.unarchiveService(id);
        return new GeneralResponse();
    }

    @Override
    public List<Service> getAllServices() {
        return serviceService.getAllServices();
    }
}