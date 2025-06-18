package com.event.mcpsampleproject.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class LocalOllamaTestService {
    private final WebClient webClient = WebClient.create("http://localhost:11434");
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void evaluate(String model , Long temperature) {
        try {
            Map<String, Object> body = Map.of(
                    "model", model,
                    "messages", List.of(
                            Map.of("role", "user", "content", "you are teacher now you check the exams data~"),
                            Map.of("role", "user", "content", "Here is good example.\n```json\n" + "Heungseon Daewongun, who governed for approximately ten years after King Gojong's ascension to the throne in 1863, pursued various reform policies aimed at strengthening royal authority and stabilizing the people's livelihood." + "\n```\n"),
                            Map.of("role" , "user" , "content" ,"the exams data : i down know ~ history"),
                            Map.of("role", "user", "content", "Your output must follow this format:{\"score\": $NUMBER, \"reason\": \"$TEXT\"}\n")
                    ),
                    "stream", false,
                    "options", Map.of("temperature", temperature)
            );

            String responseStr = webClient.post()
                    .uri("/api/chat")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue(body))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            log.info("\nInput: {}\n\nOutput : {}", body, responseStr);

            JsonNode response = objectMapper.readTree(responseStr);
            String message = response.get("message").get("content").asText().replace("\n", " ");
            log.info("return data : {}" , message );

        } catch (Exception e) {
            log.error("Evaluation failed", e);
        }
    }
}
