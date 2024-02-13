package com.klyukvin.numberconverter.activities.main;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.klyukvin.numberconverter.databinding.MainActivityBinding;
import com.klyukvin.numberconverter.di.App;

import javax.inject.Inject;

// Главная activity
public class MainActivity extends AppCompatActivity {

	// Реализация паттерна MVVM
	@Inject
	MainViewModelFactory viewModelFactory;
	private MainViewModel viewModel;

	// Поля, относящиеся к вёрстке
	private MainActivityBinding binding;
	private EditText etNumber, etInitialBase, etFinalBase;
	private TextView tvResult, tvNumberError, tvInitialBaseError, tvFinalBaseError;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = MainActivityBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());

		App.getAppComponent().inject(this);
		initializeVariables();
	}

	// Инициализация полей
	private void initializeVariables() {
		etNumber = binding.etNumber;
		etInitialBase = binding.etInitialBase;
		etFinalBase = binding.etFinalBase;
		tvResult = binding.tvResult;
		tvNumberError = binding.tvNumberError;
		tvInitialBaseError = binding.tvInitialBaseError;
		tvFinalBaseError = binding.tvFinalBaseError;

		viewModel = new ViewModelProvider(this, viewModelFactory).get(MainViewModel.class);
		setupViewModelObservers();
	}

	// Подписка на LiveData-поля
	private void setupViewModelObservers() {
		viewModel.getResult().observe(this, result -> tvResult.setText(result));
		observeValidationErrors(
			viewModel.getNumberError(),
			tvNumberError
		);
		observeValidationErrors(
			viewModel.getInitialBaseError(),
			tvInitialBaseError
		);
		observeValidationErrors(
			viewModel.getFinalBaseError(),
			tvFinalBaseError
		);
	}

	// Реакция на изменение LiveData-полей, связанных с выводом ошибок
	private void observeValidationErrors(
		LiveData<String> liveData,
		TextView tvError
	) {
		liveData.observe(this, error -> {
			if (error != null) {
				tvError.setText(error);
				tvError.setVisibility(View.VISIBLE);
			} else {
				tvError.setVisibility(View.GONE);
			}
		});
	}

	// Реакция на клик по кнопке перевода
	public void onConvertButtonClicked(View view) {
		String number = etNumber.getText().toString().toUpperCase();
		String initialBase = etInitialBase.getText().toString();
		String finalBase = etFinalBase.getText().toString();

		viewModel.convertNumber(
			number,
			initialBase,
			finalBase
		);
	}

	// Реакция на клик по кнопке копирования
	public void onCopyButtonClicked(View view) {
		String result = tvResult.getText().toString();
		String finalBase = etFinalBase.getText().toString();
		viewModel.copyResult(result, finalBase);
	}
}