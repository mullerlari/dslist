package com.mullerlari.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mullerlari.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
