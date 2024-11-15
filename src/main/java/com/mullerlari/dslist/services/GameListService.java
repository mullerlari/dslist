package com.mullerlari.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mullerlari.dslist.dto.GameDTO;
import com.mullerlari.dslist.dto.GameListDTO;
import com.mullerlari.dslist.dto.GameMinDTO;
import com.mullerlari.dslist.entities.Game;
import com.mullerlari.dslist.entities.GameList;
import com.mullerlari.dslist.repositories.GameListRepository;
import com.mullerlari.dslist.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(GameListDTO::new).toList(); // transformando a GameList em DT
	}


	@Transactional(readOnly = true)
	public GameListDTO findById(Long id) {
		GameList entity = gameListRepository.findById(id).get();
		return new GameListDTO(entity);
	}
	
}
