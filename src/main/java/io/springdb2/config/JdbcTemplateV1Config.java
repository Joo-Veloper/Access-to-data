package io.springdb2.config;



import io.springdb2.domain.item.repository.ItemRepository;
import io.springdb2.domain.item.service.ItemService;
import io.springdb2.domain.item.service.ItemServiceV1;
import io.springdb2.jdbctemplate.JdbcTemplateItemRepositoryV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JdbcTemplateV1Config {

    private final DataSource dataSource;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JdbcTemplateItemRepositoryV1(dataSource);
    }

}
