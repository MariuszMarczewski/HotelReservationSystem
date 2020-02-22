package pl.mmarczewski.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mmarczewski.model.Easement;
import pl.mmarczewski.repositories.EasementRepository;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@Service
public class EasementService {

    private final EasementRepository easementRepository;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public EasementService(EasementRepository easementRepository, RestTemplate restTemplate) {
        this.easementRepository = easementRepository;
        this.restTemplate = restTemplate;
    }

    public List<Easement> findAll(){
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
        easementRepository.findAll().forEach(g -> g.setPrice_eur(g.getPricePln().divide(rateEurPln, mc)));
        return easementRepository.findAll();
    }
}
