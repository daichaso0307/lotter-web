package com.lottery.lotteryweb.responses.entry;

import com.lottery.lotteryweb.models.Game;
import com.lottery.lotteryweb.models.Gate;
import com.lottery.lotteryweb.models.Year;
import lombok.Data;

@Data
public class EntryResponse {

    private Integer year;

    private Integer game;

    private String passId;

    private String gateName;

    private String userName;

    private Integer person;

    private String email;
}
