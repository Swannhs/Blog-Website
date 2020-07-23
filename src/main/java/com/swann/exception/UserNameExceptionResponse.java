package com.swann.exception;

public class UserNameExceptionResponse {

    private String UserName;

    public UserNameExceptionResponse(String UserName) {
        this.UserName = UserName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
