package com.hadimusthafa.apiresponseparcelable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class UserModel implements Parcelable {
    ArrayList<User> data;

    public UserModel(ArrayList<User> data) {
        this.data = data;
    }


    protected UserModel(Parcel in) {
        data = in.createTypedArrayList(User.CREATOR);
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public ArrayList<User> getData() {
        return data;
    }

    public void setData(ArrayList<User> data) {
        this.data = data;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(data);
    }
}

class User implements Parcelable {
   int id;
   String name, email, gender, status;

   public User(int id, String name, String email, String gender, String status) {
       this.id = id;
       this.name = name;
       this.email = email;
       this.gender = gender;
       this.status = status;
   }

   User() {
       // empty constructor
   }

    protected User(Parcel in) {
        id = in.readInt();
        name = in.readString();
        email = in.readString();
        gender = in.readString();
        status = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getId() {
       return id;
   }

   public void setId(int id) {
       this.id = id;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public String getEmail() {
       return email;
   }

   public void setEmail(String email) {
       this.email = email;
   }

   public String getGender() {
       return gender;
   }

   public void setGender(String gender) {
       this.gender = gender;
   }

   public String getStatus() {
       return status;
   }

   public void setStatus(String status) {
       this.status = status;
   }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(gender);
        parcel.writeString(status);
    }
}


