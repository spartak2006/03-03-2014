package com.example.submitimeprezime3;

import com.example.submitimeprezime3.models.UserModel;
import com.example.submitimeprezime3.utils.C;

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

public class MainActivity extends BaseActivity {

	private EditText mInputNameEditText;
	private EditText mInputLastNameEditText;
	private EditText mInputAddressEditText;

	private Button mSubmitButton;
	private Button mClearButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initUi();
		initListener();

	}

	public void initUi() {
		mInputNameEditText = (EditText) findViewById(R.id.activity_main_name_editText);
		mInputLastNameEditText = (EditText) findViewById(R.id.activity_main_last_name_editText);
		mInputAddressEditText = (EditText) findViewById(R.id.activity_main_address_editText);

		mSubmitButton = (Button) findViewById(R.id.activity_main_submit_button);
		mClearButton = (Button) findViewById(R.id.activity_main_clear_button);
	}

	public void initListener() {
		mSubmitButton.setOnClickListener(mOnClickListener);
		mClearButton.setOnClickListener(mOnClickListener);

	}

	private OnClickListener mOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.activity_main_submit_button:
				String tempName = mInputNameEditText.getText().toString();
				String tempLastName = mInputLastNameEditText.getText()
						.toString();
				String tempAddress = mInputAddressEditText.getText().toString();

				if (tempName.equals("") && tempLastName.equals("")
						&& tempAddress.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Unesite Ime Prezime i Adresu!", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();

				} else if (tempLastName.equals("") && tempAddress.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Unesite Prezime i Adresu!", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();

				} else if (tempName.equals("") && tempAddress.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Unesite Ime i Adresu!", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();

				} else if (tempName.equals("") && tempLastName.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Unesite Ime i Prezime!", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();

				} else if (tempName.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Unesite Ime!", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();

				} else if (tempLastName.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Unesite Prezime!", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();
				} else if (tempAddress.equals("")) {
					Toast toast = Toast.makeText(MainActivity.this,
							"Unesite Adresu!", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();

				} else {
					startSecondActivity(tempName, tempLastName, tempAddress);
				}

				break;
			case R.id.activity_main_clear_button:
				mInputNameEditText.setText("");
				mInputLastNameEditText.setText("");
				mInputAddressEditText.setText("");

			}
		}

		private void startSecondActivity(String tempName, String tempLastName,
				String tempAddress) {
			Intent intent = new Intent(MainActivity.this, SecondActivity.class);
			UserModel model = new UserModel();
			model.setFirstNameString(tempName);
			model.setLastNameString(tempLastName);
			model.setAddressString(tempAddress);
			intent.putExtra(C.MAIN_ACTIVITY_BUNDLE_KEY_USER, model);
			startActivity(intent);
		}
	};
}
