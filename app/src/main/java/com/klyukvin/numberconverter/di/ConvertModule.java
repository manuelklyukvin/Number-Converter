package com.klyukvin.numberconverter.di;

import com.klyukvin.numberconverter.usecases.convert.ConvertFractionalPartToDecimalUseCase;
import com.klyukvin.numberconverter.usecases.convert.ConvertFractionalPartToFinalBaseUseCase;
import com.klyukvin.numberconverter.usecases.convert.ConvertIntegerPartToDecimalUseCase;
import com.klyukvin.numberconverter.usecases.convert.ConvertIntegerPartToFinalBaseUseCase;
import com.klyukvin.numberconverter.usecases.convert.ConvertNumberUseCase;

import dagger.Module;
import dagger.Provides;

// Модуль Convert
@Module
public class ConvertModule {

    // Предоставление UseCase
    @Provides
    public ConvertNumberUseCase provideConvertNumberUseCase(
        ConvertIntegerPartToDecimalUseCase convertIntegerPartToDecimalUseCase,
        ConvertFractionalPartToDecimalUseCase convertFractionalPartToDecimalUseCase,
        ConvertIntegerPartToFinalBaseUseCase convertIntegerPartToFinalBaseUseCase,
        ConvertFractionalPartToFinalBaseUseCase convertFractionalPartToFinalBaseUseCase
    ) {
        return new ConvertNumberUseCase(
            convertIntegerPartToDecimalUseCase,
            convertFractionalPartToDecimalUseCase,
            convertIntegerPartToFinalBaseUseCase,
            convertFractionalPartToFinalBaseUseCase
        );
    }

    @Provides
    public ConvertIntegerPartToDecimalUseCase provideConvertIntegerPartToDecimalUseCase() {
        return new ConvertIntegerPartToDecimalUseCase();
    }

    @Provides
    public ConvertFractionalPartToDecimalUseCase provideConvertFractionalPartToDecimalUseCase() {
        return new ConvertFractionalPartToDecimalUseCase();
    }

    @Provides
    public ConvertIntegerPartToFinalBaseUseCase provideConvertIntegerPartToFinalBaseUseCase() {
        return new ConvertIntegerPartToFinalBaseUseCase();
    }

    @Provides
    public ConvertFractionalPartToFinalBaseUseCase provideConvertFractionalPartToFinalBaseUseCase() {
        return new ConvertFractionalPartToFinalBaseUseCase();
    }
}