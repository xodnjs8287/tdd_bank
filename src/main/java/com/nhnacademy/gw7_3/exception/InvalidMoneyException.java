package com.nhnacademy.gw7_3.exception;

public class InvalidMoneyException extends RuntimeException {
    public InvalidMoneyException(double money) {
        super("InvalidMoneyException err : " + money);
    }
}
