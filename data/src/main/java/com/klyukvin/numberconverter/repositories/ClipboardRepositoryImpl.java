package com.klyukvin.numberconverter.repositories;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

// Репозиторий для сохранения ответа в буфер
public class ClipboardRepositoryImpl implements ClipboardRepository {

    // Конструктор, принимающий контекст
    public ClipboardRepositoryImpl(Context context) {
        this.context = context;
    }

    private final Context context;

    // Сохранение ответа в буфер
    @Override
    public void copyToClipboard(String result) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("", result);
        clipboard.setPrimaryClip(clip);
    }
}