package com.example.submitimeprezime3.models;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {

	private String firstNameString;
	private String lastNameString;
	private String addressString;

	public UserModel() {

	}

	private UserModel(Parcel in) {
		firstNameString = in.readString();
		lastNameString = in.readString();
		addressString = in.readString();

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

	public String getAddressString() {
		return addressString;
	}

	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}

	@Override
	public int describeContents() {

		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(firstNameString);
		dest.writeString(lastNameString);
		dest.writeString(addressString);

	}

	public static final Parcelable.Creator<UserModel> CREATOR = new Creator<UserModel>() {

		@Override
		public UserModel createFromParcel(Parcel source) {

			return new UserModel(source);
		}

		@Override
		public UserModel[] newArray(int size) {

			return new UserModel[size];
		}
	};
}
