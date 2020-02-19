package pl.mmarczewski.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.mmarczewski.model.Guest;
import pl.mmarczewski.model.Reservation;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository sut;

@Test
public void shouldReturnReservationSetByGuestName(){
    //when
    Set<Reservation> actual = sut.findReservationByGuestSecondName("welcomed1");

    //then
assertThat(actual)
        .extracting(Reservation::getId)
        .containsExactly(1L);

}


}
