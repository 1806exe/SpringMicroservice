package com.currencyexchange.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.currencyexchange.bean.ExchangeValue;

@Repository
public interface CurrencyExchnageRepository extends JpaRepository<ExchangeValue, Long> {
	Optional<ExchangeValue> findByFromAndTo(String from, String to);
	
}
