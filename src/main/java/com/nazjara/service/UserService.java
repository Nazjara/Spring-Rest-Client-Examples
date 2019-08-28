package com.nazjara.service;

import com.nazjara.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<User> getUsers(Mono<Integer> limit);
}