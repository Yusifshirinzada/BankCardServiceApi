package com.CardServiceApi.service.impl;

import com.CardServiceApi.model.Card;
import com.CardServiceApi.repository.CardRepository;
import com.CardServiceApi.service.CardService;
import org.springframework.stereotype.Component;

@Component
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository=cardRepository;
    }

    @Override
    public Card cardRegister(Card card) {
            return cardRepository.save(card);
    }

    @Override
    public String withdrawFromCard(long cardNumber,int cif,long amount) {
        var card=cardRepository.findById(cardNumber).orElse(null);

        if(card!=null){
            var balance=card.getBalance();
            if(card.getCif()==cif){
                if (balance>=amount){
                    card.setBalance(balance-amount);
                    cardRepository.save(card);
                    return "The amount of "+amount+" AZN has been deducted from the card. Balance: "+card.getBalance();
                }

                return "Balance is insufficient. Balance: "+balance+" , amount: "+amount;

            }
            return "Cif is wrong.";
        }

        return "Card not found.";
    }

    @Override
    public String increasingTheBalanceOfTheCard(long cardNumber,int cif,long amount){
        var card=cardRepository.findById(cardNumber).orElse(null);

        if(card!=null){
            var balance=card.getBalance();
            if(card.getCif()==cif){
                    card.setBalance(balance+amount);
                    cardRepository.save(card);
                    return "The amount of "+amount+" AZN has been added to the card. Balance: "+card.getBalance();
            }
            return "Cif is wrong.";
        }

        return "Card not found.";
    }

    @Override
    public String findCard(long cardNumber,int cif){
        var card=cardRepository.findById(cardNumber).orElse(null);
        if(card!=null){
            if (card.getCif()==cif){
                return card.toString();
            }

            return "Cif is wrong." ;
        }
        return "Card not found";
    }

    @Override
    public Card cardIsActive(long cardNumber) {
        return cardRepository.findById(cardNumber).orElse(null);
    }
}
