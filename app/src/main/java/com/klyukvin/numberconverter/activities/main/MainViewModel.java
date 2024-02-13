package com.klyukvin.numberconverter.activities.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.klyukvin.numberconverter.models.Number;
import com.klyukvin.numberconverter.models.ValidationResult;
import com.klyukvin.numberconverter.usecases.ConvertToSmallDigitsUseCase;
import com.klyukvin.numberconverter.usecases.CopyResultUseCase;
import com.klyukvin.numberconverter.usecases.DeleteNullsUseCase;
import com.klyukvin.numberconverter.usecases.GetNumberUseCase;
import com.klyukvin.numberconverter.usecases.convert.ConvertNumberUseCase;
import com.klyukvin.numberconverter.usecases.validations.IsBaseValidUseCase;
import com.klyukvin.numberconverter.usecases.validations.IsValuePossibleUseCase;
import com.klyukvin.numberconverter.usecases.validations.IsValueValidUseCase;

// ViewModel для MainActivity
public class MainViewModel extends ViewModel {

	// Конструктор, принимающий UseCases
	public MainViewModel(
		IsValueValidUseCase isValueValidUseCase,
		IsBaseValidUseCase isBaseValidUseCase,
		IsValuePossibleUseCase isValuePossibleUseCase,
		DeleteNullsUseCase deleteNullsUseCase,
		GetNumberUseCase getNumberUseCase,
		ConvertNumberUseCase convertNumberUseCase,
		ConvertToSmallDigitsUseCase convertToSmallDigitsUseCase,
		CopyResultUseCase copyResultUseCase
	) {
		this.isValueValidUseCase = isValueValidUseCase;
		this.isBaseValidUseCase = isBaseValidUseCase;
		this.isValuePossibleUseCase = isValuePossibleUseCase;
		this.deleteNullsUseCase = deleteNullsUseCase;
		this.getNumberUseCase = getNumberUseCase;
		this.convertNumberUseCase = convertNumberUseCase;
		this.convertToSmallDigitsUseCase = convertToSmallDigitsUseCase;
		this.copyResultUseCase = copyResultUseCase;
	}

	// UseCase-поля
	private final IsValueValidUseCase isValueValidUseCase;
	private final IsBaseValidUseCase isBaseValidUseCase;
	private final IsValuePossibleUseCase isValuePossibleUseCase;
	private final DeleteNullsUseCase deleteNullsUseCase;
	private final GetNumberUseCase getNumberUseCase;
	private final ConvertNumberUseCase convertNumberUseCase;
	private final ConvertToSmallDigitsUseCase convertToSmallDigitsUseCase;
	private final CopyResultUseCase copyResultUseCase;

	// LiveData-поля, на изменения которых подписана MainActivity
	private final MutableLiveData<String> result = new MutableLiveData<>("");
	private final MutableLiveData<String> numberError = new MutableLiveData<>(null);
	private final MutableLiveData<String> initialBaseError = new MutableLiveData<>(null);
	private final MutableLiveData<String> finalBaseError = new MutableLiveData<>(null);

	// Getter-ы для LiveData-полей
	public LiveData<String> getResult() {
		return result;
	}
	public LiveData<String> getNumberError() {
		return numberError;
	}
	public LiveData<String> getInitialBaseError() {
		return initialBaseError;
	}
	public LiveData<String> getFinalBaseError() {
		return finalBaseError;
	}

	// Перевод числа
	public void convertNumber(
		String value,
		String initialBase,
		String finalBase
	) {
		// Проверка вводов
		ValidationResult isValueValid = isValueValidUseCase.execute(value);
		ValidationResult isInitialBaseValid = isBaseValidUseCase.execute(initialBase);
		ValidationResult isFinalBaseValid = isBaseValidUseCase.execute(finalBase);
		ValidationResult isValuePossible = isValuePossibleUseCase.execute(value, initialBase);

		// Обнуление LiveData-полей
		numberError.setValue(null);
		initialBaseError.setValue(null);
		finalBaseError.setValue(null);

		if (
			isValueValid.isValid()
			&& isInitialBaseValid.isValid()
			&& isFinalBaseValid.isValid()
			&& isValuePossible.isValid()
		) {
			value = deleteNullsUseCase.execute(value);
			Number number = getNumberUseCase.execute(value);
			String result = convertNumberUseCase.execute(number, Integer.parseInt(initialBase), Integer.parseInt(finalBase));

			String initialBaseSmall = convertToSmallDigitsUseCase.execute(initialBase);
			String finalBaseSmall = convertToSmallDigitsUseCase.execute(finalBase);
			this.result.setValue(value + initialBaseSmall + " = " + result + finalBaseSmall);
		} else {
			if (!isValueValid.isValid()) {
				numberError.setValue(isValueValid.getError());
			}
			if (!isValuePossible.isValid()) {
				numberError.setValue(isValuePossible.getError());
			}
			if (!isInitialBaseValid.isValid()) {
				initialBaseError.setValue(isInitialBaseValid.getError());
			}
			if (!isFinalBaseValid.isValid()) {
				finalBaseError.setValue(isFinalBaseValid.getError());
			}
		}
	}

	// Копирование ответа
	public void copyResult(String result, String toBase) {
		if (!result.isEmpty()) {
			StringBuilder answer = new StringBuilder(result.substring(result.indexOf("=") + 1));

			if (toBase.length() == 1) {
				answer.deleteCharAt(answer.length() - 1);
			} else if (toBase.length() == 2) {
				answer.delete(answer.length() - 2, answer.length());
			}

			copyResultUseCase.execute(result);
		}
	}
}