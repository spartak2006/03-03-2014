package com.example.submitimeprezime.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.submitimeprezime.R;
import com.example.submitimeprezime.utills.C;

public class MainActivity extends BaseActivity {

	private EditText mInputEditTextIme;
	private EditText mInputEditTextPrezime;
	private Button mSubmitButton;
	private Button mCancelButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initUi();
		initListener();

	}

	@Override
	public void initListener() {

		mSubmitButton.setOnClickListener(mClickListener);
		mCancelButton.setOnClickListener(mClickListener);

	}

	@Override
	public void initUi() {
		mInputEditTextIme = (EditText) findViewById(R.id.activity_main_ime_editText);
		mInputEditTextPrezime = (EditText) findViewById(R.id.activity_main_prezime_editText);

		mSubmitButton = (Button) findViewById(R.id.activity_main_submit_button);
		mCancelButton = (Button) findViewById(R.id.activity_main_cancel_button);

	}

	private OnClickListener mClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.activity_main_submit_button:
				String tempIme = mInputEditTextIme.getText().toString();
				String tempPrezime = mInputEditTextPrezime.getText().toString();

				if (tempIme.equals("") && tempPrezime.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Niste unjeli Ime i Prezime!", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();
				} else if (tempIme.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Niste unjeli Ime!", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();
				} else if (tempPrezime.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Niste unjeli Prezime!", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();

				} else

					startSecondActivity(tempIme, tempPrezime);

				break;

			case R.id.activity_main_cancel_button:
				mInputEditTextIme.setText("");
				mInputEditTextPrezime.setText("");

				break;

			}
		}
	};

	private void startSecondActivity(String tempIme, String tempPrezime) {

		Intent intent = new Intent(this, SecondActivity.class);

		intent.putExtra(C.MAIN_ACTIVITY_BUNDLE_KEY_FIRST_NAME, tempIme);
		intent.putExtra(C.MAIN_ACTIVITY_BUNDLE_KEY_LAST_NAME, tempPrezime);
		startActivity(intent);
	}
}
