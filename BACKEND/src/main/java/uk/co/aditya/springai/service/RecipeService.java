package uk.co.aditya.springai.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RecipeService {

    private final ChatModel chatModel;
    public RecipeService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String createRecipe(String ingredients,
                               String cusine,
                               String dietaryRestrictions) {

        // Let us create a template, this is how the query will be passed to the AI. The map.of will replace the values in this template from user request.
        var template = """
                I want to create a recipe using the following ingredients: {ingredients}.
                The cusine type I prefer is {cusine}.
                Please consider the following dietary restrictions: {dietaryRestrictions}.
                Kindly provide me with a detailed recipe including title, list of ingredients, and cooking instructions.
                """;

        // We can use the template to replace the dynamic variables using the Map.of function
        PromptTemplate promptTemplate = new PromptTemplate(template);
        Map<String, Object> params = Map.of(
                "ingredients", ingredients,
                "cusine", cusine,
                "dietaryRestrictions", dietaryRestrictions
        );

        // We are creating a prompt to be sent to the AI and with that it creates a response based on prompt
        Prompt prompt = promptTemplate.create(params);
        return chatModel.call(prompt).getResult().getOutput().getContent();
    }
}
