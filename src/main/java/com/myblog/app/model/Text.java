package com.myblog.app.model;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idText;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;

    private String text;


    public Long getIdText() {
        return idText;
    }

    public void setIdText(Long idText) {
        this.idText = idText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
