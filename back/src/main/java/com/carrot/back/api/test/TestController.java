package com.carrot.back.api.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final TestService testService;

    @GetMapping("/busan")
    public ResponseEntity<TestResponse> busan() throws JsonProcessingException {
        return ResponseEntity.ok(testService.busan());
    }
}
