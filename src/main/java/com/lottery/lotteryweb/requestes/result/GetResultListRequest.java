package com.lottery.lotteryweb.requestes.result;

import lombok.Data;

@Data
public class GetResultListRequest {
    private Integer year;

    private Long gameId;
}
