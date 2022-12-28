package com.mgshepherd.backend.repositories;

import com.mgshepherd.backend.models.Game;
import com.mgshepherd.backend.models.GameID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, GameID> {
}
