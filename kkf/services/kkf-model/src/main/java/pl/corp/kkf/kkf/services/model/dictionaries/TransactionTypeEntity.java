package pl.corp.kkf.kkf.services.model.dictionaries;

import jakarta.persistence.*;
import pl.corp.kkf.commons.base.model.BaseEntity;

import java.util.Objects;

@Entity
@Table(name = "TRANSACTION_TYPES", schema = "KKF")
public class TransactionTypeEntity extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceTransactionTypeEntity")
    @SequenceGenerator(name = "SequenceTransactionTypeEntity", schema = "KKF", sequenceName = "SEQ_TRANSACTION_TYPES")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "TYPE", nullable = false)
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getArchival() {
        return archival;
    }

    public void setArchival(boolean archival) {
        this.archival = archival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionTypeEntity that = (TransactionTypeEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(type, that.type)
                && Objects.equals(archival, that.archival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, archival);
    }
}