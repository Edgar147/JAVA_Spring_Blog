package com.myblog.app.model;

import javax.persistence.*;

@Entity
@Table(name = "texts")

public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idText;

    @Column(name = "text", nullable = false, length = 300)
    private String text;


    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;


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