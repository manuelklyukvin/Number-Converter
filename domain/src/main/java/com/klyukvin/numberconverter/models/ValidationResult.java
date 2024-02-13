package com.klyukvin.numberconverter.models;

// Модель, содержащая в себе результат проверки и сообщение об ошибке
public class ValidationResult {

	// Конструктор
	public ValidationResult(
		boolean isValid,
		String error
	) {
		this.isValid = isValid;
		this.error = error;
	}

	// Поля
	private final boolean isValid;
	private final String error;

	// Getter-ы
	public boolean isValid() {
		return isValid;
	}
	public String getError() {
		return error;
	}
}