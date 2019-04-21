package com.lottery.lotteryweb.repositories;

import com.lottery.lotteryweb.models.Year;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearRepository extends JpaRepository<Year, Long> {
    Year findByValueAndDeleteFlag(long yearId, Boolean deleteFlag);
}
