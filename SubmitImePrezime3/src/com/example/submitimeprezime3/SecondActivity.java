package com.example.submitimeprezime3;

import com.example.submitimeprezime3.models.UserModel;
import com.example.submitimeprezime3.utils.C;

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
		setContentView(R.layout.second_activity);
		initUi();
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			initExtras(extras);

		}
		setTitleText();

	}

	@Override
	public void initUi() {
		mNameTextView = (TextView) findViewById(R.id.second_activity_name_textView);
		mLastNameTextView = (TextView) findViewById(R.id.second_activity_last_name_textView);
		mAddressTextView = (TextView) findViewById(R.id.second_activity_address_textView);

	}

	private void initExtras(Bundle extras) {
		mUserModel = extras.getParcelable(C.MAIN_ACTIVITY_BUNDLE_KEY_USER);

	}

	private void setTitleText() {
		mNameTextView.setText(mUserModel.getFirstNameString());
		mLastNameTextView.setText(mUserModel.getLastNameString());
		mAddressTextView.setText(mUserModel.getAddressString());

		mNameTextView.setTextSize(40);
		mLastNameTextView.setTextSize(40);
		mAddressTextView.setTextSize(40);

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

}
