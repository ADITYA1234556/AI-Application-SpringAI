package uk.co.aditya.springai.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    // Creating a chatmode from OpenAI
    private final ChatModel chatModel;
    public ChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    // Any message/ques/prompt from user is sent to chatmodel as call and output is returned
    public String getResponse(String prompt){
        return chatModel.call(prompt);
    }

    public String getResponseOptions(String prompt){
        ChatResponse response = chatModel.call(
                new Prompt(
                        prompt,
                        OpenAiChatOptions.builder()
                                .model("gpt-4o")
                                .temperature(0.4)
                                .build()
                                // Higher temperatures closer to 1 means response will be random and creative
                                // lower temperatures closer to 0 means response will be more focused to question from user

                ));
        return response.getResult().getOutput().getContent();
    }
}
