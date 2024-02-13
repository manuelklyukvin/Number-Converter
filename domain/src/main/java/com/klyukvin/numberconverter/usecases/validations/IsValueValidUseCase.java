package com.klyukvin.numberconverter.usecases.validations;

import com.klyukvin.numberconverter.models.ValidationResult;

// UseCase для проверки корректности введённого числа
public class IsValueValidUseCase {

	// Вызов UseCase
	public ValidationResult execute(String value) {
		if (value.lastIndexOf('-') > 0) {
			return new ValidationResult(false, "Некорректное число");
		} else if (value.lastIndexOf('-') == 0) {
			value = value.substring(1);
		}

		if (value.isEmpty()) {
			return new ValidationResult(false, "Введите число");
		}

		int dotIndex = value.indexOf('.');
		int commaIndex = value.indexOf(',');
		if (dotIndex != -1 || commaIndex != -1) {
			if (dotIndex == 0 || commaIndex == 0 || dotIndex == value.length() - 1 || commaIndex == value.length() - 1) {
				return new ValidationResult(false, "Некорректное число");
			}
			if (dotIndex != -1 && commaIndex != -1) {
				return new ValidationResult(false, "Число может содержать только одну точку/запятую");
			}
			if (dotIndex != value.lastIndexOf('.') || commaIndex != value.lastIndexOf(',')) {
				return new ValidationResult(false, "Число может содержать только одну точку/запятую");
			}
		}
		if (value.charAt(0) == '0' && value.length() > 1 && value.charAt(1) != '.' && value.charAt(1) != ',') {
			return new ValidationResult(false, "Число не может начинаться с нуля");
		}

		for (char c : value.toCharArray()) {
			if (!isCharacterValid(c)) {
				return new ValidationResult(false, "Некорректное число");
			}
		}

		return new ValidationResult(true, "");
	}

	// Метод, проверяющий допустимость символа
	private boolean isCharacterValid(char c) {
		return Character.isDigit(c) || Character.isAlphabetic(c) || c == '-' || c == '.' || c == ',';
	}
}