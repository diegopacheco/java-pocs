package com.github.diegopacheco.sandboxspring.structuredoutput;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class FilmographyService {

    private final ChatClient chatClient;

    public FilmographyService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public ActorsFilms basic(String actor) {
        return chatClient.prompt()
                .user("Generate the filmography of 5 movies for the actor " + actor + ".")
                .call()
                .entity(ActorsFilms.class);
    }

    public ActorsFilms validated(String actor) {
        return chatClient.prompt()
                .user("Generate the filmography of 5 movies for the actor " + actor + ".")
                .call()
                .entity(ActorsFilms.class, spec -> spec.validateSchema());
    }

    public ActorsFilms providerNative(String actor) {
        return chatClient.prompt()
                .user("Generate the filmography of 5 movies for the actor " + actor + ".")
                .call()
                .entity(ActorsFilms.class, spec -> spec.useProviderStructuredOutput());
    }
}
