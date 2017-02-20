package com.dufeng.goal.domain;

public class User {

    private String date;
    private long newUserCount;
    private long userCount;
    
    public User() {
    }

    public User(String date, long newUserCount, long userCount) {
        super();
        this.date = date;
        this.newUserCount = newUserCount;
        this.userCount = userCount;
    }

    public String getDate() {
        return date;
    }
    public long getNewUserCount() {
        return newUserCount;
    }
    public long getUserCount() {
        return userCount;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setNewUserCount(long newUserCount) {
        this.newUserCount = newUserCount;
    }
    public void setUserCount(long userCount) {
        this.userCount = userCount;
    }

    @Override
    public String toString() {
        return String.format(
                "User[date=%s, newusercount=%s, usercount=%s]",
                date, newUserCount, userCount);
    }
}
