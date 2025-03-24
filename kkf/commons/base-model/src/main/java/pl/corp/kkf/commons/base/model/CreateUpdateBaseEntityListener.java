package pl.corp.kkf.commons.base.model;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class CreateUpdateBaseEntityListener {

    public static final String USER_NAME_PROPERTY = "DEFAULT_USER_NAME";

    @PrePersist
    public void onUpdateEntity(BaseEntity entity) {
        LocalDateTime now = LocalDateTime.now();
        entity.setRowCreationDate(now);
        entity.setRowCreationUser(USER_NAME_PROPERTY);
        entity.setRowModificationDate(now);
        entity.setRowModificationUser(USER_NAME_PROPERTY);

    }

    @PreUpdate
    public void onCreateEntity(BaseEntity entity) {
        entity.setRowModificationDate(LocalDateTime.now());
        entity.setRowModificationUser(USER_NAME_PROPERTY);
    }

//TODO:    MDC.get(USER_NAME_PROPERTY)
}
