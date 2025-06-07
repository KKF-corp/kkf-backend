package pl.corp.kkf.services.dictionaries.impl.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.corp.kkf.services.dictionaries.model.ContractorEntity;

public interface ContractorRepository extends JpaRepository<ContractorEntity, Long>,
        JpaSpecificationExecutor<ContractorEntity> {


}
