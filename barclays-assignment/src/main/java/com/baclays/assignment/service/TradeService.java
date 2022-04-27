package com.baclays.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baclays.assignment.dao.TradeDao;
import com.baclays.assignment.entity.Trade;

@Service
public interface TradeService {
	
	TradeDao createTrade(TradeDao trade);
	List<TradeDao> getAllTrade();
	void updateExpriyFlag();

}
