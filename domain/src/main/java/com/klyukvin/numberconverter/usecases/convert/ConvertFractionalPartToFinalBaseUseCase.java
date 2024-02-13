package com.klyukvin.numberconverter.usecases.convert;

// UseCase для перевода дробной части в заданную систему счисления
public class ConvertFractionalPartToFinalBaseUseCase {

    // Вызов UseCase
    public String execute(double part, int base) {
        StringBuilder fractionalResult = new StringBuilder();

        while (part > 0) {
            part *= base;
            long rounded = (long) part;
            part -= rounded;

            if (rounded >= 10) {
                fractionalResult.append((char) (rounded + 55));
            } else {
                fractionalResult.append((char) (rounded + 48));
            }
        }

        return String.valueOf(fractionalResult);
    }
}