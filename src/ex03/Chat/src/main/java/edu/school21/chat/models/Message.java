package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private Long id;
    private Long authorId;
    private Long roomId;
    private String messageText;
    private LocalDateTime dataTime;

    public Message(Long id, Long authorId, Long roomId, String messageText, LocalDateTime dataTime) {
        this.id = id;
        this.authorId = authorId;
        this.roomId = roomId;
        this.messageText = messageText;
        this.dataTime = dataTime;
    }

    public Long getId() {
        return id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public String getMessageText() {
        return messageText;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setDataTime(LocalDateTime dataTime) {
        this.dataTime = dataTime;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", roomId=" + roomId +
                ", messageText='" + messageText + '\'' +
                ", dataTime='" + dataTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id.equals(message.id) && authorId.equals(message.authorId) && roomId.equals(message.roomId) && Objects.equals(messageText, message.messageText) && dataTime.equals(message.dataTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorId, roomId, messageText, dataTime);
    }
}
