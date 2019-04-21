package com.lottery.lotteryweb.repositories;

import com.lottery.lotteryweb.models.Gate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GateRepository extends JpaRepository<Gate, Long> {
    Gate findByIdAndDeleteFlag(long gateId, Boolean deleteFlag);
}
