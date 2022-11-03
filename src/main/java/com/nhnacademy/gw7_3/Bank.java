package com.nhnacademy.gw7_3;

public class Bank {

    private static final double fee = 0.1;

    public double exchange(Money money) {

        if (money.getType().equals(Currency.WON)) {
            return money.getMoney() / 1000;
        }
        if (money.getType().equals(Currency.DOLLAR)) {
            return money.getMoney() * 1000;
        }
        if (money.getType().equals(Currency.EURO)) {
            return money.getMoney() / 1200;
        }

        return money.getMoney();
    }

    public double aroundWon(double money) {
        return Math.round(money / 10) * 10;
    }

    public double aroundDollar(double money) {
        return Math.ceil(money / 0.01) * 0.01;
    }

    public double chargeExchangeFee(double money) {
        return (money * this.fee);
    }

}
