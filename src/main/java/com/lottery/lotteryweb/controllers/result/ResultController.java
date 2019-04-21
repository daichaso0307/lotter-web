package com.lottery.lotteryweb.controllers.result;

import com.lottery.lotteryweb.requestes.result.GetResultListRequest;
import com.lottery.lotteryweb.requestes.result.GetResultRequest;
import com.lottery.lotteryweb.responses.common.AppApiResponse;
import com.lottery.lotteryweb.responses.result.ResultListResponse;
import com.lottery.lotteryweb.responses.result.ResultResponse;
import com.lottery.lotteryweb.services.result.IResultService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;

import static com.lottery.lotteryweb.commons.constants.HttpStatusValue.*;
import static com.lottery.lotteryweb.commons.constants.HttpStatusValue.SERVER_ERROR;

@RestController
@RequestMapping("/api/result")
public class ResultController {

    @Autowired IResultService resultService;

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
    public ResultResponse getEntry(
            @Valid @NotNull @RequestBody GetResultRequest getResultRequest) {
        return resultService.getResult(getResultRequest);
    }

    @GetMapping("/list")
    @ApiOperation("")
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS, message = "Success", response = AppApiResponse.class),
            @ApiResponse(code = BAD_REQUEST, message = "Bad Request"),
            @ApiResponse(code = UNAUTHORIZED, message = "Unauthorized"),
            @ApiResponse(code = FORBIDDEN, message = "Forbidden"),
            @ApiResponse(code = NOT_FOUND, message = "Not Found"),
            @ApiResponse(code = SERVER_ERROR, message = "Internal Server Error")
    })
    public List<ResultResponse> getResultList(
            @Valid @NotNull @RequestBody GetResultListRequest getResultListRequest) {
        return resultService.getResultList(getResultListRequest);
    }
}
