package edu.monetary.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Converter class responsible for currency conversion using an external API.
 * It fetches exchange rates and calculates the converted amount.
 * @author Joaquim Neto
 * @version 1.0
 */
public class Converter {

    private ConversionData data;

    private ObjectMapper mapper;

    public Converter(ConversionData data) {
        this.data = data;
        this.mapper = new ObjectMapper();
    }

    /**
     * Calculates the converted amount based on the exchange rate fetched from the
     * API.
     * @return BigDecimal representing the converted amount.
     * @throws IOException if an I/O error occurs when sending or receiving.
     * @throws InterruptedException if the operation is interrupted.
     */
    public BigDecimal calculate() throws IOException, InterruptedException {
        String jsonString = this.getExchangeRates();

        Double destinyRate = getDestinyRate(jsonString);

        return data.getAmount().multiply(BigDecimal.valueOf(destinyRate));
    }

    /**
     * Fetches exchange rates from the external API.
     * @return JSON string containing exchange rate information.
     * @throws IOException           if an I/O error occurs when sending or receiving.
     * @throws InterruptedException  if the operation is interrupted.
     * @throws IllegalStateException if the API key is not found.
     */
    private String getExchangeRates() throws IOException, InterruptedException, IllegalStateException {

        String apiKey = getApiKey();

        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + data.getBaseCode() + "/" + data.getTargetCode();

        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();

    }

    /**
     * Reads the API key from the application properties file.
     * @return String representing the API key.
     * @throws IOException if there is an error reading the properties file.
     */
    private String getApiKey() throws IOException {

        Path path = Paths.get("src/main/resources/application.properties");
        BufferedReader reader = Files.newBufferedReader(path);

        String apiKey = reader.lines()
                .filter(line -> line.startsWith("exchange.rate.api.key="))
                .map(line -> line.split("=")[1])
                // .map(api -> api.replace("\"", "").trim())
                .findFirst()
                .orElse(null);

        reader.close();

        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("API key is not found.");
        }

        return apiKey;
    }

    /**
     * Extracts the conversion rate from the JSON response.
     * @param jsonString JSON string containing exchange rate information.
     * @return Double representing the conversion rate.
     * @throws JsonProcessingException if there is a problem processing the JSON.
     * @throws JsonMappingException    if there is a problem mapping the JSON.
     */
    private Double getDestinyRate(String jsonString) throws JsonProcessingException {
        JsonNode tree = mapper.readTree(jsonString);

        Double conversionRate = tree.get("conversion_rate").asDouble();

        return conversionRate;
    }

}
