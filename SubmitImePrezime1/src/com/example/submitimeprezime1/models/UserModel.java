package com.example.submitimeprezime1.models;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {

	private String firstName;
	private String lastName;
	private String adress;

	public UserModel() {

	}

	private UserModel(Parcel in) {
		firstName = in.readString();
		lastName = in.readString();
		adress = in.readString();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public int describeContents() {

		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(firstName);
		dest.writeString(lastName);
		dest.writeString(adress);
	}

	public static final Parcelable.Creator<UserModel> CREATOR = new Creator<UserModel>() {

		@Override
		public UserModel[] newArray(int size) {

			return new UserModel[size];
		}

		@Override
		public UserModel createFromParcel(Parcel source) {

			return new UserModel(source);
		}
	};

}
