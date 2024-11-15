package com.mullerlari.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mullerlari.dslist.dto.GameDTO;
import com.mullerlari.dslist.dto.GameMinDTO;
import com.mullerlari.dslist.entities.Game;
import com.mullerlari.dslist.projection.GameMinProjection;
import com.mullerlari.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();//busca no BD
		return new GameDTO(result);//Converte para DTO
		
	}

	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); // transformando a GameList em DTO
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByGameList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList(); // transformando a GameList em DTO
	
	}
	

}
