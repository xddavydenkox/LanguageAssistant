
package com.ddavydenko.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddavydenko.app.dao.EngSongsDao;
import com.ddavydenko.app.domains.Impl.EngSongs;
import com.ddavydenko.app.services.EngSongService;

/**
 * @author ddavydenko
 *
 */
@Service
public class EngSongServiceImpl implements EngSongService {

    @Autowired
    private EngSongsDao dao;

    @Override
    public List<EngSongs> getSongsBySinger(String singer) {
        return dao.getSongInfoBySinger(singer);
    }

    @Override
    public List<EngSongs> getSongBySongName(String songName) {

        return dao.getSongInfoBySongName(songName);
    }

    @Override
    public EngSongs getSongInfoBySingerAndName(String singer, String songName) {

        return dao.getSongInfoBySingerAndName(singer, songName);
    }

    @Override
    public List<EngSongs> getAllSongsInfo() {

        return dao.getAllSongsInfo();
    }

    @Override
    public List<EngSongs> getFiveRandomSongs() {

        return dao.getFiveRandomSongs();
    }

    @Override
    public List<EngSongs> getSingerAndSongName() {
        return dao.getSingerAndSongName();
    }
}
