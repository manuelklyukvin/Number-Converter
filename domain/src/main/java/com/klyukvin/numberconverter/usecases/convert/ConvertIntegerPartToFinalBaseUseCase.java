package com.klyukvin.numberconverter.usecases.convert;

// UseCase для перевода целой части в заданную систему счисления
public class ConvertIntegerPartToFinalBaseUseCase {

    // Вызов UseCase
    public String execute(long part, int base) {
        StringBuilder integerResult = new StringBuilder();

        do {
            long remainder = part % base;

            if (remainder >= 10) {
                integerResult.append((char) (remainder + 55));
            } else {
                integerResult.append((char) (remainder + 48));
            }

            part /= base;
        } while (part > 0);

        return String.valueOf(integerResult.reverse());
    }
}