package com.ddavydenko.app.domains.Impl;


import javax.persistence.*;

import com.ddavydenko.app.domains.AbstractEntity;

@Entity
@Table(name="engwords")
public class EngWords extends AbstractEntity{

    public static final String Q_GET_WORDS_BY_CATEGORY = "com.ddavydenko.app.domains.Q_GET_WORDS_BY_CATEGORY";
    public static final String Q_GET_WORDS_BY_TOPIC = "com.ddavydenko.app.domains.Q_GET_WORDS_BY_TOPIC";
    public static final String Q_GET_WORDS_BY_ENGWORD = "com.ddavydenko.app.domains.Q_GET_WORDS_BY_ENGWORD";
    public static final String Q_GET_WORDS_BY_RUSWORD = "com.ddavydenko.app.domains.Q_GET_WORDS_BY_RUSWORD";
    public static final String Q_GET_ENG_AND_RUS_WORDS = "com.ddavydenko.app.domains.Q_GET_ENG_AND_RUS_WORDS";
    public static final String Q_DELETE_CATEGORY = "com.ddavydenko.app.domains.Q_DELETE_CATEGORY";
    public static final String Q_DELETE_TOPIC = "com.ddavydenko.app.domains.Q_DELETE_TOPIC";
    public static final String Q_DELETE_WORD = "com.ddavydenko.app.domains.Q_DELETE_WORD";
    public static final String Q_GET_TOTAL_LENGTH = "com.ddavydenko.app.domains.Q_GET_TOTAL_LENGTH";
    public static final String Q_GET_ALL_CATEGORIES = "com.ddavydenko.app.domains.Q_GET_ALL_CATEGORIES";
    public static final String Q_GET_TOPIC_LIST = "com.ddavydenko.app.domains.Q_GET_TOPIC_LIST";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="engword")
    private String engWord;

    @Column(name="rusword")
    private String rusWord;

    @Column(name="category")
    private String category;

    @Column(name="topic")
    private String topic;

    public EngWords(){

    }
    @Override
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEngword() {
        return engWord;
    }
    public void setEngword(String engword) {
        this.engWord = engword;
    }
    public String getRusword() {
        return rusWord;
    }
    public void setRusword(String rusword) {
        this.rusWord = rusword;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }

}
