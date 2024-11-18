package com.carrot.back.api.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class TestService {
    public TestResponse busan() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders header = new HttpHeaders();
        header.set("Accept", "application/json");
        HttpEntity<?> entity = new HttpEntity<>(header);

        String serviceKey = "WCNu35iMNG82k9c5hC0QVp4T1FMe0sOm5yklhUizrnFSAC7IGsvn1w+jplO7oGomxeLwcc2PgaxGbFBthVkaAw==";

        String uri = UriComponentsBuilder.fromUriString("http://apis.data.go.kr/6260000/FoodService/getFoodKr")
                .queryParam("serviceKey", serviceKey)
                .queryParam("resultType", "json")
                .encode()
                .build()
                .toUriString();

        String encodeUri = uri.contains("+") ? uri.replace("+", "%2B") : uri;
        URI uri1 = UriComponentsBuilder.fromUriString(encodeUri).build(true).toUri();

        ResponseEntity<String> responseEntity = restTemplate.exchange(uri1, HttpMethod.GET, entity, String.class);
        String responseBody = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(responseBody, TestResponse.class);
    }
}
