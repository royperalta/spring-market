package com.example.market.persistence.mapper;

import com.example.market.domain.Category;
import com.example.market.persistence.Entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.crypto.spec.PSource;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria",target = "categoryId"),
            @Mapping(source = "descripcion",target = "category"),
            @Mapping(source = "estado",target = "active")
    })
    Category toCategory(Category categoria);

    @InheritInverseConfiguration
    @Mapping(target = "producto", ignore = true)
    Categoria toCategoria (Category category);
}
