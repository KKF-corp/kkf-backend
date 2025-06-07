package pl.corp.kkf.services.dictionaries.impl.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.corp.kkf.services.dictionaries.model.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
