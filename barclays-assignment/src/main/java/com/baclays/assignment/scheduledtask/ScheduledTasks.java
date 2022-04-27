package com.baclays.assignment.scheduledtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.baclays.assignment.service.TradeService;

@Component
public class ScheduledTasks {
	
	@Autowired
	private TradeService tradeService;
	
	
	@Scheduled(cron ="0 * * * * * ")
	public void reportCurrentTime() {
		tradeService.updateExpriyFlag();
	}

}
