package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {

    public Flux<String> namesFlux() {
        return Flux.fromIterable(List.of("alex", "ben", "chloe"));
    }

    public Flux<String> namesFlux_map() {
        return Flux.fromIterable(List.of("alex", "ben", "chloe"))
                .map(String:: toUpperCase)
//                .map(s -> s.toUpperCase())
                .log();

    }

    public Flux<String> namesFlux_immutability () {
        var namesFlux = Flux.fromIterable(List.of("alex", "ben", "chloe"));
        namesFlux.map(String::toUpperCase);
        return namesFlux;
    }

    public Mono<String> namesMono() {
        return Mono.just("alex").log();
    }
    public static void main(String[] args) {

        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();
        fluxAndMonoGeneratorService.namesFlux()
                .subscribe(name -> {
                    System.out.println("Name is " + name);
                });
        fluxAndMonoGeneratorService.namesMono().subscribe(name -> {
            System.out.println("Mono Name is " + name);
        });

//        fluxAndMonoGeneratorService.namesMono().doOnSuccess(name -> {
//            System.out.println("The name is " + name);
//        }).subscribe();

    }
}
