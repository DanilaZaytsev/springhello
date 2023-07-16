package ru.dzaytsev.msg.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import ru.dzaytsev.msg.entity.NotificationEntity;

public interface NotificationRepositoty extends R2dbcRepository<NotificationEntity, String> {
    Flux<NotificationEntity> findAllByRecipientUid(String uid);
}
