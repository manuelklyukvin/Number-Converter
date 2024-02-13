package com.klyukvin.numberconverter.usecases.convert;

// UseCase для перевода дробной части в 10-ную систему счисления
public class ConvertFractionalPartToDecimalUseCase {

    // Вызов UseCase
    public double execute(String part, int base) {
        double decimalPart = 0;

        for (int i = 0, degree = -1; i < part.length(); i++, degree--) {
            double c = part.charAt(i);

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