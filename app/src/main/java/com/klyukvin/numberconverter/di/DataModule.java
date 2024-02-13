package com.klyukvin.numberconverter.di;

import android.content.Context;

import com.klyukvin.numberconverter.repositories.ClipboardRepository;
import com.klyukvin.numberconverter.repositories.ClipboardRepositoryImpl;

import dagger.Module;
import dagger.Provides;

// Модуль Data
@Module
public class DataModule {

    // Предоставление репозитория
    @Provides
    public ClipboardRepository provideClipboardRepositoryImpl(Context context) {
        return new ClipboardRepositoryImpl(context);
    }
}