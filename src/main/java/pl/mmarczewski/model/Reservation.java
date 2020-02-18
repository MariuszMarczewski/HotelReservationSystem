package pl.mmarczewski.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


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
    @ManyToOne(targetEntity = Easement.class)
    private Easement easement;

    public Reservation() {
    }

    public Reservation(LocalDate checkinDate, LocalDate checkoutDate, Guest guest, Room room, Easement easement) {
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.guest = guest;
        this.room = room;
        this.easement = easement;
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

    public Easement getEasement() {
        return easement;
    }

    public void setEasement(Easement easement) {
        this.easement = easement;
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
                Objects.equals(easement, that.easement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkinDate, checkoutDate, guest, room, easement);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", checkinDate=" + checkinDate +
                ", checkoutDate=" + checkoutDate +
                ", guest=" + guest +
                ", room=" + room +
                ", easement=" + easement +
                '}';
    }
}
