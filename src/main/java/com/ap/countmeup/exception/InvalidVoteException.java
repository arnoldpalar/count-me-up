package com.ap.countmeup.exception;

import com.ap.countmeup.dto.VoteRequest;

public class InvalidVoteException extends Exception {
    private VoteRequest voteRequest;

    public InvalidVoteException(VoteRequest voteRequest){
        super();

        this.voteRequest = voteRequest;
    }
}
