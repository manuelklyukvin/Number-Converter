package com.klyukvin.numberconverter.usecases;

// UseCase для уменьшения цифр систем счисления
public class ConvertToSmallDigitsUseCase {

    // Вызов UseCase
    public String execute(String value) {
        char[] smallDigits = new char[] {'₀', '₁', '₂', '₃', '₄', '₅', '₆', '₇', '₈', '₉'};
        StringBuilder result = new StringBuilder();

        for (int c : value.toCharArray()) {
            c -= 48;
            result.append(smallDigits[c]);
        }

        return result.toString();
    }
}