package com.ap.countmeup.repository;

import com.ap.countmeup.dto.VoteRequest;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class HashMapVoteRepo implements VoteRepo {
    private static final Map<Long, AtomicLong> voteResult = Collections.synchronizedMap(new HashMap<>());
    private static final Map<Long, Set<Long>> voters = Collections.synchronizedMap(new HashMap<>());

    @Override
    public void save(VoteRequest voteRequest) throws Exception {
        Set<Long> votes = voters.getOrDefault(voteRequest.getUserId(), Collections.synchronizedSet(new HashSet<>()));
        votes.add(voteRequest.getCandidateId());

        voters.put(voteRequest.getUserId(), votes);
    }

    @Override
    public Set<Long> getVotes(Long voterId) {
        return voters.get(voterId);
    }

    @Override
    public Set<Long> getCandidates() {
        return voteResult.keySet();
    }

    @Override
    public void cast(VoteRequest voteRequest) throws Exception {
        voteResult.computeIfAbsent(voteRequest.getCandidateId(), k -> new AtomicLong()).addAndGet(1);
    }

    @Override
    public Long count(Long candidateId) {
        return voteResult.get(candidateId).longValue();
    }
}