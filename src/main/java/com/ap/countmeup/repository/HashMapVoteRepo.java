package com.ap.countmeup.repository;

import com.ap.countmeup.dto.VoteRequest;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class HashMapVoteRepo implements VoteRepo {
    private static final Map<Long, List<Long>> voters = Collections.synchronizedMap(new HashMap<>());
    private static AtomicLong nofVotes = new AtomicLong(0);
    private static final Map<Long, AtomicLong> voteResult = Collections.synchronizedMap(new HashMap<>());

    @Override
    public void save(VoteRequest voteRequest) throws Exception {
        List<Long> votes = voters.getOrDefault(voteRequest.getVoterId(), Collections.synchronizedList(new ArrayList<>()));
        votes.add(voteRequest.getCandidateId());

        voters.put(voteRequest.getVoterId(), votes);
        nofVotes.addAndGet(1);
    }

    @Override
    public List<Long> getVotes(Long voterId) {
        return voters.get(voterId);
    }

    @Override
    public Long total() {
        return nofVotes.longValue();
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