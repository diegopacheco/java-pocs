package com.slackclone.channel;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ChannelRepository extends CrudRepository<Channel, Long> {

    @Query("SELECT c.* FROM channels c JOIN channel_members m ON m.channel_id = c.id WHERE m.user_id = :userId ORDER BY c.id")
    List<Channel> findByMember(@Param("userId") Long userId);

    @Query("SELECT c.* FROM channels c WHERE c.type = 'PUBLIC' AND c.id NOT IN (SELECT channel_id FROM channel_members WHERE user_id = :userId) ORDER BY c.id")
    List<Channel> findPublicNotJoined(@Param("userId") Long userId);

    @Query("SELECT c.* FROM channels c WHERE c.type = 'DIRECT' AND c.id IN (SELECT channel_id FROM channel_members WHERE user_id = :a) AND c.id IN (SELECT channel_id FROM channel_members WHERE user_id = :b) LIMIT 1")
    Optional<Channel> findDirect(@Param("a") Long a, @Param("b") Long b);
}
