package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.entity.Vote;
import com.github.diegopacheco.sandboxspring.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/votes")
@CrossOrigin(origins = "*")
public class VotingController {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    @PostMapping("/{optionName}")
    public ResponseEntity<Vote> vote(@PathVariable String optionName) {
        int updated = voteRepository.incrementVoteCount(optionName);

        if (updated > 0) {
            Optional<Vote> updatedVote = voteRepository.findByOptionName(optionName);
            if (updatedVote.isPresent()) {
                messagingTemplate.convertAndSend("/topic/votes", updatedVote.get());
                return ResponseEntity.ok(updatedVote.get());
            }
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{optionName}")
    public ResponseEntity<Vote> getVote(@PathVariable String optionName) {
        Optional<Vote> vote = voteRepository.findByOptionName(optionName);
        return vote.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vote createVote(@RequestBody Vote vote) {
        Vote savedVote = voteRepository.save(vote);
        messagingTemplate.convertAndSend("/topic/votes", savedVote);
        return savedVote;
    }
}