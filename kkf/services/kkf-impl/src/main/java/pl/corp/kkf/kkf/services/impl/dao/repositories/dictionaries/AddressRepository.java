package pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.corp.kkf.kkf.services.model.dictionaries.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
