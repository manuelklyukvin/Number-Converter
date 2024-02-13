package com.klyukvin.numberconverter.usecases;

import com.klyukvin.numberconverter.repositories.ClipboardRepository;

// UseCase для копирования результата перевода
public class CopyResultUseCase {

    // Конструктор
    public CopyResultUseCase(ClipboardRepository clipboardRepository) {
        this.clipboardRepository = clipboardRepository;
    }

    // Поле-Repository
    private final ClipboardRepository clipboardRepository;

    // Вызов UseCase
    public void execute(String result) {
        clipboardRepository.copyToClipboard(result);
    }
}