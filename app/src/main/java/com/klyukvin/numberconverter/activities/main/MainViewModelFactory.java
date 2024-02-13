package com.klyukvin.numberconverter.activities.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.klyukvin.numberconverter.usecases.ConvertToSmallDigitsUseCase;
import com.klyukvin.numberconverter.usecases.CopyResultUseCase;
import com.klyukvin.numberconverter.usecases.DeleteNullsUseCase;
import com.klyukvin.numberconverter.usecases.GetNumberUseCase;
import com.klyukvin.numberconverter.usecases.convert.ConvertNumberUseCase;
import com.klyukvin.numberconverter.usecases.validations.IsBaseValidUseCase;
import com.klyukvin.numberconverter.usecases.validations.IsValuePossibleUseCase;
import com.klyukvin.numberconverter.usecases.validations.IsValueValidUseCase;

// Фабрика для создания ViewModel
public class MainViewModelFactory implements ViewModelProvider.Factory {

    // UseCase-поля
    private final IsValueValidUseCase isValueValidUseCase;
    private final IsBaseValidUseCase isBaseValidUseCase;
    private final IsValuePossibleUseCase isValuePossibleUseCase;
    private final DeleteNullsUseCase deleteNullsUseCase;
    private final GetNumberUseCase getNumberUseCase;
    private final ConvertNumberUseCase convertNumberUseCase;
    private final ConvertToSmallDigitsUseCase convertToSmallDigitsUseCase;
    private final CopyResultUseCase copyResultUseCase;

    // Конструктор, принимающий UseCases
    public MainViewModelFactory(
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

    // Создание объекта ViewModel
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(
            isValueValidUseCase,
            isBaseValidUseCase,
            isValuePossibleUseCase,
            deleteNullsUseCase,
            getNumberUseCase,
            convertNumberUseCase,
            convertToSmallDigitsUseCase,
            copyResultUseCase
        );
    }
}