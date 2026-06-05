package com.slackclone.notification;

import java.util.List;
import org.springframework.data.domain.Limit;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<Notification, Long> {
    List<Notification> findByUserIdOrderByIdDesc(Long userId, Limit limit);

    List<Notification> findByUserIdAndIsReadFalse(Long userId);
}
