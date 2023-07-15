package ru.dzaytsev.msg.polier;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.dzaytsev.msg.dto.NotificationDto;
import ru.dzaytsev.msg.entity.NotificationEntity;
import ru.dzaytsev.msg.mapper.NotificationMapper;
import ru.dzaytsev.msg.repository.NotificationRepositoty;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationSQSPolier {

    private final NotificationRepositoty notificationRepositoty;
    private final NotificationMapper notificationMapper;

    @SqsListener(value = "${sqs.notifications.queue.name}")
    public void reciveMessage(@Payload NotificationDto message){
        log.info("recived notificationL {}", message);
        NotificationEntity entity = notificationMapper.map(message);
        notificationRepositoty.save(entity).subscribe();
    }
}
