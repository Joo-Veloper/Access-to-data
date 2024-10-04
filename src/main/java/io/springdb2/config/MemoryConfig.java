package io.springdb2.config;

import io.springdb2.domain.item.repository.ItemRepository;
import io.springdb2.domain.item.repository.memory.MemoryItemRepository;
import io.springdb2.domain.item.service.ItemService;
import io.springdb2.domain.item.service.ItemServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryConfig {

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new MemoryItemRepository();
    }

}