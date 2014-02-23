package com.example.submitimeprezime1;

import com.example.submitimeprezime1.models.UserModel;
import com.example.submitimeprezime1.utils.C;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText mInputEditTextName;
	private EditText mInputEditTextLastName;
	private EditText mInputEditTextAdress;

	private Button mSubmitButton;
	private Button mClearButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initUi();
		initListener();
	}

	private void initListener() {

		mSubmitButton.setOnClickListener(mClickListener);
		mClearButton.setOnClickListener(mClickListener);

	}

	private void initUi() {

		mInputEditTextName = (EditText) findViewById(R.id.activity_main_name_editText);
		mInputEditTextLastName = (EditText) findViewById(R.id.activity_main_last_name_editText);
		mInputEditTextAdress = (EditText) findViewById(R.id.activity_main_adress_editText);

		mSubmitButton = (Button) findViewById(R.id.activity_main_submit_button);
		mClearButton = (Button) findViewById(R.id.activity_main_clear_button);

	}

	private OnClickListener mClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.activity_main_submit_button:
				String tempName = mInputEditTextName.getText().toString();
				String tempLastName = mInputEditTextLastName.getText()
						.toString();
				String tempAdressString = mInputEditTextAdress.getText()
						.toString();

				if (tempName.equals("") && tempLastName.equals("")
						&& tempAdressString.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Niste unijeli Ime, Prezime i Adresu!",
							Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();

				} else if (tempLastName.equals("")
						&& tempAdressString.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Niste unijeli Prezime i Adresu!",
							Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();

				} else if (tempName.equals("") && tempLastName.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Niste unijeli Ime i Prezime!", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();

				} else if (tempName.equals("") && tempAdressString.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Niste unijeli Ime i Adresu!", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();

				} else if (tempLastName.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Niste unijeli Prezime!", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();

				} else if (tempName.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Niste unijeli Ime!", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();

				} else if (tempAdressString.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Niste unijeli Adresu!", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();

				} else {
					startSecondActivity(tempName, tempLastName,
							tempAdressString);
				}
				break;
			case R.id.activity_main_clear_button:
				mInputEditTextName.setText("");
				mInputEditTextLastName.setText("");
				mInputEditTextAdress.setText("");

			}
		}

		private void startSecondActivity(String tempName, String tepmLastName,
				String tempAdress) {
			Intent intent = new Intent(MainActivity.this, SecondActivity.class);
			UserModel model = new UserModel();
			model.setFirstName(tempName);
			model.setLastName(tepmLastName);
			model.setAdress(tempAdress);
			intent.putExtra(C.MAIN_ACTIVITY_BUNDLE_KEY_USER, model);
			startActivity(intent);
		}
	};
}
