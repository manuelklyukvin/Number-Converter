package com.klyukvin.numberconverter.usecases.validations;

import com.klyukvin.numberconverter.models.ValidationResult;

// UseCase для проверки существования введённого числа в системе счисления
public class IsValuePossibleUseCase {

	// Вызов UseCase
	public ValidationResult execute(String value, String base) {
		for (int c : value.toCharArray()) {
			if (c == '-' || c == '.' || c == ',') {
				continue;
			}

			if (c >= 'A') {
				c -= 55;
			} else {
				c -= 48;
			}

			if (!base.isEmpty() && c >= Integer.parseInt(base)) {
				return new ValidationResult(false, "Число невозможно в данной системе счисления");
			}
		}

		return new ValidationResult(true, "");
	}
}