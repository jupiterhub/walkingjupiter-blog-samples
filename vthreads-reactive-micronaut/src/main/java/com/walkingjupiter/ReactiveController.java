package com.walkingjupiter;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.rxjava3.core.Single;

@Controller("/reactive")
public class ReactiveController {

    @Get("/data")
    public Single<String> getData() {
        return Single.fromCallable(() -> {
                    // Simulate slow external service
                    Thread.sleep(2000);
                    return "Data from slow service";
                })
                .map(String::toUpperCase);
    }
}