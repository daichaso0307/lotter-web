package com.lottery.lotteryweb.services.result;

import com.lottery.lotteryweb.models.Result;
import com.lottery.lotteryweb.repositories.ResultRepository;
import com.lottery.lotteryweb.requestes.result.GetResultListRequest;
import com.lottery.lotteryweb.requestes.result.GetResultRequest;
import com.lottery.lotteryweb.responses.result.ResultListResponse;
import com.lottery.lotteryweb.responses.result.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ResultService implements IResultService {

    @Autowired ResultRepository resultRepository;

    @Override
    public ResultResponse getResult(GetResultRequest getResultRequest) {

        ResultResponse response = new ResultResponse();

        String passId = getResultRequest.getPassId();
        int year = getResultRequest.getYear();
        long gameId = getResultRequest.getGameId();

        Result result = resultRepository.findByPassIdAndYearAndGameIdAndDeleteFlag(passId, year, gameId, Boolean.FALSE);

        response.setPassId(result.getPassId());
        response.setLotteryNo(result.getLotteryNo());
        response.setPerson(result.getPerson());

        return response;
    }

    @Override
    public List<ResultResponse> getResultList(GetResultListRequest getResultListRequest) {

        List<ResultResponse> responseList = new ArrayList();

        int year = getResultListRequest.getYear();
        long gameId = getResultListRequest.getGameId();

        List<Result> resultList = resultRepository.findByYearAndGameIdAndDeleteFlag(year, gameId, Boolean.FALSE);

        for (Result result : resultList) {
            ResultResponse response = new ResultResponse();
            response.setPassId(result.getPassId());
            response.setLotteryNo(result.getLotteryNo());
            response.setPerson(result.getPerson());
            responseList.add(response);
        }

        return responseList;
    }
}
