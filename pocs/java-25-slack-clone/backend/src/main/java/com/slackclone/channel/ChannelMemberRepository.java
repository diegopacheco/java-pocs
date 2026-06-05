package com.slackclone.channel;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface ChannelMemberRepository extends CrudRepository<ChannelMember, Long> {
    List<ChannelMember> findByChannelId(Long channelId);

    List<ChannelMember> findByUserId(Long userId);

    boolean existsByChannelIdAndUserId(Long channelId, Long userId);

    Optional<ChannelMember> findByChannelIdAndUserId(Long channelId, Long userId);
}
