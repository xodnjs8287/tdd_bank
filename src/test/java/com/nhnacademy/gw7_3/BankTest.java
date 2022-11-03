package com.nhnacademy.gw7_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BankTest {

    @Test
    @DisplayName("통화는 달러화와 원화만이 존재, 환율은 1000원 -> 1달러")
    void Bank_ExchangeWon_Through_Bank() {
        Bank bank = new Bank();
        Money money = new Money(1000);
        money.type = Currency.WON;

        assertThat(bank.exchange(money)).isEqualTo(1);
    }

    @Test
    @DisplayName("통화는 달러화와 원화만이 존재, 환율은 1달러-> 1000원")
    void Bank_ExchangeDollar_Through_Bank() {
        Bank bank = new Bank();
        Money money = new Money(1);
        money.type = Currency.DOLLAR;

        assertThat(bank.exchange(money)).isEqualTo(1000);
    }


    @Test
    @DisplayName("5.25$ -> 5250원")
    void Bank_ExchangeDecimalDollarToWon_Through_Bank() {
        Bank bank = new Bank();
        Money money = new Money(5.25);
        money.type = Currency.DOLLAR;

        assertThat(bank.exchange(money)).isEqualTo(5250);
    }

    @Test
    @DisplayName("달러 -> 원화: 5원 이상 -> 10원으로 반올림")
    void Bank_AroundMoney_DollarToWon() {
        Bank bank = new Bank();
        Money money = new Money(0.005);
        money.type = Currency.DOLLAR;

        double exchange = bank.exchange(money);

        assertThat(bank.aroundWon(exchange)).isEqualTo(10);
    }

    @Test
    @DisplayName("원화 -> 달러 : 0.005원 이상 -> 0.01원으로 반올림")
    void Bank_AroundMoney_WonToDollar() {
        Bank bank = new Bank();
        Money money = new Money(500);
        money.type = Currency.WON;

        double exchange = bank.exchange(money);

        assertThat(bank.aroundDollar(exchange)).isEqualTo(0.5);
    }

    @Test
    @DisplayName(" 환전 수수료 부과")
    void chargeExchangeFee() {
       Bank bank = new Bank();
       Money money = new Money(500);
       money.type = Currency.DOLLAR;


        double v = bank.aroundDollar(bank.chargeExchangeFee(money.getMoney()));
        assertThat(v).isEqualTo(50);
    }


}
