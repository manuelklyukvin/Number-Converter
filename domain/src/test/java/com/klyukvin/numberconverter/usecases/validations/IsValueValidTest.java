package com.klyukvin.numberconverter.usecases.validations;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

// Тесты для IsValueValidUseCase
public class IsValueValidTest {

    // Поля для теста
    private final IsValueValidUseCase isValueValidUseCase = new IsValueValidUseCase();
    private String value;
    private boolean actual, excepted;

    // Проверка пустого ввода
    @Test
    public void emptyValueTest() {
        value = "2802";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        value = "";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = false;
        assertEquals(actual, excepted);
    }

    // Проверка ввода минусов
    @Test
    public void minusValueTest() {
        value = "-2802";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        value = "-";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = false;
        assertEquals(actual, excepted);

        value = "28-02";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = false;
        assertEquals(actual, excepted);

        value = "-2802-";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = false;
        assertEquals(actual, excepted);
    }

    // Проверка ввода точек и запятых
    @Test
    public void dotValueTest() {
        value = "280.2";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        value = "280,2";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        value = ".2802";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = false;
        assertEquals(actual, excepted);

        value = ",2802";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = false;
        assertEquals(actual, excepted);

        value = "2802.";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = false;
        assertEquals(actual, excepted);

        value = "2802,";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = false;
        assertEquals(actual, excepted);

        value = "28..02";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = false;
        assertEquals(actual, excepted);

        value = "28,,02";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = false;
        assertEquals(actual, excepted);

        value = "28.0,2";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = false;
        assertEquals(actual, excepted);
    }

    // Проверка ввода нулей
    @Test
    public void nullValueTest() {
        value = "0.2802";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        value = "0,2802";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        value = "02802";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = false;
        assertEquals(actual, excepted);

        value = "00.2802";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = false;
        assertEquals(actual, excepted);

        value = "00,2802";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = false;
        assertEquals(actual, excepted);
    }

    // Проверка ввода символов помимо цифр
    @Test
    public void characterValueTest() {
        value = "A";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        value = "Z";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        value = "A.1";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        value = "A,1";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        value = "9.Z";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        value = "9,Z";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = true;
        assertEquals(actual, excepted);

        value = "A Z";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = false;
        assertEquals(actual, excepted);

        value = "+";
        actual = isValueValidUseCase.execute(value).isValid();
        excepted = false;
        assertEquals(actual, excepted);
    }
}