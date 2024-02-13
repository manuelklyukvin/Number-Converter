package com.klyukvin.numberconverter.di;

import com.klyukvin.numberconverter.repositories.ClipboardRepository;
import com.klyukvin.numberconverter.usecases.ConvertToSmallDigitsUseCase;
import com.klyukvin.numberconverter.usecases.CopyResultUseCase;
import com.klyukvin.numberconverter.usecases.DeleteNullsUseCase;
import com.klyukvin.numberconverter.usecases.GetNumberUseCase;

import dagger.Module;
import dagger.Provides;

// Модуль Domain
@Module
public class DomainModule {

    // Предоставление UseCase
    @Provides
    public DeleteNullsUseCase provideDeleteNullsUseCase() {
        return new DeleteNullsUseCase();
    }

    @Provides
    public GetNumberUseCase provideGetNumberUseCase() {
        return new GetNumberUseCase();
    }

    @Provides
    public ConvertToSmallDigitsUseCase provideConvertToSmallDigitsUseCase() {
        return new ConvertToSmallDigitsUseCase();
    }

    @Provides
    public CopyResultUseCase provideCopyResultUseCase(ClipboardRepository clipboardRepository) {
        return new CopyResultUseCase(clipboardRepository);
    }
}