package com.lottery.lotteryweb.requestes.entry;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateEntryRequest {
    @NotNull
    private Long yearId;

    @NotNull
    private Long gameId;

    @NotNull
    private Long gateId;

    @NotBlank
    private String passId;

    @NotBlank
    private String userName;

    @NotBlank
    private String userKana;

    @NotNull
    private Integer person;

    @NotBlank
    private String email;
}
