package com.example.submitimeprezime3;

import java.util.ArrayList;

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
	private Button mAddButton;

	private ArrayList<UserModel> mUsers = new ArrayList<UserModel>();

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
		mAddButton = (Button) findViewById(R.id.activity_main_add_button);
	}

	public void initListener() {
		mSubmitButton.setOnClickListener(mOnClickListener);
		mClearButton.setOnClickListener(mOnClickListener);
		mAddButton.setOnClickListener(mOnClickListener);
	}

	private OnClickListener mOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.activity_main_submit_button:

				startSecondActivity();

				break;
			case R.id.activity_main_clear_button:

				clearEditTextUser();
				break;
			case R.id.activity_main_add_button:
				String firstName = mInputNameEditText.getText().toString();
				String lastName = mInputLastNameEditText.getText().toString();
				String address = mInputAddressEditText.getText().toString();
				UserModel user = createUser(firstName, lastName, address);
				addUserToUserList(user);

				Toast.makeText(MainActivity.this,
						"Trenutno u listi ima: " + mUsers.size(),
						Toast.LENGTH_LONG).show();
				clearEditTextUser();
				break;
			}
		}

		private void clearEditTextUser() {
			mInputNameEditText.setText("");
			mInputLastNameEditText.setText("");
			mInputAddressEditText.setText("");

		}

		private void addUserToUserList(UserModel user) {
			mUsers.add(user);
		}

		private UserModel createUser(String firstName, String lastName,
				String address) {
			UserModel model = new UserModel();
			model.setFirstNameString(firstName);
			model.setLastNameString(lastName);
			model.setAddressString(address);

			return model;

		}

		private void startSecondActivity() {
			Intent intent = new Intent(MainActivity.this, SecondActivity.class);

			intent.putExtra(C.MAIN_ACTIVITY_BUNDLE_KEY_USER, mUsers);
			startActivity(intent);
		}
	};
}
