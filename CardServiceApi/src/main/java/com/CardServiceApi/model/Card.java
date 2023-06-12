package com.CardServiceApi.model;

import com.fasterxml.jackson.datatype.jsr310.ser.YearMonthSerializer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    private long cardNumber;

    private String cardholderName;
    private YearMonth cardExpirationDate;
    private int cif;
    private long balance;

    @Override
    public String toString() {
        return "Card Number: " + cardNumber +
                "\nCardholder Name: " + cardholderName  +
                "\nCif: " + cif +
                "\nCard date: "+cardExpirationDate+
                "\nbalance: " + balance;
    }
}
