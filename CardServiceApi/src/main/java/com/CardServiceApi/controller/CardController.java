package com.CardServiceApi.controller;

import com.CardServiceApi.model.Card;
import com.CardServiceApi.service.impl.CardServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardController {
    private final CardServiceImpl cardService;

    public CardController(CardServiceImpl cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/register")
    public String cardRegister(@RequestBody Card card){
        var findCard=cardService.cardIsActive(card.getCardNumber());
        if(findCard!=null){
            return "Card is already exists.";
        }

        return cardService.cardRegister(card).toString();
    }

    @PostMapping("/withdraw")
    public String cashOutFromCard(@RequestHeader("cardNumber") long cardNumber,@RequestHeader("cif") int cif,@RequestHeader("amount") long amount){
        return cardService.withdrawFromCard(cardNumber,cif,amount);
    }

    @PostMapping("/deposit")
    public String increasingTheBalanceOfTheCard(@RequestHeader("cardNumber") long cardNumber,@RequestHeader("cif") int cif,@RequestHeader("amount") long amount){
        return cardService.increasingTheBalanceOfTheCard(cardNumber,cif,amount);
    }


    @GetMapping("/findCard")
    public String findCard(@RequestHeader("cardNumber") long cardNumber,@RequestHeader("cif") int cif){
        return cardService.findCard(cardNumber,cif);
    }

}
