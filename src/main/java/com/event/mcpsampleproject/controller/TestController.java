package com.event.mcpsampleproject.controller;

import com.event.mcpsampleproject.service.LocalOllamaTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {

    final private LocalOllamaTestService localOllamaTestService;

    @RequestMapping(value = "/test/ollama")
    public void testLocalOllama(){
        localOllamaTestService.ollamaLocalTest("llama3.2" , 0L);
    }

    @RequestMapping(value = "/test/spring/ollama")
    public void testSpringAIOllama(){
        localOllamaTestService.ollamaSpringTest();
    }
}
