package GalapagosookYonan.GalapagosookYonan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthTest {

    @GetMapping("/health")
    public String health() {
        return "Health Check";
    }
}
