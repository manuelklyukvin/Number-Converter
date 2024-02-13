package com.klyukvin.numberconverter.usecases.validations;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

// Тесты для IsValuePossibleUseCase
public class IsValuePossibleTest {

    // Поля для теста
    private final IsValuePossibleUseCase useCase = new IsValuePossibleUseCase();
    private String value, base;
    private boolean actual, excepted;

    // Тест корретного значения
    @Test
    public void validValueTest() {
        value = "2802";
        base = "10";
        actual = useCase.execute(value, base).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        value = "1";
        base = "2";
        actual = useCase.execute(value, base).isValid();
        excepted = true;
        assertEquals(actual, excepted);
    }

    // Тест граничных значений
    @Test
    public void edgeValueTest() {
        value = "2";
        base = "2";
        actual = useCase.execute(value, base).isValid();
        excepted = false;
        assertEquals(actual, excepted);

        value = "A";
        base = "10";
        actual = useCase.execute(value, base).isValid();
        excepted = false;
        assertEquals(actual, excepted);

        value = "A";
        base = "11";
        actual = useCase.execute(value, base).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        value = "Z";
        base = "35";
        actual = useCase.execute(value, base).isValid();
        excepted = false;
        assertEquals(actual, excepted);

        value = "Z";
        base = "36";
        actual = useCase.execute(value, base).isValid();
        excepted = true;
        assertEquals(actual, excepted);
    }
}