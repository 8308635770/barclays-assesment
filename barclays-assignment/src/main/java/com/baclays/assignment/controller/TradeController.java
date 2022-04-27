package com.baclays.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baclays.assignment.dao.TradeDao;
import com.baclays.assignment.service.TradeService;

@RestController
@RequestMapping("/api/")
public class TradeController {
	
	@Autowired
	private TradeService tradeService;
	
	@PostMapping("/trade")
	public ResponseEntity<TradeDao> createTrade(@RequestBody TradeDao tradeDao){
		
		TradeDao createdTradeDao=tradeService.createTrade(tradeDao);
		
		return new ResponseEntity<TradeDao>(createdTradeDao,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/trade")
	public ResponseEntity<List<TradeDao>> getAllTrades(){
		List<TradeDao>tradeDaos=tradeService.getAllTrade();
		return new ResponseEntity<List<TradeDao>>(tradeDaos,HttpStatus.OK);
	}

}
