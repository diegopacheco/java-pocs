package com.slackclone.message;

import java.util.List;
import org.springframework.data.domain.Limit;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findByChannelIdOrderByIdDesc(Long channelId, Limit limit);

    List<Message> findByChannelIdAndIdLessThanOrderByIdDesc(Long channelId, Long id, Limit limit);
}
