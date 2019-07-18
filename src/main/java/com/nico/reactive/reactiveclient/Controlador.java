package com.nico.reactive.reactiveclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive-client")
public class Controlador {

    WebClient client = WebClient.create("http://localhost:8181");

    @GetMapping("/getMonoClient")
    public void get(){
        Mono<ObjetoDominio> objetoDominioMono = client.get()
                .uri("/controlador/obtenerMono")
                .retrieve()
                .bodyToMono(ObjetoDominio.class);

        objetoDominioMono.subscribe(System.out::println);
    }
}
