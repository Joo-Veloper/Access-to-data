package io.springdb2.config;

import io.springdb2.domain.item.jpa.JpaItemRepositoryV2;
import io.springdb2.domain.item.jpa.JpaItemRepositoryV3;
import io.springdb2.domain.item.jpa.SpringDataJpaItemRepository;
import io.springdb2.domain.item.repository.ItemRepository;
import io.springdb2.domain.item.service.ItemService;
import io.springdb2.domain.item.service.ItemServiceV1;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class QuerydslConfig {
    private final EntityManager em;
    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }
    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepositoryV3(em);
    }
}