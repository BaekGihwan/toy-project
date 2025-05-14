package base.backend.api.base.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class apiTestController {

    @GetMapping("/api/v1/test")
    public String test() {
        return "test";
    }
}
