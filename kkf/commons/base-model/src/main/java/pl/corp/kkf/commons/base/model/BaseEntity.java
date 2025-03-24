package pl.corp.kkf.commons.base.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(CreateUpdateBaseEntityListener.class)
public class BaseEntity {

    @Version
    @Column(name = "ROW_VERSION")
    private Long rowVersion;

    @Column(name = "ROW_CREATION_DATE")
    private LocalDateTime rowCreationDate;

    @Column(name = "ROW_CREATION_USER")
    private String rowCreationUser;

    @Column(name = "ROW_MODIFICATION_DATE")
    private LocalDateTime rowModificationDate;

    @Column(name = "ROW_MODIFICATION_USER")
    private String rowModificationUser;

    public Long getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(Long rowVersion) {
        this.rowVersion = rowVersion;
    }

    public LocalDateTime getRowCreationDate() {
        return rowCreationDate;
    }

    public void setRowCreationDate(LocalDateTime rowCreationDate) {
        this.rowCreationDate = rowCreationDate;
    }

    public String getRowCreationUser() {
        return rowCreationUser;
    }

    public void setRowCreationUser(String rowCreationUser) {
        this.rowCreationUser = rowCreationUser;
    }

    public LocalDateTime getRowModificationDate() {
        return rowModificationDate;
    }

    public void setRowModificationDate(LocalDateTime rowModificationDate) {
        this.rowModificationDate = rowModificationDate;
    }

    public String getRowModificationUser() {
        return rowModificationUser;
    }

    public void setRowModificationUser(String rowModificationUser) {
        this.rowModificationUser = rowModificationUser;
    }
}
