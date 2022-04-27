package com.baclays.assignment.dao;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TradeDao {

    private Long tradeId;

    private int version;

    private String counterParty;

    private String bookId;

    private LocalDate maturityDate;

    private LocalDate createdDate;

    private String expiredFlag;
    
}
