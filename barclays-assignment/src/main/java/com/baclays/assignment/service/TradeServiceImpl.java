package com.baclays.assignment.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.authenticator.SavedRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baclays.assignment.dao.TradeDao;
import com.baclays.assignment.entity.Trade;
import com.baclays.assignment.exceptions.InvalidTradeException;
import com.baclays.assignment.repository.TradeRepository;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepository tradeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TradeDao createTrade(TradeDao tradeDao) {
		
		Trade trade=this.modelMapper.map(tradeDao,Trade.class);
		if(validateTrade(trade)) {	
			trade.setCreatedDate(LocalDate.now());
			Trade savedTrade=tradeRepository.save(trade);
			return this.modelMapper.map(savedTrade, TradeDao.class);
			
		}else {
			throw new InvalidTradeException(trade.getTradeId());
		}
		
		
	}

	@Override
	public List<TradeDao> getAllTrade() {
		List<Trade>trades= tradeRepository.findAll();
		List<TradeDao> tradeDaos=trades.stream().map((trade)->this.modelMapper.map(trade,TradeDao.class)).collect(Collectors.toList());
		return tradeDaos;
	}

	@Override
	public void updateExpriyFlag() {
		
		tradeRepository.findAll().stream().forEach(t->{
			if(validateMaturityDate(t)) {
				t.setExpiredFlag("Y");
				tradeRepository.save(t);
			}
		});
		
	}

	
	public boolean validateTrade(Trade trade) {
		
		
		if (validateMaturityDate(trade)) {
			
			Optional<Trade> exsitingTrade = tradeRepository.findById(trade.getTradeId());
			if (exsitingTrade.isPresent()) {
				return validateVersion(trade, exsitingTrade.get());
			} else {
				return true;
			}
		}
		return false;
	}

	private boolean validateVersion(Trade trade, Trade tradeDao) {
		if (trade.getVersion() >= tradeDao.getVersion()) {
			return true;
		}
		return false;
	}


	private boolean validateMaturityDate(Trade trade) {
		return trade.getMaturityDate().isBefore(LocalDate.now()) ? false : true;
	}
	
	
}
