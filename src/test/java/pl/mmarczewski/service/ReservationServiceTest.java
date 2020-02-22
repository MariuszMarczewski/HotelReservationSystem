package pl.mmarczewski.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.mmarczewski.model.Reservation;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ReservationServiceTest {

    @Autowired
    private ReservationService sut;

    @Test
    @Transactional
    public void shouldAddReservation(){
        //given
        Reservation reservation = new Reservation(LocalDate.parse("2020-01-29"), LocalDate.parse("2020-02-20"), null, null, null);

        //when
        Long actual = sut.addReservation(reservation);

        //then
        assertThat(actual).isEqualTo(5L);
    }

    @Test
    @Transactional
    public void shouldDeleteReservation(){
        //given
        Reservation reservation = new Reservation(LocalDate.parse("2020-01-29"), LocalDate.parse("2020-02-20"), null, null, null);

        //when
        Long idToDelete = sut.addReservation(reservation);
        sut.deleteReservation(idToDelete);

        //then
        assertThat(sut.getReservationByReservationId(5L)).isNull();
    }

    @Test
    @Transactional
    public void shouldReturnReservationById(){
        //given
        Reservation reservation = new Reservation(LocalDate.parse("2020-01-29"), LocalDate.parse("2020-02-20"), null, null, null);

        //when
        Long idToAdd = sut.addReservation(reservation);
        Reservation actual = sut.getReservationByReservationId(5L);

        //then
        assertThat(actual).isEqualTo(reservation);
    }

    @Test
    @Transactional
    public void shouldReturnReservationByGuestSecondName(){
        //when
        Set<Reservation> actual = sut.getReservationByGuestSecondName("welcomed1");

        //then
        assertThat(actual)
                .extracting(Reservation::getId)
                .containsExactly(1L);
    }

    @Test
    @Transactional
    public void shouldUpdateReservation(){
        //given
        Reservation reservationToUpdate = new Reservation(LocalDate.parse("2020-01-29"), LocalDate.parse("2020-02-20"), null, null, null);
        Long id = sut.addReservation(reservationToUpdate);
        Reservation reservation = new Reservation(id, LocalDate.parse("2020-02-12"), LocalDate.parse("2020-02-22"), null, null, null);

        //when
        Reservation actual = sut.updateReservation(reservation);

        //then
        assertThat(actual).isEqualTo(reservation);
    }

}
