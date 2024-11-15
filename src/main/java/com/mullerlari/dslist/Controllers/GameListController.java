package com.mullerlari.dslist.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mullerlari.dslist.dto.GameDTO;
import com.mullerlari.dslist.dto.GameListDTO;
import com.mullerlari.dslist.dto.GameMinDTO;
import com.mullerlari.dslist.entities.Game;
import com.mullerlari.dslist.services.GameListService;
import com.mullerlari.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping(value = "/{id}")
	public GameListDTO findById(@PathVariable Long id) {
		GameListDTO result = gameListService.findById(id);
		return result;
	}
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findGames(@PathVariable Long listId) {
		List<GameMinDTO> result = gameService.findByGameList(listId);
		return result;
    }
}