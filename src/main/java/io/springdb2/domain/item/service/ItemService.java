package io.springdb2.domain.item.service;


import io.springdb2.domain.dto.ItemSearchCond;
import io.springdb2.domain.dto.ItemUpdateDto;
import io.springdb2.domain.item.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item save(Item item);

    void update(Long itemId, ItemUpdateDto updateParam);

    Optional<Item> findById(Long id);

    List<Item> findItems(ItemSearchCond itemSearch);
}
