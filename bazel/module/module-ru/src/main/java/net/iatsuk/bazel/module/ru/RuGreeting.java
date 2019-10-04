package net.iatsuk.bazel.module.ru;

import net.iatsuk.bazel.module.api.Greeting;

public class RuGreeting implements Greeting {
    public String getMessage() {
        return "Привет, мир!";
    }
}
