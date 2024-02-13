package com.klyukvin.numberconverter.usecases.convert;

import static org.junit.Assert.assertEquals;

import com.klyukvin.numberconverter.models.Number;

import org.junit.Test;

// Тесты для ConvertNumberUseCase
public class ConvertNumberTest {

    // Поля для теста
    private final ConvertNumberUseCase useCase = new ConvertNumberUseCase(
        new ConvertIntegerPartToDecimalUseCase(),
        new ConvertFractionalPartToDecimalUseCase(),
        new ConvertIntegerPartToFinalBaseUseCase(),
        new ConvertFractionalPartToFinalBaseUseCase()
    );
    private Number number;
    private int initialBase, finalBase;
    private String actual, expected;

    // Тест перевода значений только из цифр
    @Test
    public void digitValueTest() {
        number = new Number("", "12", "", "");
        initialBase = 10;
        finalBase = 2;
        actual = useCase.execute(number, initialBase, finalBase);
        expected = "1100";
        assertEquals(actual, expected);

        number = new Number("", "1100", "", "");
        initialBase = 2;
        finalBase = 10;
        actual = useCase.execute(number, initialBase, finalBase);
        expected = "12";
        assertEquals(actual, expected);
    }

    // Тест перевода значений с буквами
    @Test
    public void letterValueTest() {
        number = new Number("", "A", "", "");
        initialBase = 16;
        finalBase = 2;
        actual = useCase.execute(number, initialBase, finalBase);
        expected = "1010";
        assertEquals(actual, expected);

        number = new Number("", "ACZ", "", "");
        initialBase = 36;
        finalBase = 10;
        actual = useCase.execute(number, initialBase, finalBase);
        expected = "13427";
        assertEquals(actual, expected);
    }

    // Тест перевода отрицательных значений
    @Test
    public void minusValueTest() {
        number = new Number("-", "1100", "", "");
        initialBase = 2;
        finalBase = 10;
        actual = useCase.execute(number, initialBase, finalBase);
        expected = "-12";
        assertEquals(actual, expected);

        number = new Number("-", "AC", "", "");
        initialBase = 16;
        finalBase = 10;
        actual = useCase.execute(number, initialBase, finalBase);
        expected = "-172";
        assertEquals(actual, expected);
    }

    // Тест перевода дробных значений
    @Test
    public void fractionalConvertTest() {
        number = new Number("", "1100", ".", "11");
        initialBase = 2;
        finalBase = 10;
        actual = useCase.execute(number, initialBase, finalBase);
        expected = "12.75";
        assertEquals(actual, expected);

        number = new Number("", "17", ",", "11");
        initialBase = 8;
        finalBase = 6;
        actual = useCase.execute(number, initialBase, finalBase);
        expected = "23,050213";
        assertEquals(actual, expected);

        number = new Number("", "AC", ".", "B");
        initialBase = 16;
        finalBase = 8;
        actual = useCase.execute(number, initialBase, finalBase);
        expected = "254.54";
        assertEquals(actual, expected);

        number = new Number("", "Z", ",", "3");
        initialBase = 36;
        finalBase = 12;
        actual = useCase.execute(number, initialBase, finalBase);
        expected = "2B,1";
        assertEquals(actual, expected);
    }
}