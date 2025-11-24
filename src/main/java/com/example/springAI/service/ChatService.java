package com.example.springAI.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

	private final ChatModel chatModel;
	
	public ChatService(ChatModel chatModel) {
		this.chatModel=chatModel;
	}
	
	/*public String getResponse(String promptQuestion) {
		
		OpenAiChatOptions options=OpenAiChatOptions.builder()
        .model("gpt-4o")
        .maxTokens(150)  // Use maxTokens for non-reasoning models
        .build();
		
		Prompt prompt=new Prompt(promptQuestion, options);
		ChatResponse response = chatModel.call(prompt);
		return response.getResult().getOutput().getText();
	}*/
	
	
	public ChatResponse getResponse(String promptQuestion) {
		
		OpenAiChatOptions options=OpenAiChatOptions.builder()
        .model("gpt-4o")
        .maxTokens(150)  // Use maxTokens for non-reasoning models
        .build();
		
		Prompt prompt=new Prompt(promptQuestion, options);
		ChatResponse response = chatModel.call(prompt);
		return response;
	}
}
