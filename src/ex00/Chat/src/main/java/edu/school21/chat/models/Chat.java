package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chat {
        private Long id;
        private String chatroomName;
        private Long chatroomOwnerId;
        private List<Message> listOfMessages;

    public Chat(Long id, String chatroomName, Long chatroomOwnerId) {
        this.id = id;
        this.chatroomName = chatroomName;
        this.chatroomOwnerId = chatroomOwnerId;
    }

    public Long getId() {
        return id;
    }

    public String getChatroomName() {
        return chatroomName;
    }

    public Long getChatroomOwnerId() {
        return chatroomOwnerId;
    }

    public List<Message> getListOfMessages() {
        return listOfMessages;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setChatroomName(String chatroomName) {
        this.chatroomName = chatroomName;
    }

    public void setChatroomOwnerId(Long chatroomOwnerId) {
        this.chatroomOwnerId = chatroomOwnerId;
    }

    public void setListOfMessages(List<Message> listOfMessages) {
        this.listOfMessages = listOfMessages;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", chatroomName='" + chatroomName + '\'' +
                ", chatroomOwnerId=" + chatroomOwnerId +
                ", listOfMessages=" + listOfMessages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return id.equals(chat.id) && chatroomName.equals(chat.chatroomName) && chatroomOwnerId.equals(chat.chatroomOwnerId) && Objects.equals(listOfMessages, chat.listOfMessages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatroomName, chatroomOwnerId, listOfMessages);
    }
}
