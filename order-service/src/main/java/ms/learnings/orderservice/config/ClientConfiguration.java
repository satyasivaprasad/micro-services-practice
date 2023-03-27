package ms.learnings.orderservice.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;

public class ClientConfiguration {
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}
