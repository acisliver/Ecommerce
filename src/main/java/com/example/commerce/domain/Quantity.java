package com.example.commerce.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Quantity {

    public static final Quantity ONE = new Quantity(1);

    private final int value;

    public Quantity(int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public Quantity plus(int value) {
        return new Quantity(this.value + value);
    }

    public Quantity minus(int value) {
        return new Quantity(this.value - value);
    }
}
