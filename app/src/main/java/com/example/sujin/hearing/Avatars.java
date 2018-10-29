package com.example.sujin.hearing;

public class Avatars {

    String avatarName;
    int avatarID;
    int isFav;
    int isTurned;

    public int getIsTurned(){
        return isTurned;
    }

    public void setIsturned(int isTurned){
        this.isTurned = isTurned;
    }

    public int getIsFav(){
        return isFav;
    }

    public void setIsFav(int isFav) {
        this.isFav = isFav;
    }
    public String getAvatarName() {
        return avatarName;
    }
    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }
    public int getAvatarID() {
        return avatarID;
    }
    public void setavatarID(int imageAvatarID) {
        this.avatarID = imageAvatarID;
    }
}
