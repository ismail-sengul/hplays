package com.oyuneticaret.model;

import org.springframework.core.SpringVersion;

import javax.persistence.*;

@Entity
@Table(name = "MESSAGE_USER_TO_USER")
public class MessageUserToUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SENDER_ID" , referencedColumnName = "ID")
    private User senderUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RECEIVER_ID" , referencedColumnName = "ID")
    private User receiverUser;

    @Column(name = "MESSAGE")
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSenderUser() {
        return senderUser;
    }

    public void setSenderUser(User senderUser) {
        this.senderUser = senderUser;
    }

    public User getReceiverUser() {
        return receiverUser;
    }

    public void setReceiverUser(User receiverUser) {
        this.receiverUser = receiverUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
