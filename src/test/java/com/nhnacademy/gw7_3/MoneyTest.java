package com.nhnacademy.gw7_3;

import com.nhnacademy.gw7_3.exception.DifferentMoneyTypeException;
import com.nhnacademy.gw7_3.exception.InvalidMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class MoneyTest {


    @Test
    @DisplayName("1000원 + 1000원 = 2000원")
    void Money_currencyWonAddTest() {
        Money money1 = new Money(1000);
        money1.type = Currency.WON;
        Money money2 = new Money(1000);
        money2.type = Currency.WON;

        assertThat(money1.add(money2)).isEqualTo(2000);

    }

    @Test
    @DisplayName("다른 타입 Money 더하기 체크")
    void Money_DifferentCurrencyTypeCheck(){
        Money money1 = new Money(1000);
        money1.type = Currency.WON;
        Money money2 = new Money(5);
        money2.type = Currency.DOLLAR;

        assertThatThrownBy(() -> money1.add(money2))
                .isInstanceOf(DifferentMoneyTypeException.class)
                .hasMessageContaining("differentMoneyException err");

    }



    @Test
    @DisplayName("2000원과 2000원은 타입,Amount 같다(equals)")
    void Money_currencyWonEqualsTest() {
        Money money1 = new Money(1000);
        money1.type = Currency.WON;
        Money money2 = new Money(1000);
        money2.type = Currency.WON;

        assertThat(money1.equals(money2)).isEqualTo(true);
    }


    @Test
    @DisplayName("돈은 음수일 수 없다")
    void Money_invalidWonMoney_thenThrowInvalidWonMoneyException() {

        assertThatThrownBy(() -> new Money(-1000))
                .isInstanceOf(InvalidMoneyException.class)
                .hasMessageContaining("InvalidMoneyException err : ");
    }

    @Test
    @DisplayName("5$+5$=10$")
    void Money_CurrencyDollarAddTest() {
        Money money1 = new Money(5);
        money1.type = Currency.DOLLAR;
        Money money2 = new Money(5);
        money2.type = Currency.DOLLAR;

        assertThat(money1.add(money2)).isEqualTo(10);
    }

    @Test
    @DisplayName("5$ - 6$ = 오류")
    void Money_invalidDollarMoney_thenThrowInvalidDollarMoneyException() {
        Money money1 = new Money(5);
        money1.type = Currency.DOLLAR;
        Money money2 = new Money(6);
        money2.type = Currency.DOLLAR;


        assertThatThrownBy(() -> money1.minus(money2))
                .isInstanceOf(InvalidMoneyException.class)
                .hasMessageContaining("InvalidMoneyException err : ");
    }

    @Test
    @DisplayName("5.25$ + 5.25$ = 10.50$")
    void Money_addMoney_twoDecimal_places(){
        Money money1 = new Money(5.25);
        Money money2 = new Money(5.25);

        assertThat(money1.add(money2)).isEqualTo(10.50);

    }


}
