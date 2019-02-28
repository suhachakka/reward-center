package org.launchcode.rewardcenter.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigInteger;
import java.time.YearMonth;


@Entity
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "MY_SEQUENCE", allocationSize = 1)

public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")

    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min=1,max=15)
    private String cardName;

    @NotNull
    @Size(min=1,max=20)
    private String cardBrand;

    @NotNull
    @Size(min=16,max=17)
    private String cardNumber;

    @NotNull
    @Size(min=1,max=20)
    private String cardType;

    @NotNull
    @Size(min=1,max=15)
    private String issuedBank;

    @Column(name= "Date")
//    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private YearMonth yearMonth;

    @Transient
    private String maskCardNumber;

    //no-args constructor

    public Card() {

    }

//parameterized constructor
    public Card(@NotNull String cardName,  String cardBrand,
            String cardNumber,  String cardType,
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

    public String getCardNumber() {

        return cardNumber;
    }


    public void setCardNumber(String cardNumber) {
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

    public String getMaskCardNumber() {
        if( cardNumber!= null && !cardNumber.isEmpty()){
            int len = cardNumber.length();
            String maskCardNumber = "******" +
                    cardNumber.substring(len-4,len);

            return maskCardNumber;
        }
        return cardNumber;
    }

    public void setMaskCardNumber(String maskCardNumber) {
        this.maskCardNumber = maskCardNumber;
    }
}
