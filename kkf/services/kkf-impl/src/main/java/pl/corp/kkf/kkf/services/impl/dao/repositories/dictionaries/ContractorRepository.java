package pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.corp.kkf.kkf.services.model.dictionaries.ContractorEntity;

public interface ContractorRepository extends JpaRepository<ContractorEntity, Long>,
        JpaSpecificationExecutor<ContractorEntity> {


}
