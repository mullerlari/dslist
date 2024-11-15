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
public class GameController {

	@Autowired
	private GameListService gameListService;

	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
}
