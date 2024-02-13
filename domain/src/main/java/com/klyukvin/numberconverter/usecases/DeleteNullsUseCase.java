package com.klyukvin.numberconverter.usecases;

// UseCase для удаления нулей в конце дробной части числа
public class DeleteNullsUseCase {

    // Вызов UseCase
    public String execute(String value) {
        StringBuilder number = new StringBuilder(value);

        if (number.indexOf(".") != -1 || number.indexOf(",") != -1) {
            while (number.charAt(number.length() - 1) == '0') {
                number.deleteCharAt(number.length() - 1);

                if (number.charAt(number.length() - 1) == '.' || number.charAt(number.length() - 1) == ',') {
                    number.deleteCharAt(number.length() - 1);
                    break;
                }
            }
        }

        return number.toString();
    }
}