package com.mullerlari.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mullerlari.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
