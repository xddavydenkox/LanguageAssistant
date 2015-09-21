package com.ddavydenko.app.dao.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import com.ddavydenko.app.dao.EngSongsDao;
import com.ddavydenko.app.domains.Impl.EngSongs;

@Repository
@Transactional
public class EngSongsDaoImpl extends AbstractDaoImpl<EngSongs> implements EngSongsDao{

    @SuppressWarnings("unchecked")
    public List<EngSongs> getSongInfoBySinger(String singer) {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(EngSongs.class);
        return (List<EngSongs>)sessionFactory.getCurrentSession()
                .getNamedQuery(EngSongs.Q_GET_SONGS_BY_SINGER)
                .setParameter("singer", singer).list();

    }

    @SuppressWarnings("unchecked")
    public List<EngSongs> getSongInfoBySongName(String songName) {
        return (List<EngSongs>)sessionFactory.getCurrentSession()
                .getNamedQuery(EngSongs.Q_GET_SONGS_BY_SONG)
                .setParameter("songName", songName).list();
    }

    public EngSongs getSongInfoBySingerAndName(String singer, String name) {
        return (EngSongs) sessionFactory.getCurrentSession()
                .getNamedQuery(EngSongs.Q_GET_SONG_BY_SINGER_AND_SONG)
                .setParameter("singerName", singer)
                .setParameter("songName", name).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<EngSongs> getAllSongsInfo() {
        return (List<EngSongs>)sessionFactory.getCurrentSession()
                .getNamedQuery(EngSongs.Q_GET_ALL_SONGS).list();
    }

    @SuppressWarnings("unchecked")
    public List<EngSongs> getSingerAndSongName() {
        return (List<EngSongs>)sessionFactory.getCurrentSession()
                .getNamedQuery(EngSongs.Q_GET_SINGER_AND_SONG_NAME).list();
    }

    public List<EngSongs> getFiveRandomSongs() {

        List<EngSongs> listOfFive = new ArrayList<EngSongs>();

        while(listOfFive.size()<5) {
            EngSongs song = getRandomSong();
            if(song!=null){
                listOfFive.add(song);
            }
        }
        return listOfFive;
    }

    public int getRandomNumber(int range) {
        
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(range);
    }

    public EngSongs getRandomSong() {
        int length = getAllSongsInfo().size();
        if(length>=0) {
            EngSongs song = getAllSongsInfo().get(getRandomNumber(length));
            return song;
        }
        else {
            return null;
        }

    }

}
