package ru.dzaytsev.msg.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.dzaytsev.msg.dto.NotificationDto;
import ru.dzaytsev.msg.entity.NotificationEntity;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationDto map(NotificationEntity entity);

    @InheritInverseConfiguration
    NotificationEntity map(NotificationDto dto);
}
