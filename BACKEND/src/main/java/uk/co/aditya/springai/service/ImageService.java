package uk.co.aditya.springai.service;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final OpenAiImageModel openAiImageModel;
    public ImageService(OpenAiImageModel openAiImageModel) {
        this.openAiImageModel = openAiImageModel;
    }

    public ImageResponse generateImage(String imagePrompt, int noOfImages) {
//        ImageResponse imageResponse = openAiImageModel.call(
//                new ImagePrompt(imagePrompt) ); upgrading this by passing image options as well

//        ImageResponse imageResponse = openAiImageModel.call(
//                new ImagePrompt(imagePrompt,
//                        OpenAiImageOptions.builder()
//                                .quality("hd")
//                                .model("dall-e-2") //dalle-3 supports only 1 image, so we choose dalle3
//                                .N(2) // number of images as output
//                                .height(1024)
//                                .width(1024)
//                                .build())
//        ); upgrading this to also pass number of images that can be generated

        ImageResponse imageResponse = openAiImageModel.call(
                new ImagePrompt(imagePrompt,
                        OpenAiImageOptions.builder()
                                .quality("hd")
                                .model("dall-e-2") //dalle-3 supports only 1 image, so we choose dalle3
                                .N(noOfImages) // number of images as output
                                .height(1024)
                                .width(1024)
                                .build())
        );

        return imageResponse;
    }
}
