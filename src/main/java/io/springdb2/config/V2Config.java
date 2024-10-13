package io.springdb2.config;

import io.springdb2.domain.item.jpa.JpaItemRepositoryV3;
import io.springdb2.domain.item.repository.ItemRepository;
import io.springdb2.domain.item.repository.v2.ItemQueryRepositoryV2;
import io.springdb2.domain.item.repository.v2.ItemRepositoryV2;
import io.springdb2.domain.item.service.ItemService;
import io.springdb2.domain.item.service.ItemServiceV2;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class V2Config {
    private final EntityManager em;
    private final ItemRepositoryV2 itemRepositoryV2;//SpringDataJPA
    @Bean
    public ItemService itemService() {
        return new ItemServiceV2(itemRepositoryV2, itemQueryRepositoryV2());
    }

    @Bean
    public ItemQueryRepositoryV2 itemQueryRepositoryV2() {
        return new ItemQueryRepositoryV2(em);
    }
    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepositoryV3(em);
    }
}