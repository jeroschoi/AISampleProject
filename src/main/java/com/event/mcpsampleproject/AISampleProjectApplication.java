package com.event.mcpsampleproject;

import com.event.mcpsampleproject.service.McpTestService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AISampleProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AISampleProjectApplication.class, args);
    }

    @Bean
    public List<ToolCallback> testServiceTools(McpTestService mcpTestService) {
        return List.of(ToolCallbacks.from(mcpTestService));
    }
}
