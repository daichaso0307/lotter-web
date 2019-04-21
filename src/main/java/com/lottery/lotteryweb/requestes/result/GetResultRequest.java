package com.lottery.lotteryweb.requestes.result;

import lombok.Data;

@Data
public class GetResultRequest {
    private String passId;

    private Integer year;

    private Long gameId;
}
