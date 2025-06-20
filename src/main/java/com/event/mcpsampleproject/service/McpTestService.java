package com.event.mcpsampleproject.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class McpTestService {

    @Tool(description = "Fruit count get")
    public String getFruitCount() {
        Map<String , Integer> Fruit = new HashMap();
        Fruit.put("apple", 3);
        Fruit.put("banana", 4);
        Fruit.put("grape", 5);
        return Fruit.toString();
    }

    @Tool(description = "Mathematics test result")
    public String getMathematicsResult() {
        Map<String , Integer> mathematics = new HashMap();
        mathematics.put("tony", 50);
        mathematics.put("jean", 100);
        mathematics.put("suwon", 20);
        return mathematics.toString();
    }
}
