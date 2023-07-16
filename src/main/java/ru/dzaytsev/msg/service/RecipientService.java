package ru.dzaytsev.msg.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.dzaytsev.msg.dto.RecipientDto;
import ru.dzaytsev.msg.entity.NotificationEntity;
import ru.dzaytsev.msg.entity.RecipientEntity;
import ru.dzaytsev.msg.mapper.RecipientMapper;
import ru.dzaytsev.msg.repository.NotificationRepositoty;
import ru.dzaytsev.msg.repository.RecipientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipientService {

    private final NotificationRepositoty notificationRepositoty;
    private final RecipientRepository recipientRepository;
    private final RecipientMapper recipientMapper;

    public Mono<RecipientDto> findRecipientWithNotificationsByUid(String uid){
        return Mono.zip(recipientRepository.findById(uid),
                notificationRepositoty.findAllByRecipientUid(uid).collectList())
                .map(tuples -> {
                    RecipientEntity recipient = tuples.getT1();
                    List<NotificationEntity>notification = tuples.getT2();
                    recipient.setNotification(notification);
                    return recipientMapper.map(recipient);
                });
    }
}
