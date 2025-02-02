# GenAI Spring Boot Application

## Overview
This project is a Spring Boot application that integrates OpenAI's GPT and DALL·E models for AI-powered chat, image generation, and recipe creation. The backend is designed to provide an API for interacting with AI-based services.

## Features
- **Chat Service**: Interact with OpenAI's GPT model to get AI-generated responses.
- **Image Service**: Generate AI-powered images based on text prompts using OpenAI's DALL·E model.
- **Recipe Service**: Create personalized recipes based on user-inputted ingredients, cuisine preferences, and dietary restrictions.

## Technologies Used
- Java 17+
- Spring Boot 3+
- Spring AI
- OpenAI GPT and DALL·E
- REST API
- Web MVC with CORS configuration

## Setup Instructions
### Prerequisites
- Java 17+
- Maven
- OpenAI API Key

### Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/genai-springboot.git
   cd genai-springboot
   ```
2. Update application properties with your OpenAI API key.
3. Build the project:
   ```sh
   mvn clean install
   ```
4. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints
### 1. Chat with AI
**Endpoint:** `GET /askai?prompt=your_question`
- Example:
  ```sh
  curl "http://localhost:8080/askai?prompt=Hello!"
  ```
- Response:
  ```json
  { "response": "Hello! How can I assist you today?" }
  ```

### 2. Chat with AI (Advanced Options)
**Endpoint:** `GET /askaioptions?prompt=your_question`
- Example:
  ```sh
  curl "http://localhost:8080/askaioptions?prompt=Tell me a joke."
  ```

### 3. Generate AI Images
**Endpoint:** `GET /genimage?imagePrompt=your_prompt&noOfImages=2`
- Example:
  ```sh
  curl "http://localhost:8080/genimage?imagePrompt=A+sunset+over+the+mountains&noOfImages=2"
  ```
- Response:
  ```json
  [
    "https://image-url-1.com",
    "https://image-url-2.com"
  ]
  ```

### 4. Generate Recipe
**Endpoint:** `GET /recipe?ingredients=tomato,cheese&cusine=italian&dietaryRestrictions=vegetarian`
- Example:
  ```sh
  curl "http://localhost:8080/recipe?ingredients=tomato,cheese&cusine=italian&dietaryRestrictions=vegetarian"
  ```

## CORS Configuration
- The `WebConfig` class allows frontend applications (e.g., React on `localhost:3000`) to make API requests.

## OpenAI Troubleshooting
- OpenAI reference guide from Spring docs: https://docs.spring.io/spring-ai/reference/api/chat/openai-chat.html
- Signup to openai and get a key https://openai.com/api/pricing/
- Use this key under application.properties
- Only then spring will be able to create a bean automatically.
- OpenAI chat docs: https://platform.openai.com/docs/api-reference/chat
- OpenAI image docs: https://platform.openai.com/docs/api-reference/images/

## REACTJS Frontend
- npx create-react-app springai-react-frontend
- cd springai-react-frontend && npm start

## Future Enhancements
- Add authentication & API rate limiting.
- Expand support for different AI models.
- Enhance UI integration.

## Screenshots
![Image Generator UI]
![Chat Generator UI]
![Recipe Generator UI]

---
**Maintainer:** Aditya