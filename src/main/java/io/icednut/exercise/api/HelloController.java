package io.icednut.exercise.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-02-15
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "Hello, world!";
    }
}
