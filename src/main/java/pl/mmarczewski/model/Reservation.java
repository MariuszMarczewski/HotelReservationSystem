package pl.mmarczewski.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


@Entity
public class Reservation {

    @Id
    @GeneratedValue(generator = "reservationSeq")
    @SequenceGenerator(name = "reservationSeq", sequenceName = "reservation_seq", allocationSize = 1)
    private Long id;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    @ManyToOne(targetEntity = Guest.class)
    private Guest guest;
    @ManyToOne(targetEntity = Room.class)
    private Room room;
    @ManyToMany(targetEntity = Easement.class)
    private Set<Easement> easements;

    public Reservation() {
    }

    public Reservation(LocalDate checkinDate, LocalDate checkoutDate, Guest guest, Room room, Set<Easement> easements){
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.guest = guest;
        this.room = room;
        this.easements = easements;
    }

    public Reservation(Long id, LocalDate checkinDate, LocalDate checkoutDate, Guest guest, Room room, Set<Easement> easements){
        this.id = id;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.guest = guest;
        this.room = room;
        this.easements = easements;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Set<Easement> getEasements() {
        return easements;
    }

    public void setEasements(Set<Easement> easements) {
        this.easements = easements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(checkinDate, that.checkinDate) &&
                Objects.equals(checkoutDate, that.checkoutDate) &&
                Objects.equals(guest, that.guest) &&
                Objects.equals(room, that.room) &&
                Objects.equals(easements, that.easements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkinDate, checkoutDate, guest, room, easements);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", checkinDate=" + checkinDate +
                ", checkoutDate=" + checkoutDate +
                ", guest=" + guest +
                ", room=" + room +
                ", easements=" + easements +
                '}';
    }
}
