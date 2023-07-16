package ru.dzaytsev.msg.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.dzaytsev.msg.dto.NotificationDto;
import ru.dzaytsev.msg.mapper.NotificationMapper;
import ru.dzaytsev.msg.repository.NotificationRepositoty;
import ru.dzaytsev.msg.repository.RecipientRepository;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepositoty notificationRepositoty;
    private final RecipientRepository recipientRepository;
    private final NotificationMapper notificationMapper;

    public Mono<NotificationDto> findNotificationByUid(String uid){
        return  notificationRepositoty.findById(uid)
                .map(notificationMapper::map);
    }

    public  Mono<NotificationDto> findNotificationWithRecipientByUid(String uid){
        return notificationRepositoty.findById(uid)
                .flatMap(notificationEntity -> recipientRepository.findById(notificationEntity.getRecipientUid())
                        .map(recipientEntity -> {
                            notificationEntity.setRecipient(recipientEntity);
                            return notificationEntity;
                        }).map(notificationMapper::map));
    }
}
