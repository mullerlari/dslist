package com.mullerlari.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mullerlari.dslist.dto.GameMinDTO;
import com.mullerlari.dslist.entities.Game;
import com.mullerlari.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); // transformando a GameList em DTO
		return dto;
	}
	

}
