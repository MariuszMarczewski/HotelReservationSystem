package pl.mmarczewski.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Guest {

    @Id
    @GeneratedValue(generator = "guestSeq")
    @SequenceGenerator(name = "guestSeq", sequenceName = "guest_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String secondName;
    private String address;
    private LocalDate birthDate;
    private String phoneNumber;

    public Guest() {
    }

    public Guest(String firstName, String secondName, String address, LocalDate birthDate, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(id, guest.id) &&
                Objects.equals(firstName, guest.firstName) &&
                Objects.equals(secondName, guest.secondName) &&
                Objects.equals(address, guest.address) &&
                Objects.equals(birthDate, guest.birthDate) &&
                Objects.equals(phoneNumber, guest.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, address, birthDate, phoneNumber);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

