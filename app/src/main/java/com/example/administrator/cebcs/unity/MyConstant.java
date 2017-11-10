package com.example.administrator.cebcs.unity;

/**
 * Created by ASUS on 12/9/2560.
 */

public class MyConstant {

    private String urlPostUserString = "http://androidthai.in.th/12Sep/addUserChris.php";

    private String urlgetUserString = "http://androidthai.in.th/12Sep/getAllUserChris.php";

    private String[] columnUserStrings = new String[]{"id", "idStudent",
            "Name", "Surname", "Gender", "Password"};

    public String[] getColumnUserStrings() {
        return columnUserStrings;
    }

    public String getUrlgetUserString() {
        return urlgetUserString;
    }

    public String getUrlPostUserString() {
        return urlPostUserString;
    }
}   // Main Class
