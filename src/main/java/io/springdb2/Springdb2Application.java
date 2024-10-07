package io.springdb2;

import io.springdb2.config.JdbcTemplateV1Config;
import io.springdb2.config.JdbcTemplateV2Config;
import io.springdb2.config.MemoryConfig;
import io.springdb2.domain.item.repository.ItemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

//@Import(MemoryConfig.class)
//@Import(JdbcTemplateV1Config.class)
@Import(JdbcTemplateV2Config.class)
@SpringBootApplication(scanBasePackages = "io.springdb2.web")
public class Springdb2Application {
    public static void main(String[] args) {
        SpringApplication.run(Springdb2Application.class, args);
    }

    @Bean
    @Profile("local")
    public TestDataInit testDataInit(ItemRepository itemRepository) {
        return new TestDataInit(itemRepository);
    }

}
