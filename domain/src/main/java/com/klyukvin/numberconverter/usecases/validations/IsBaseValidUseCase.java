package com.klyukvin.numberconverter.usecases.validations;

import com.klyukvin.numberconverter.models.ValidationResult;

// UseCase для проверки корректности введённых систем счисления
public class IsBaseValidUseCase {

	// Вызов UseCase
	public ValidationResult execute(String base) {
		if (base.isEmpty()) {
			return new ValidationResult(false, "Введите систему счисления");
		}
		if (base.charAt(0) == '0' && base.length() > 1) {
			return new ValidationResult(false, "Система счисления не должна начинаться с нуля");
		}
		if (Integer.parseInt(base) < 2 || Integer.parseInt(base) > 36) {
			return new ValidationResult(false, "Такой системы счисления не существует");
		}
		return new ValidationResult(true, "");
	}
}