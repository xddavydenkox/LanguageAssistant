package com.ddavydenko.app.services;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.ddavydenko.app.dao.EngSongsDao;
import com.ddavydenko.app.domains.Impl.EngSongs;
import com.ddavydenko.app.services.impl.EngSongServiceImpl;

/**
 * @author ddavydenko
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class EngSongsServiceImplTest {

    @InjectMocks
    private EngSongServiceImpl sut;

    @Mock
    private EngSongsDao dao;

    @Test
    public void testFindSongsBySinger() {
        List<EngSongs> expectedList = Arrays.asList(new EngSongs());
        Mockito.when(dao.getSongInfoBySinger(Mockito.anyString())).thenReturn(expectedList);

        sut.getSongsBySinger("BonJovi");
        Mockito.verify(dao).getSongInfoBySinger(Mockito.anyString());
    }

    @Test
    public void testFindSongsBySongName() {
        List<EngSongs> expectedList = Arrays.asList(new EngSongs());
        Mockito.when(dao.getSongInfoBySongName(Mockito.anyString())).thenReturn(expectedList);

        //List<EngSongs> actualList = sut.getSongBySongName("It's my life");
        Mockito.verify(dao, Mockito.never()).getSongInfoBySongName(Mockito.anyString());
    }

    @Test
    public void testFindSongsBySingerAndSongName() {
        EngSongs expected = new EngSongs();
        Mockito.when(dao.getSongInfoBySingerAndName(Mockito.anyString(), Mockito.anyString())).thenReturn(expected);
        
        EngSongs actual = sut.getSongInfoBySingerAndName("BonJovi", "It's my life");
        sut.getSongInfoBySingerAndName("BonJovi", "It's my life");
        Mockito.verify(dao, Mockito.times(2)).getSongInfoBySingerAndName(Mockito.anyString(), Mockito.anyString());
    }

    @Test
    public void testFindAllSongs() {
        List<EngSongs> expected = Arrays.asList(new EngSongs());
        Mockito.when(dao.getAllSongsInfo()).thenReturn(expected);

        List<EngSongs> actual = sut.getAllSongsInfo();
        Mockito.verify(dao).getAllSongsInfo();
    }

    @Test
    public void testGetFiveRandomSongs() {
        List<EngSongs> expected = Arrays.asList(new EngSongs());
        Mockito.when(dao.getFiveRandomSongs()).thenReturn(expected);

        List<EngSongs> actual = sut.getFiveRandomSongs();
        Mockito.verify(dao, Mockito.times(1)).getFiveRandomSongs();
    }

    @Test
    public void testGetSingerAndSongName() {
        List<EngSongs> expected = Arrays.asList(new EngSongs());
        Mockito.when(dao.getSingerAndSongName()).thenReturn(expected);

        sut.getSingerAndSongName();
        Mockito.verify(dao).getSingerAndSongName();
    }
}
