package io.github.mat3e;

import java.util.Optional;

//this class will be prepare the response, because SRP (Single Responsibility Principle)
class HelloService {
    static final String FALLBACK_NAME="world";
    String prepareGreeting(String name) {
        return "Hello " + Optional.ofNullable(name).orElse(FALLBACK_NAME) + "!";
    }
}
