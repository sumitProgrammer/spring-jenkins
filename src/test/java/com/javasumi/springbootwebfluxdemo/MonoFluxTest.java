/*
 * package com.javasumi.springbootwebfluxdemo;
 * 
 * import org.junit.jupiter.api.Test;
 * 
 * import reactor.core.publisher.Flux; import reactor.core.publisher.Mono;
 * 
 * public class MonoFluxTest {
 * 
 * @Test public void testMono() { Mono<?>
 * monoString=Mono.just("javasumi").log(); //.then(Mono.error(new
 * RuntimeException("Exception Occored"))).log();
 * monoString.subscribe(System.out::println,(e)->System.out.println(e.getMessage
 * ()));
 * 
 * }
 * 
 * @Test public void testFlux() {
 * 
 * Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate",
 * "microservice") .concatWithValues("AWS") .concatWith(Flux.error(new
 * RuntimeException("Exception occured in Flux"))) .concatWithValues("cloud")
 * .log();
 * 
 * fluxString.subscribe(System.out::println,(e)->System.out.println(e.getMessage
 * ())); } }
 */