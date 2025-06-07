package pl.corp.kkf.services.dictionaries.model;

import jakarta.persistence.*;
import pl.corp.kkf.commons.base.model.BaseEntity;

import java.util.Objects;

@Entity
@Table(name = "ADDRESSES", schema = "DICTIONARIES")
public class AddressEntity extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceAddressEntity")
    @SequenceGenerator(name = "SequenceAddressEntity", schema = "DICTIONARIES", sequenceName = "SEQ_ADDRESSES")
    private Long id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "POSTCODE")
    private String postcode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "ARCHIVAL")
    private Boolean archival;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(street, that.street) && Objects.equals(postcode, that.postcode) && Objects.equals(city, that.city) && Objects.equals(country, that.country) && Objects.equals(archival, that.archival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, postcode, city, country, archival);
    }
}
