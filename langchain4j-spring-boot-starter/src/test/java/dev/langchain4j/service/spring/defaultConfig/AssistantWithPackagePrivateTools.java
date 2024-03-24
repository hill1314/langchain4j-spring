package dev.langchain4j.service.spring.defaultConfig;

import dev.langchain4j.service.spring.AiService;

@AiService(tools = {"packagePrivateTools"})
public interface AssistantWithPackagePrivateTools {

    String chat(String userMessage);
}