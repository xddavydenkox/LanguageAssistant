package com.ddavydenko.app.services;

import java.util.List;

import com.ddavydenko.app.domains.Impl.EngSongs;

/**
 * @author ddavydenko
 *
 */
public interface EngSongService {
    List<EngSongs> getSongsBySinger(String singer);

    List<EngSongs> getSongBySongName(String songName);

    EngSongs getSongInfoBySingerAndName(String singer, String songName);

    List<EngSongs> getAllSongsInfo();

    List<EngSongs> getFiveRandomSongs();

    List<EngSongs> getSingerAndSongName();
}