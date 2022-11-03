package com.nhnacademy.gw7_3;

import com.nhnacademy.gw7_3.exception.DifferentMoneyTypeException;
import com.nhnacademy.gw7_3.exception.InvalidMoneyException;


public class Money {
    private double money;

    public Currency type;

    public Money(double money) {
        if (money < 0) {
            throw new InvalidMoneyException(money);
        }
        this.money = money;
    }

    public double add(Money money) {
        if (money.getType() != this.getType()) {
            throw new DifferentMoneyTypeException();
        }
        this.money += money.money;

//        return Math.round(this.money * 100) / 100.0;
        return this.money;
    }

    public double minus(Money money) {
        this.money -= money.money;
        if (this.money < 0) {
            throw new InvalidMoneyException(this.money);
        }

        return this.money;
    }

    public boolean equals(Money money) {
        if (this.money == money.money && this.type.equals(money.type)) {
            return true;
        }
        return false;
    }

    public double getMoney() {
        return this.money;
    }

    public Currency getType() {
        return this.type;
    }



}
