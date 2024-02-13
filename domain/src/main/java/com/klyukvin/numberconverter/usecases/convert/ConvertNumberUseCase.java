package com.klyukvin.numberconverter.usecases.convert;

import com.klyukvin.numberconverter.models.Number;

// UseCase для перевода числа
public class ConvertNumberUseCase {

	// Конструктор
	public ConvertNumberUseCase(
		ConvertIntegerPartToDecimalUseCase convertIntegerPartToDecimalUseCase,
		ConvertFractionalPartToDecimalUseCase convertFractionalPartToDecimalUseCase,
		ConvertIntegerPartToFinalBaseUseCase convertIntegerPartToFinalBaseUseCase,
		ConvertFractionalPartToFinalBaseUseCase convertFractionalPartToFinalBaseUseCase
	) {
		this.convertIntegerPartToDecimalUseCase = convertIntegerPartToDecimalUseCase;
		this.convertFractionalPartToDecimalUseCase = convertFractionalPartToDecimalUseCase;
		this.convertIntegerPartToFinalBaseUseCase = convertIntegerPartToFinalBaseUseCase;
		this.convertFractionalPartToFinalBaseUseCase = convertFractionalPartToFinalBaseUseCase;
	}

	// UseCase-поля
	private final ConvertIntegerPartToDecimalUseCase convertIntegerPartToDecimalUseCase;
	private final ConvertFractionalPartToDecimalUseCase convertFractionalPartToDecimalUseCase;
	private final ConvertIntegerPartToFinalBaseUseCase convertIntegerPartToFinalBaseUseCase;
	private final ConvertFractionalPartToFinalBaseUseCase convertFractionalPartToFinalBaseUseCase;

	// Вызов UseCase
	public String execute(
		Number number,
		int initialBase,
		int finalBase
	) {
		String integerPart = number.getIntegerPart();
		String fractionalPart = number.getFractionalPart();
		String minus = number.getMinus();
		String dot = number.getDot();

		if (initialBase == finalBase) {
			return minus + integerPart + dot + fractionalPart;
		}

		long decimalIntegerPart;
		double decimalFractionalPart = 0;

		if (initialBase == 10) {
			decimalIntegerPart = Long.parseLong(integerPart);

			if (!fractionalPart.isEmpty()) {
				fractionalPart = "0." + fractionalPart;
				decimalFractionalPart = Double.parseDouble(fractionalPart);
			}
		} else {
			decimalIntegerPart = convertIntegerPartToDecimalUseCase.execute(integerPart, initialBase);

			if (!fractionalPart.isEmpty()) {
				decimalFractionalPart = convertFractionalPartToDecimalUseCase.execute(fractionalPart, initialBase);
			}
		}

		String integerResult = convertIntegerPartToFinalBaseUseCase.execute(decimalIntegerPart, finalBase);
		String fractionalResult = "";

		if (!fractionalPart.isEmpty()) {
			fractionalResult = convertFractionalPartToFinalBaseUseCase.execute(decimalFractionalPart, finalBase);
		}

		if (!dot.isEmpty() && fractionalResult.isEmpty()) {
			return minus + integerResult;
		}

		return minus + integerResult + dot + fractionalResult;
	}
}