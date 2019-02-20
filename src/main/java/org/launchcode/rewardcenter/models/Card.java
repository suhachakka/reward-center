package org.launchcode.rewardcenter.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigInteger;
import java.time.Month;
import java.time.YearMonth;


@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull
    @Size(min=1,max=15)
    private String cardName;

    @NotNull
    @Size(min=1,max=20)
    private String cardBrand;

    @NotNull
    @Digits(integer = 10,fraction = 0)
    private BigInteger cardNumber;

    @NotNull
    @Size(min=1,max=20)
    private String cardType;

    @NotNull
    @Size(min=1,max=15)
    private String issuedBank;

    @Column(name= "Date")
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private YearMonth yearMonth;

    public Card() {

    }


    public Card(String cardName,  String cardBrand,
            BigInteger cardNumber,  String cardType,
                 String issuedBank, YearMonth yearMonth) {
        this.cardName = cardName;
        this.cardBrand = cardBrand;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.issuedBank = issuedBank;
        this.yearMonth = yearMonth;
    }

    public Integer getId() {
        return id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public BigInteger getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(BigInteger cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getIssuedBank() {
        return issuedBank;
    }

    public void setIssuedBank(String issuedBank) {
        this.issuedBank = issuedBank;
    }


    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }
}
