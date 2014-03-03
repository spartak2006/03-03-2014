package com.example.submitimeprezime3.models;

import java.util.Comparator;

public class ComparatorModel implements Comparator<UserModel> {

	@Override
	public int compare(UserModel lhs, UserModel rhs) {

		return lhs.getFirstNameString().compareTo(rhs.getFirstNameString());
	}


}
