package com.klyukvin.numberconverter.usecases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// Тесты для DeleteNullsUseCase
public class DeleteNullsTest {

    // Поля для теста
    private final DeleteNullsUseCase useCase = new DeleteNullsUseCase();
    private String value, actual, excepted;

    // Тест нуля
    @Test
    public void nullTest() {
        value = "0";
        actual = useCase.execute(value);
        excepted = "0";
        assertEquals(actual, excepted);
    }

    // Тест корректного значения
    @Test
    public void validValueTest() {
        value = "28.02";
        actual = useCase.execute(value);
        excepted = "28.02";
        assertEquals(actual, excepted);

        value = "28,02";
        actual = useCase.execute(value);
        excepted = "28,02";
        assertEquals(actual, excepted);
    }

    // Тест большого значения
    @Test
    public void largeValueTest() {
        value = "28020000";
        actual = useCase.execute(value);
        excepted = "28020000";
        assertEquals(actual, excepted);
    }

    // Тест чисел с лишними нулями
    @Test
    public void nullsAtEndTest() {
        value = "280.20";
        actual = useCase.execute(value);
        excepted = "280.2";
        assertEquals(actual, excepted);

        value = "280,20";
        actual = useCase.execute(value);
        excepted = "280,2";
        assertEquals(actual, excepted);

        value = "28.020000";
        actual = useCase.execute(value);
        excepted = "28.02";
        assertEquals(actual, excepted);

        value = "28,020000";
        actual = useCase.execute(value);
        excepted = "28,02";
        assertEquals(actual, excepted);
    }

    // Тест удаления запятой
    @Test
    public void deleteDotTest() {
        value = "2802.0";
        actual = useCase.execute(value);
        excepted = "2802";
        assertEquals(actual, excepted);

        value = "2802,0";
        actual = useCase.execute(value);
        excepted = "2802";
        assertEquals(actual, excepted);

        value = "2802.0000";
        actual = useCase.execute(value);
        excepted = "2802";
        assertEquals(actual, excepted);

        value = "2802,0000";
        actual = useCase.execute(value);
        excepted = "2802";
        assertEquals(actual, excepted);
    }
}