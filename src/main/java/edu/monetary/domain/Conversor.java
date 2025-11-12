package edu.monetary.domain;

import java.io.IOException;
import java.math.BigDecimal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Conversor {

    private ConversionData data;

    private ObjectMapper mapper;

    public Conversor(ConversionData data) {
        this.data = data;
        this.mapper = new ObjectMapper();
    }

    public BigDecimal calculate() throws IOException, InterruptedException {
        String jsonString = this.getExchangeRates();

        Double destinyRate = getDestinyRate(jsonString);
        
        return data.getAmount().multiply(BigDecimal.valueOf(destinyRate));
    }

    private String getExchangeRates() throws IOException, InterruptedException {
        
        String url = "https://v6.exchangerate-api.com/v6/d54da88011b125f86a17d107/pair/" + data.getBaseCode() + "/" + data.getTargetCode();
        
        HttpClient client = HttpClient.newBuilder().build();
        
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
        
        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        
    }

    private Double getDestinyRate(String jsonString) throws JsonProcessingException, JsonMappingException {
        JsonNode tree = mapper.readTree(jsonString);

        Double conversionRate = tree.get("conversion_rate").asDouble();
        
        return conversionRate;
    }

}
