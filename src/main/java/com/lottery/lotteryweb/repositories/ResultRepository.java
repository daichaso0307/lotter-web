package com.lottery.lotteryweb.repositories;

import com.lottery.lotteryweb.models.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    Result findByPassIdAndYearAndGameIdAndDeleteFlag(String passId, int year, long gameId, Boolean deleteFlag);

    List<Result> findByYearAndGameIdAndDeleteFlag(int year, long gameId, Boolean deleteFlag);
}
