package com.example.submitimeprezime.activities;

import com.example.submitimeprezime.R;
import com.example.submitimeprezime.utills.C;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends BaseActivity {

	private TextView mTextViewIme;
	private TextView mTextViewPrezime;

	private String firstNameFromMainActivity;
	private String lastNameFromMainActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		initUi();
		Bundle extras = getIntent().getExtras();

		if (extras != null) {
			initExtras(extras);
		}
		setTitleText();
		setTitleTextSize();
		setTitleTestTypeface();
		setTitleTextShadowLawyer();
		setTitleTextGradient();
	}

	private void setTitleTextGradient() {
		
		
		
		
	}

	@Override
	public void initUi() {
		mTextViewIme = (TextView) findViewById(R.id.activity_second_ime_textView);
		mTextViewPrezime = (TextView) findViewById(R.id.activity_second_prezime_textView);
	}

	private void initExtras(Bundle extras) {
		firstNameFromMainActivity = extras
				.getString(C.MAIN_ACTIVITY_BUNDLE_KEY_FIRST_NAME);
		lastNameFromMainActivity = extras
				.getString(C.MAIN_ACTIVITY_BUNDLE_KEY_LAST_NAME);

	}

	public void setTitleText() {

		mTextViewIme.setText(firstNameFromMainActivity);
		mTextViewPrezime.setText(lastNameFromMainActivity);

	}

	private void setTitleTextShadowLawyer() {
		mTextViewIme.setShadowLayer(2, 3, 0, Color.RED);
		mTextViewPrezime.setShadowLayer(2, 3, 0, Color.RED);

	}

	private void setTitleTestTypeface() {
		mTextViewIme.setTypeface(null, Typeface.BOLD_ITALIC);
		mTextViewPrezime.setTypeface(null, Typeface.BOLD_ITALIC);

	}

	private void setTitleTextSize() {
		mTextViewIme.setTextSize(40);
		mTextViewPrezime.setTextSize(40);

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

}
