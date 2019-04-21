package com.lottery.lotteryweb.repositories;

import com.lottery.lotteryweb.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    Game findByIdAndDeleteFlag(long gameId, Boolean deleteFlag);
}
