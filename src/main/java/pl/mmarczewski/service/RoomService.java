package pl.mmarczewski.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mmarczewski.EcbRate;
import pl.mmarczewski.model.Room;
import pl.mmarczewski.repositories.RoomRepository;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;


@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public RoomService(RoomRepository roomRepository, RestTemplate restTemplate) {
        this.roomRepository = roomRepository;
        this.restTemplate = restTemplate;
    }

    public List<Room> findAll(){
        String ecbRate = restTemplate.getForObject("https://api.exchangeratesapi.io/latest", String.class);
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(ecbRate);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String rate = jsonNode.get("rates").get("PLN").asText();
        BigDecimal rateEurPln = new BigDecimal(rate);
        MathContext mc = new MathContext(4);
        roomRepository.findAll().forEach(g -> g.setPrice_eur(g.getPrice().divide(rateEurPln, mc)));
        return roomRepository.findAll();
    }

    public List<Room> findRoomByType(int roomType){
        String ecbRate = restTemplate.getForObject("https://api.exchangeratesapi.io/latest", String.class);
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(ecbRate);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String rate = jsonNode.get("rates").get("PLN").asText();
        BigDecimal rateEurPln = new BigDecimal(rate);
        MathContext mc = new MathContext(4);
        roomRepository.findAll().forEach(g -> g.setPrice_eur(g.getPrice().divide(rateEurPln, mc)));
        return roomRepository.findRoomByType(roomType);
    }
}
