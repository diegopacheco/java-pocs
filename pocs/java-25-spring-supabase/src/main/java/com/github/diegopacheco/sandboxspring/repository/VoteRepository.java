package com.github.diegopacheco.sandboxspring.repository;

import com.github.diegopacheco.sandboxspring.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findByOptionName(String optionName);

    @Modifying
    @Transactional
    @Query("UPDATE Vote v SET v.voteCount = v.voteCount + 1 WHERE v.optionName = :optionName")
    int incrementVoteCount(@Param("optionName") String optionName);
}