package pl.corp.kkf.kkf.services.impl.dao.repositories;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto.AddressCriteria;
import pl.corp.kkf.kkf.services.model.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long>,
        JpaSpecificationExecutor<AddressEntity> {

   default Specification<AddressEntity> getSpecification(@NotNull AddressCriteria criteria) {
        return null;
    }
}