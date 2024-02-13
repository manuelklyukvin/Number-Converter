package com.klyukvin.numberconverter.models;

// Модель, для разделения числа на составные части
public class Number {

	// Конструктор
	public Number(
		String minus,
		String integerPart,
		String dot,
		String fractionalPart
	) {
		this.minus = minus;
		this.integerPart = integerPart;
		this.dot = dot;
		this.fractionalPart = fractionalPart;
	}

	// Поля, содержащие значения частей числа
	private final String minus, integerPart, dot, fractionalPart;

	// Getter-ы
	public String getMinus() {
		return minus;
	}
	public String getIntegerPart() {
		return integerPart;
	}
	public String getDot() {
		return dot;
	}
	public String getFractionalPart() {
		return fractionalPart;
	}
}