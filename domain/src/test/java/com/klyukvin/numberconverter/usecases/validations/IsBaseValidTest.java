package com.klyukvin.numberconverter.usecases.validations;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

// Тесты для IsBaseValidUseCase
public class IsBaseValidTest {

    // Поля для теста
    private final IsBaseValidUseCase useCase = new IsBaseValidUseCase();
    private String base;
    private boolean actual, excepted;

    // Проверка пустого значения
    @Test
    public void emptyValueTest() {
        base = "";
        actual = useCase.execute(base).isValid();
        excepted = false;
        assertEquals(actual, excepted);
    }

    // Проверка нулей
    @Test
    public void nullsTest() {
        base = "20";
        actual = useCase.execute(base).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        base = "02";
        actual = useCase.execute(base).isValid();
        excepted = false;
        assertEquals(actual, excepted);
    }

    // Проверка диапазона значений
    @Test
    public void rangeTest() {
        base = "0";
        actual = useCase.execute(base).isValid();
        excepted = false;
        assertEquals(actual, excepted);

        base = "2";
        actual = useCase.execute(base).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        base = "16";
        actual = useCase.execute(base).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        base = "36";
        actual = useCase.execute(base).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        base = "99";
        actual = useCase.execute(base).isValid();
        excepted = false;
        assertEquals(actual, excepted);
    }
}