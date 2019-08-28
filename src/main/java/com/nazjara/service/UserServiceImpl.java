package com.nazjara.service;

import com.nazjara.model.User;
import com.nazjara.model.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Value("${api.url}")
    private String url;

    @Override
    public Flux<User> getUsers(Mono<Integer> limit) {
        return WebClient.create(url)
                .get()
                .uri(uriBuilder -> uriBuilder.queryParam("limit", limit.subscribe()).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(UserData.class))
                .flatMapIterable(UserData::getData);
    }
}