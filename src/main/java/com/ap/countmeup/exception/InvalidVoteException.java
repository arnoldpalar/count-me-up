package com.ap.countmeup.exception;

import com.ap.countmeup.dto.VoteRequest;

public class InvalidVoteException extends Exception {

    public InvalidVoteException(VoteRequest voteRequest){
        super(voteRequest.getVoterId() + " : " + voteRequest.getCandidateId());
    }
}
