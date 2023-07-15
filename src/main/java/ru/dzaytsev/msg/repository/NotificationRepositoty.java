package ru.dzaytsev.msg.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import ru.dzaytsev.msg.entity.NotificationEntity;

public interface NotificationRepositoty extends R2dbcRepository<NotificationEntity, String> {
}
