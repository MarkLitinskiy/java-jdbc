package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private Long id;
    private String userLogin;
    private String userPassword;
    private List<Chat> createdRooms;
    private List<Chat> createdRoomWhereUserSocializes;

    public User(Long id, String userLogin, String userPassword, List<Chat> createdRoomWhereUserSocializes) {
        this.id = id;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.createdRoomWhereUserSocializes = createdRoomWhereUserSocializes;
    }

    public Long getId() {
        return id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public List<Chat> getCreatedRooms() {
        return createdRooms;
    }

    public List<Chat> getCreatedRoomWhereUserSocializes() {
        return createdRoomWhereUserSocializes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setCreatedRooms(List<Chat> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public void setCreatedRoomWhereUserSocializes(List<Chat> createdRoomWhereUserSocializes) {
        this.createdRoomWhereUserSocializes = createdRoomWhereUserSocializes;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Users{" +
                "id=" + id +
                ", userLogin=" + userLogin +
                ", userPassword=" + userPassword +
                ", createdRooms=" + createdRooms +
                ", createdRoomWhereUserSocializes=" + createdRoomWhereUserSocializes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User users = (User) o;
        return id.equals(users.id) && userLogin.equals(users.userLogin) && userPassword.equals(users.userPassword) && createdRooms.equals(users.createdRooms) && createdRoomWhereUserSocializes.equals(users.createdRoomWhereUserSocializes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userLogin, userPassword, createdRooms, createdRoomWhereUserSocializes);
    }
}
