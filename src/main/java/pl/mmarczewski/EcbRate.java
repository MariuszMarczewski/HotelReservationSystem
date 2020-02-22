package pl.mmarczewski;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.simple.JSONObject;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EcbRate {

    private List<JSONObject> rates;

    public EcbRate() {
    }

    public List<JSONObject> getRates() {
        return rates;
    }

    public void setRates(List<JSONObject> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "EcbRate{" +
                "rates=" + rates +
                '}';
    }
}
