package com.klyukvin.numberconverter.usecases.convert;

// UseCase для перевода целой части в 10-ную систему счисления
public class ConvertIntegerPartToDecimalUseCase {

    // Вызов UseCase
    public long execute(String part, int base) {
        long decimalPart = 0;

        for (int i = 0, degree = part.length() - 1; i < part.length(); i++, degree--) {
            int c = part.charAt(i);

            if (c >= 'A') {
                c -= 55;
            } else {
                c -= 48;
            }

            c *= Math.pow(base, degree);
            decimalPart += c;
        }

        return decimalPart;
    }
}