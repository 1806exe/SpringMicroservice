package com.currencyexchange.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currencyexchange.bean.ExchangeValue;

public interface CurrencyExchnageRepository extends JpaRepository<ExchangeValue, Long> {
	Optional<ExchangeValue> findByFromAndTo(String from, String to);
}
