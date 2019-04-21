package com.lottery.lotteryweb.services.result;

import com.lottery.lotteryweb.requestes.result.GetResultListRequest;
import com.lottery.lotteryweb.requestes.result.GetResultRequest;
import com.lottery.lotteryweb.responses.result.ResultListResponse;
import com.lottery.lotteryweb.responses.result.ResultResponse;

import java.util.List;

public interface IResultService {
    ResultResponse getResult(GetResultRequest getResultRequest);

    List<ResultResponse> getResultList(GetResultListRequest getResultListRequest);
}
