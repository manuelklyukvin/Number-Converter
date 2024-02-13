package com.klyukvin.numberconverter.di;

import com.klyukvin.numberconverter.usecases.validations.IsBaseValidUseCase;
import com.klyukvin.numberconverter.usecases.validations.IsValuePossibleUseCase;
import com.klyukvin.numberconverter.usecases.validations.IsValueValidUseCase;

import dagger.Module;
import dagger.Provides;

// Модуль Validation
@Module
public class ValidationModule {

    // Предоставление UseCase
    @Provides
    public IsValueValidUseCase provideIsValueValidUseCase() {
        return new IsValueValidUseCase();
    }

    @Provides
    public IsBaseValidUseCase provideIsBaseValidUseCase() {
        return new IsBaseValidUseCase();
    }

    @Provides
    public IsValuePossibleUseCase provideIsValuePossibleUseCase() {
        return new IsValuePossibleUseCase();
    }
}