package pl.corp.kkf.services.dictionaries.model;

import jakarta.persistence.*;
import pl.corp.kkf.commons.base.model.BaseEntity;

import java.util.Objects;

@Entity
@Table(name = "SERVICE_TYPES", schema = "DICTIONARIES")
public class ServiceTypeEntity extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceServiceTypeEntity")
    @SequenceGenerator(name = "SequenceServiceTypeEntity", schema = "DICTIONARIES", sequenceName = "SEQ_SERVICE_TYPES")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ARCHIVAL")
    private Boolean archival;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getArchival() {
        return archival;
    }

    public void setArchival(Boolean archival) {
        this.archival = archival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceTypeEntity that = (ServiceTypeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(archival, that.archival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, archival);
    }
}