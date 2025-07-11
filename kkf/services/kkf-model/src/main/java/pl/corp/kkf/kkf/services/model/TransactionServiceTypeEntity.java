package pl.corp.kkf.kkf.services.model;

import jakarta.persistence.*;
import pl.corp.kkf.commons.base.model.BaseEntity;

import java.util.Objects;

@Entity
@Table(name = "TRANSACTION_SERVICE_TYPES", schema = "KKF")
public class TransactionServiceTypeEntity extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceTransactionServiceTypeEntity")
    @SequenceGenerator(name = "SequenceTransactionServiceTypeEntity", schema = "KKF", sequenceName = "SEQ_TRANSACTION_SERVICE_TYPES")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ARCHIVAL")
    private boolean archival;

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

    public boolean isArchival() {
        return archival;
    }

    public void setArchival(boolean archival) {
        this.archival = archival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionServiceTypeEntity that = (TransactionServiceTypeEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(description, that.description)
                && Objects.equals(archival, that.archival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, archival);
    }
}