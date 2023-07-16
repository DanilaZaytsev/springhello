package ru.dzaytsev.msg.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.dzaytsev.msg.dto.RecipientDto;
import ru.dzaytsev.msg.entity.RecipientEntity;

@Mapper(componentModel = "spring")
public interface RecipientMapper {
    RecipientDto map(RecipientEntity entity);

    @InheritInverseConfiguration
    RecipientEntity map(RecipientDto dto);
}
