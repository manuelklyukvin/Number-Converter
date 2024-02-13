package com.klyukvin.numberconverter.di;

import android.content.Context;

import com.klyukvin.numberconverter.activities.main.MainViewModelFactory;
import com.klyukvin.numberconverter.usecases.ConvertToSmallDigitsUseCase;
import com.klyukvin.numberconverter.usecases.CopyResultUseCase;
import com.klyukvin.numberconverter.usecases.DeleteNullsUseCase;
import com.klyukvin.numberconverter.usecases.GetNumberUseCase;
import com.klyukvin.numberconverter.usecases.convert.ConvertNumberUseCase;
import com.klyukvin.numberconverter.usecases.validations.IsBaseValidUseCase;
import com.klyukvin.numberconverter.usecases.validations.IsValuePossibleUseCase;
import com.klyukvin.numberconverter.usecases.validations.IsValueValidUseCase;

import dagger.Module;
import dagger.Provides;

// Модуль App
@Module
public class AppModule {

    public AppModule(Context context) { // Конструктор для AppModule
        this.context = context;
    }

    private final Context context;

    // Предоставление контекста
    @Provides
    public Context provideContext() { // Предоставление контекста
        return context;
    }

    // Предоставление фабрики для MainViewModel
    @Provides
    public MainViewModelFactory provideMainViewModelFactory(
        IsValueValidUseCase isValueValidUseCase,
        IsBaseValidUseCase isBaseValidUseCase,
        IsValuePossibleUseCase isValuePossibleUseCase,
        DeleteNullsUseCase deleteNullsUseCase,
        GetNumberUseCase getNumberUseCase,
        ConvertNumberUseCase convertNumberUseCase,
        ConvertToSmallDigitsUseCase convertToSmallDigitsUseCase,
        CopyResultUseCase copyResultUseCase
    ) {
        return new MainViewModelFactory(
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