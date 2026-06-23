package com.github.diegopacheco.sandboxspring.structuredoutput;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/filmography")
public class FilmographyController {

    private final FilmographyService service;

    public FilmographyController(FilmographyService service) {
        this.service = service;
    }

    @GetMapping("/basic")
    public ActorsFilms basic(@RequestParam String actor) {
        return service.basic(actor);
    }

    @GetMapping("/validated")
    public ActorsFilms validated(@RequestParam String actor) {
        return service.validated(actor);
    }

    @GetMapping("/provider")
    public ActorsFilms providerNative(@RequestParam String actor) {
        return service.providerNative(actor);
    }
}
