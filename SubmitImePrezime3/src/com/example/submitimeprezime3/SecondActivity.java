package com.example.submitimeprezime3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.example.submitimeprezime3.models.ComparatorModel;
import com.example.submitimeprezime3.models.UserModel;
import com.example.submitimeprezime3.utils.C;

import android.R.integer;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends BaseActivity {

	private LinearLayout mLinearLayout;

	private ArrayList<UserModel> mUserModel;

	private ComparatorModel mCompare;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);

		Intent intent = getIntent();
		if (intent != null) {

			initExtras(intent);

		}
		compareUsers();

	}

	private void compareUsers() {

		Collections.sort(mUserModel, new ComparatorModel());
	}

	@Override
	public void initUi() {

		mLinearLayout = (LinearLayout) findViewById(R.id.activity_second_linear_layout_one);

	}

	private void initExtras(Intent intent) {
		mUserModel = intent
				.getParcelableArrayListExtra(C.MAIN_ACTIVITY_BUNDLE_KEY_USER);

	}

	private void setTitleText() {

		for (int i = 0; i < mUserModel.size(); i++) {

			tryGetUserModelFromPositionAndShow(i);
		}

	}

	private void tryGetUserModelFromPositionAndShow(int i) {
		try {
			UserModel firstModel = mUserModel.get(mUserModel.size());
			TextView newTextView = createNewTextViewWithUserModel();
			newTextView.setText(firstModel.getFirstNameString() + "\n"
					+ firstModel.getLastNameString() + "\n"
					+ firstModel.getAddressString());
			mLinearLayout.addView(newTextView);

		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private TextView createNewTextViewWithUserModel() {

		final LayoutParams lparams = new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		final TextView textView = new TextView(this);

		textView.setLayoutParams(lparams);
		return textView;
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

}
