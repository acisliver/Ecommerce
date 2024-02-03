package com.example.commerce.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class QuantityTest {

    @DisplayName("Quantity의 value가 같다면 같은 객체이다")
    @Test
    void givenSameValue_whenEqualsAndHashCode_thenSameInstance() {
        int value = 10;
        Quantity q1 = new Quantity(value);
        Quantity q2 = new Quantity(value);

        assertThat(q1.equals(q2)).isTrue();
        assertThat(q1.hashCode() == q2.hashCode()).isTrue();
    }

    @DisplayName("Quantity가 음수라면 예외가 발생한다")
    @Test
    void givenNegativeValue_whenInitialize_thenThrowException() {
        assertThatThrownBy(() -> new Quantity(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Quantity를 주어진 크기만큼 늘려 새로운 Quantity를 만들 수 있다")
    @Test
    void givenValue_whenPlusQuantity_thenNewQuantity() {
        Quantity quantity = new Quantity(10);
        int value = 3;

        Quantity newQuantity = quantity.plus(value);

        assertThat(newQuantity.getValue()).isEqualTo(quantity.getValue() + value);
    }

    @DisplayName("Quantity를 주어진 크기만큼 줄여 새로운 Quantity를 만들 수 있다")
    @Test
    void givenValue_whenMinusQuantity_thenNewQuantity() {
        Quantity quantity = new Quantity(10);
        int value = 3;

        Quantity newQuantity = quantity.minus(value);

        assertThat(newQuantity.getValue()).isEqualTo(quantity.getValue() - value);
    }

    @DisplayName("Quantity를 0보다 작게 줄일 수 없다")
    @Test
    void givenValue_whenMinusQuantity_thenThrowException() {
        Quantity quantity = new Quantity(10);
        int value = 13;

        assertThatThrownBy(() -> quantity.minus(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
