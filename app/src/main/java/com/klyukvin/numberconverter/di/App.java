package com.klyukvin.numberconverter.di;

import android.app.Application;

// Точка входа в приложение
public class App extends Application {

    // Объект интерфейса, собирающий зависимости
    private static AppComponent appComponent;
    public static AppComponent getAppComponent() {
        return appComponent;
    }

    // Внедрение зависимостей
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
            .appModule(new AppModule(this))
            .domainModule(new DomainModule())
            .convertModule(new ConvertModule())
            .validationModule(new ValidationModule())
            .dataModule(new DataModule())
            .build();
    }
}