package com.klyukvin.numberconverter.usecases;

import com.klyukvin.numberconverter.models.Number;

// UseCase для разделения числа на состовные части
public class GetNumberUseCase {

	// Вызов UseCase
	public Number execute(String value) {
		StringBuilder number = new StringBuilder(value);
		String minus = "", dot = "", integerPart = "", fractionalPart = "";

		if (number.charAt(0) == '-') {
			minus = "-";
			number.deleteCharAt(0);
		}

		int dotIndex = number.indexOf(".");
		int commaIndex = number.indexOf(",");

		if (dotIndex != -1 || commaIndex != -1) {
			if (dotIndex != -1) {
				integerPart = number.substring(0, dotIndex);
				fractionalPart = number.substring(dotIndex + 1);
				dot = ".";
			} else {
				integerPart = number.substring(0, commaIndex);
				fractionalPart = number.substring(commaIndex + 1);
				dot = ",";
			}
		} else {
			integerPart = number.toString();
		}

		return new Number(minus, integerPart, dot, fractionalPart);
	}
}