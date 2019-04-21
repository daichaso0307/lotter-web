package com.lottery.lotteryweb.requestes.entry;

import lombok.Data;

@Data
public class GetEntryRequest {
    private String passId;

    private String email;
}
