package pl.mmarczewski.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Room {

    @Id
    @GeneratedValue(generator = "roomSeq")
    @SequenceGenerator(name = "roomSeq", sequenceName = "room_seq", allocationSize = 1)
    private Long id;
    private int roomType;
    private BigDecimal price;

    @Transient
    private BigDecimal price_eur;

    public Room() {
    }

    public Room(Long id, int roomType, BigDecimal pricePLN) {
        this.id = id;
        this.roomType = roomType;
        this.price = pricePLN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal pricePLN) {
        this.price = pricePLN;
    }

    public BigDecimal getPrice_eur() {
        return price_eur;
    }

    public void setPrice_eur(BigDecimal price_eur) {
        this.price_eur = price_eur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomType == room.roomType &&
                Objects.equals(id, room.id) &&
                Objects.equals(price, room.price) &&
                Objects.equals(price_eur, room.price_eur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomType, price, price_eur);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomType=" + roomType +
                ", price=" + price +
                ", price_eur=" + price_eur +
                '}';
    }
}
