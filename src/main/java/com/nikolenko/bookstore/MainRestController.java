package com.nikolenko.bookstore;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RestController
public class MainRestController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/rest")
    @CrossOrigin
    public Greeting greeting(@RequestParam(required = false, defaultValue = "") String name) {
        log.info("==== " + name + "  " + counter + " ====  ");
        return new Greeting(counter.incrementAndGet(), name);
    }
}

