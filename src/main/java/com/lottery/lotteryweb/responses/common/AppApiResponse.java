package com.lottery.lotteryweb.responses.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import static com.lottery.lotteryweb.commons.constants.Shared.SUCCESS_STATUS;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppApiResponse {

    private Boolean success;
    private String message;

    public ResponseEntity<AppApiResponse> success() {
        this.success = Boolean.TRUE;
        this.message = SUCCESS_STATUS;

        return ResponseEntity.ok().body(this);
    }
}
