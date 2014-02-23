package com.example.submitimeprezime2;

import com.example.submitimeprezime2.models.UserModel;
import com.example.submitimeprezime2.utils.C;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends BaseActivity {

	private TextView mNameTextView;
	private TextView mLastNameTextView;
	private TextView mAddressTextView;

	private UserModel mUserModel;

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
	}

	@Override
	public void initUi() {
		mNameTextView = (TextView) findViewById(R.id.activity_second_name_textView);
		mLastNameTextView = (TextView) findViewById(R.id.activity_second_last_name_textView);
		mAddressTextView = (TextView) findViewById(R.id.activity_second_adress_textView);

	}

	private void initExtras(Bundle extras) {
		mUserModel = extras
				.getParcelable(C.MAIN_ACTIVITY_BUNDLE_KEY_USER_STRING);

	}

	private void setTitleText() {
		mNameTextView.setText(mUserModel.getFirstNameString());
		mLastNameTextView.setText(mUserModel.getLastNameString());
		mAddressTextView.setText(mUserModel.getAddress());

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

}
