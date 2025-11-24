package com.example.springAI.controller;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springAI.service.ChatService;
import com.example.springAI.service.ImageService;
import com.example.springAI.service.SpeechService;

@RestController
public class AIController {

	ChatService chatService;
	ImageService imageService;
	SpeechService speechService;
	
	public AIController(ChatService chatService,ImageService imageService, SpeechService speechService) {
		this.chatService=chatService;
		this.imageService=imageService;
		this.speechService=speechService;
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Techies";
	}
	
	/*@PostMapping("/ask-ai")
	public String getResponse(@RequestBody String promptQuestion) {
		return chatService.getResponse(promptQuestion);
	}*/
	
	@PostMapping("/ask-ai")
	public ChatResponse getResponse(@RequestBody String promptQuestion) {
		return chatService.getResponse(promptQuestion);
	}
	
	@PostMapping("/generate-image")
	public String generateImage(@RequestBody String prompt) {
		return imageService.generateImage(prompt);
	}
	
	@GetMapping("/text-to-audio")
	public String generateAudio(@RequestBody String prompt) {
		return speechService.generateAudio(prompt);
	}
}
