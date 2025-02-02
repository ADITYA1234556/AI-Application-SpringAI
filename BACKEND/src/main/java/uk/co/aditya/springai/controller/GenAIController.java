package uk.co.aditya.springai.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.co.aditya.springai.service.ChatService;
import uk.co.aditya.springai.service.ImageService;
import uk.co.aditya.springai.service.RecipeService;

import java.io.IOException;
import java.util.List;

@RestController
public class GenAIController {

    private final ChatService chatService;
    private final ImageService imageService;
    private final RecipeService recipeService;
    public GenAIController(ChatService chatService, ImageService imageService, RecipeService recipeService) {
        this.chatService = chatService;
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @GetMapping("askai")
    public String getResponse(@RequestParam String prompt){
        return chatService.getResponse(prompt);
    }

    @GetMapping("askaioptions")
    public String getResponseOptions(@RequestParam String prompt){
        return chatService.getResponseOptions(prompt);
    }

// FOR 1 IMAGE WE CAN REDIRECT
//    @GetMapping("genimage")
//    public void generateImage(HttpServletResponse response, @RequestParam String imagePrompt) throws IOException {
//        ImageResponse imageResponse = imageService.generateImage(imagePrompt);
//        String imageUrl = imageResponse.getResult().getOutput().getUrl();
//        // Lets redirect the user to the URL using HTTPredirect method, we can also just return the string
//        response.sendRedirect(imageUrl);
//    }

// UPGRADED SERVICE TO GET 3 IMAGES, SO DISPLAY LIST OF 3 URLS
    @GetMapping("genimage")
    public List<String> generateImage(HttpServletResponse response,
                                      @RequestParam String imagePrompt,
                                      @RequestParam (defaultValue = "2") int noOfImages)
            throws IOException {
        ImageResponse imageResponse = imageService.generateImage(imagePrompt, noOfImages);
        // Streams to get multiple urls, collect output and url for every result and keep it in a list
        List<String> imageUrls = imageResponse.getResults().stream()
                .map(result -> result.getOutput().getUrl())
                .toList();
        // list of urls

        return imageUrls;
    }

    @GetMapping("recipe")
    public String recipeCreator(@RequestParam String ingredients,
                                      @RequestParam(defaultValue = "any") String cusine,
                                      @RequestParam(defaultValue = "") String dietaryRestrictions){
        return recipeService.createRecipe(ingredients, cusine, dietaryRestrictions);
    }
}
