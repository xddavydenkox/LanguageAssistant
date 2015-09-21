package com.ddavydenko.app.domains.Impl;

import javax.persistence.*;

@Entity
@Table(name="engsongs")
public class EngSongs {

    public static final String Q_GET_ALL_SONGS = "com.ddavydenko.app.domains.Q_GET_ALL_SONGS";
    public static final String Q_GET_SONGS_BY_SINGER = "com.ddavydenko.app.domains.Q_GET_SONGS_BY_SINGER";
    public static final String Q_GET_SONGS_BY_SONG = "com.ddavydenko.app.domains.Q_GET_SONGS_BY_SONG";
    public static final String Q_GET_SONG_BY_SINGER_AND_SONG = "com.ddavydenko.app.domains.Q_GET_SONG_BY_SINGER_AND_SONG";
    public static final String Q_GET_SINGER_AND_SONG_NAME = "com.ddavydenko.app.domains.Q_GET_SINGER_AND_SONG_NAME";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="singer_name_eng")
    private String singerNameEng;

    @Column(name="song_name_eng")
    private String songNameEng;

    @Column(name="song_name_rus")
    private String songNameRus;

    @Column(name="song_lyrics_eng")
    private String songLyricsEng;

    @Column(name="song_lyrics_rus")
    private String songLyricsRus;

    public EngSongs(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long i) {
        this.id = i;
    }

    public String getSingerNameEng() {
        return singerNameEng;
    }

    public void setSingerNameEng(String singerNameEng) {
        this.singerNameEng = singerNameEng;
    }

    public String getSongNameEng() {
        return songNameEng;
    }

    public void setSongNameEng(String songNameEng) {
        this.songNameEng = songNameEng;
    }

    public String getSongNameRus() {
        return songNameRus;
    }

    public void setSongNameRus(String songNameRus) {
        this.songNameRus = songNameRus;
    }

    public String getSongLyricsEng() {
        return songLyricsEng;
    }

    public void setSongLyricsEng(String songLyricsEng) {
        this.songLyricsEng = songLyricsEng;
    }

    public String getSongLyricsRus() {
        return songLyricsRus;
    }

    public void setSongLyricsRus(String songLtricsRus) {
        this.songLyricsRus = songLtricsRus;
    }

}
