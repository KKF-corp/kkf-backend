package pl.corp.kkf.kkf.services.model.dictionaries;

import jakarta.persistence.*;
import pl.corp.kkf.commons.base.model.BaseEntity;

import java.util.Objects;

@Entity
@Table(name = "ADDRESSES", schema = "KKF")
public class AddressEntity extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceAddressEntity")
    @SequenceGenerator(name = "SequenceAddressEntity", schema = "KKF", sequenceName = "SEQ_ADDRESSES")
    private Long id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "POSTCODE")
    private String postcode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(street, that.street)
                && Objects.equals(postcode, that.postcode)
                && Objects.equals(city, that.city)
                && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, postcode, city, country);
    }
}
