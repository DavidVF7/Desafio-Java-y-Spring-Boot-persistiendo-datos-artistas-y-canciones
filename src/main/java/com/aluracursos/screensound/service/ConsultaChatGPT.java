package com.aluracursos.screensound.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {

    public static String obtenerInformacion(String texto){
        OpenAiService service = new OpenAiService(System.getenv("OPENAI_APIKEY"));

        CompletionRequest request = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("hablame sobre el artista: " + texto)
                .maxTokens(500)
                .temperature(0.7)
                .build();

        var respuesta = service.createCompletion(request);
        return respuesta.getChoices().get(0).getText();
    }
}
