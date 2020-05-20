package com.example.crud_or_list_view.Model;

public class UserLogin {
    private Integer id;
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UserLogin(Integer id, Integer count, String email, String username, String password, String number) {
        this.id = id;
        this.count = count;
        this.email = email;
        this.username = username;
        this.password = password;
        this.number = number;
    }

    private String email;
    private String username;
    private String password;
    private String number;

}
