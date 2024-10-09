package io.springdb2.domain.item.mybatis;

import io.springdb2.domain.dto.ItemSearchCond;
import io.springdb2.domain.dto.ItemUpdateDto;
import io.springdb2.domain.item.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {
    void save(Item item);

    void update(@Param("id") Long id, @Param("updateParam") ItemUpdateDto updateParam);

    Optional<Item> findById(Long id);

    List<Item> findAll(ItemSearchCond itemSearch);
}
