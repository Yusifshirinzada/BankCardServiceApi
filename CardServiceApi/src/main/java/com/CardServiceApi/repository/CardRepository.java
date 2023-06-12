package com.CardServiceApi.repository;

import com.CardServiceApi.model.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card,Long> {
}
