package com.CardServiceApi.service;

import com.CardServiceApi.model.Card;

public interface CardService {
    Card cardRegister(Card card);

    String withdrawFromCard(long cardNumber,int cif,long amount);

    String increasingTheBalanceOfTheCard(long cardNumber,int cif,long amount);

    String findCard(long cardNumber,int cif);

    Card cardIsActive(long cardNumber);
}
