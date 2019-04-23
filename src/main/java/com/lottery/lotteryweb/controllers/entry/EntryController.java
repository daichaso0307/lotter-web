package com.lottery.lotteryweb.controllers.entry;

import com.lottery.lotteryweb.requestes.entry.CreateEntryRequest;
import com.lottery.lotteryweb.requestes.entry.GetEntryRequest;
import com.lottery.lotteryweb.responses.common.AppApiResponse;
import com.lottery.lotteryweb.responses.entry.EntryResponse;
import com.lottery.lotteryweb.services.entry.IEntryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static com.lottery.lotteryweb.common.constants.HttpStatusValue.BAD_REQUEST;
import static com.lottery.lotteryweb.common.constants.HttpStatusValue.FORBIDDEN;
import static com.lottery.lotteryweb.common.constants.HttpStatusValue.NOT_FOUND;
import static com.lottery.lotteryweb.common.constants.HttpStatusValue.SERVER_ERROR;
import static com.lottery.lotteryweb.common.constants.HttpStatusValue.SUCCESS;
import static com.lottery.lotteryweb.common.constants.HttpStatusValue.UNAUTHORIZED;


@RestController
@RequestMapping("/api/entry")
public class EntryController {

    @Autowired IEntryService entryService;

    @PostMapping()
    @ApiOperation("")
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS, message = "Success", response = AppApiResponse.class),
            @ApiResponse(code = BAD_REQUEST, message = "Bad Request"),
            @ApiResponse(code = UNAUTHORIZED, message = "Unauthorized"),
            @ApiResponse(code = FORBIDDEN, message = "Forbidden"),
            @ApiResponse(code = NOT_FOUND, message = "Not Found"),
            @ApiResponse(code = SERVER_ERROR, message = "Internal Server Error")
    })
    public ResponseEntity<?> createEntry(
            @Valid @NotNull @RequestBody CreateEntryRequest createEntryRequest) {
        return entryService.createEntry(createEntryRequest);
    }

    @GetMapping()
    @ApiOperation("")
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS, message = "Success", response = AppApiResponse.class),
            @ApiResponse(code = BAD_REQUEST, message = "Bad Request"),
            @ApiResponse(code = UNAUTHORIZED, message = "Unauthorized"),
            @ApiResponse(code = FORBIDDEN, message = "Forbidden"),
            @ApiResponse(code = NOT_FOUND, message = "Not Found"),
            @ApiResponse(code = SERVER_ERROR, message = "Internal Server Error")
    })
    public EntryResponse getEntry(
            @Valid @NotNull @RequestBody GetEntryRequest getEntryRequest) {
        return entryService.getEntry(getEntryRequest);
    }
}
