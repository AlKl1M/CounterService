package com.alkl1m.counter.controlelr;

import com.alkl1m.counter.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CounterController {

    private final CounterService counterService;

    @GetMapping("/")
    public String getCount() {
        return "Total visits: " + counterService.increment();
    }

    @Profile("dev")
    @GetMapping("/reset")
    public String reset() {
        counterService.reset();
        return "Counter reset!";
    }

}
