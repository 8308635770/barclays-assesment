package com.baclays.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baclays.assignment.entity.Trade;


@Repository
public interface TradeRepository extends JpaRepository<Trade, Long>{

}
