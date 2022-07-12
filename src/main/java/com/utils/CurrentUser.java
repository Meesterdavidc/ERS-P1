package com.utils;

public class CurrentUser {
    public static CurrentUser currentUser;
    public static Integer UserId;
    public static String First_Name;
    public static String Last_Name;
    public static String email;

    public CurrentUser(Integer UserId, String First_Name, String Last_Name, String email) {

        CurrentUser.UserId = UserId;
        CurrentUser.First_Name = First_Name;
        CurrentUser.Last_Name = Last_Name;
        CurrentUser.email = email;
    }
}
