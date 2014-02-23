package com.example.submitimeprezime1;

import com.example.submitimeprezime1.models.UserModel;
import com.example.submitimeprezime1.utils.C;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends BaseActivity {

	private TextView mTextViewName;
	private TextView mTextViewLastName;
	private TextView mTextViewAdress;

	private UserModel mUserModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		initU();
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			initExtras(extras);
		}
		setTitleText();
	}

	@Override
	public void initU() {
		mTextViewName = (TextView) findViewById(R.id.activity_second_name_textView);
		mTextViewLastName = (TextView) findViewById(R.id.activity_second_last_name_textView);
		mTextViewAdress = (TextView) findViewById(R.id.activity_second_adress_textView);
	}

	@Override
	public void initListener() {

	}

	private void initExtras(Bundle extras) {
		mUserModel = extras.getParcelable(C.MAIN_ACTIVITY_BUNDLE_KEY_USER);

	}

	public void setTitleText() {
		mTextViewName.setText(mUserModel.getFirstName());
		mTextViewLastName.setText(mUserModel.getLastName());
		mTextViewAdress.setText(mUserModel.getAdress());

	}
}
