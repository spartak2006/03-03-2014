package com.example.submitimeprezime2.models;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {

	private String firstNameString;
	private String lastNameString;
	private String address;

	public UserModel() {

	}

	private UserModel(Parcel in) {

		firstNameString = in.readString();
		lastNameString = in.readString();
		address = in.readString();

	}

	public String getFirstNameString() {
		return firstNameString;
	}

	public void setFirstNameString(String firstNameString) {
		this.firstNameString = firstNameString;
	}

	public String getLastNameString() {
		return lastNameString;
	}

	public void setLastNameString(String lastNameString) {
		this.lastNameString = lastNameString;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int describeContents() {

		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(firstNameString);
		dest.writeString(lastNameString);
		dest.writeString(address);

	}

	public static final Parcelable.Creator<UserModel> CREATOR = new Creator<UserModel>() {

		@Override
		public UserModel[] newArray(int size) {

			return new UserModel[size];
		}

		@Override
		public UserModel createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new UserModel(source);
		}
	};
}
