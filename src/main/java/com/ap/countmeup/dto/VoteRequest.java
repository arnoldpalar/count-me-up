package com.ap.countmeup.dto;

import lombok.*;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor @Builder
public class VoteRequest {
    private Long voterId;
    private Long candidateId;
}