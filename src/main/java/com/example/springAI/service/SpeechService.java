package com.example.springAI.service;

import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiAudioSpeechOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;

//import org.springframework.ai.openai.audio.speech.SpeechPrompt;
//import org.springframework.ai.openai.audio.speech.SpeechResponse;
import org.springframework.ai.audio.tts.TextToSpeechPrompt;
import org.springframework.ai.audio.tts.TextToSpeechResponse;

@Service
public class SpeechService {

	OpenAiAudioSpeechModel openAiAudioSpeechModel;
	
	public SpeechService(OpenAiAudioSpeechModel openAiAudioSpeechModel) {
		this.openAiAudioSpeechModel=openAiAudioSpeechModel;
	}

	public String generateAudio(String prompt) {

		OpenAiAudioSpeechOptions speechOptions=OpenAiAudioSpeechOptions.builder()
				.model("gpt-4o-mini-tts")
				.voice(OpenAiAudioApi.SpeechRequest.Voice.ECHO)
				.responseFormat(OpenAiAudioApi.SpeechRequest.AudioResponseFormat.MP3)
				.speed(1.0)
				.build();
		
		TextToSpeechPrompt textToSpeechPrompt=new TextToSpeechPrompt(prompt,speechOptions);
		TextToSpeechResponse response=openAiAudioSpeechModel.call(textToSpeechPrompt);
		byte[] audio=response.getResult().getOutput();
		
		//convert byte array to mp3
		try(FileOutputStream f=new FileOutputStream("voice.mp3")){
			f.write(audio);
			System.out.println("File created");
		}
		catch(IOException exception) {
			exception.getMessage();
		}
		return "MP3 file is created successfully";
	}
}
