package com.klyukvin.numberconverter.repositories;

// Интерфейс для связывания модуля Data с модулем Domain
public interface ClipboardRepository {
    void copyToClipboard(String result);
}