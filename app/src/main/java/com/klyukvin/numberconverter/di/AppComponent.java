package com.klyukvin.numberconverter.di;

import com.klyukvin.numberconverter.activities.main.MainActivity;

import dagger.Component;

// Интерфейс для внедрения зависимостей
@Component(modules = {
    AppModule.class,
    DomainModule.class,
    ConvertModule.class,
    ValidationModule.class,
    DataModule.class
})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}