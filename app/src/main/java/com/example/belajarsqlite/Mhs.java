package com.example.belajarsqlite;

import android.os.Parcel;
import android.os.Parcelable;

public class Mhs implements Parcelable {

    int id;
    String nama ;
    String nim ;
    String noHp ;

    public Mhs(int id, String nama, String nim, String noHp) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.noHp = noHp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {

        return this.nama;
    }

    public void setNama(String nama) {

        this.nama = nama;
    }

    public String getNim() {

        return this.nim;
    }

    public void setNim(String nim) {

        this.nim = nim;
    }

    public String getNoHp() {

        return this.noHp;
    }

    public void setNohp(String noHp) {

        this.noHp = noHp;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nama);
        dest.writeString(this.nim);
        dest.writeString(this.noHp);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.nama = source.readString();
        this.nim = source.readString();
        this.noHp = source.readString();
    }

    protected Mhs(Parcel in) {
        this.id = in.readInt();
        this.nama = in.readString();
        this.nim = in.readString();
        this.noHp = in.readString();
    }

    public static final Creator<Mhs> CREATOR = new Creator<Mhs>() {
        @Override
        public Mhs createFromParcel(Parcel source) {
            return new Mhs(source);
        }

        @Override
        public Mhs[] newArray(int size) {
            return new Mhs[size];
        }
    };
}
