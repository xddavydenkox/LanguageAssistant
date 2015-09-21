package com.ddavydenko.app.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ddavydenko.app.EngSongDaoITInterface;
import com.ddavydenko.app.dao.EngSongsDao;
import com.ddavydenko.app.dao.Impl.EngSongsDaoImpl;
import com.ddavydenko.app.domains.Impl.EngSongs;

/**
 * @author ddavydenko
 * Integration Tests for {@link EngSongsDaoImpl} class.
 *
 */
public class EngSongDaoIT extends AbstractITClass implements EngSongDaoITInterface{

    private static final Long EXPECTED_ID = 1L;
    private static final int EXPECTED_LENGTH = 1;

    @Autowired
    private EngSongsDao sut;

    @Test
    public void someTest() {
        EngSongs actualResult = sut.find(EXPECTED_ID);

        Assert.assertNotNull(actualResult);
        Assert.assertEquals(EXPECTED_ID, actualResult.getId());
    }
    @Test
    public void getSongInfoBySingerTest() {
        List<EngSongs> actualResult = sut.getSongInfoBySinger("Linkin Park");

        long actual = actualResult.size();

        Assert.assertNotNull(actualResult);
        Assert.assertNotEquals(0, actual);
        Assert.assertEquals("Length of the List should be 2", 2, actual);
    }

    @Test
    public void getSongInfoBySongNameTest() {
        List<EngSongs> actualResult = sut.getSongInfoBySongName("Leto");

        long actual = (long) actualResult.size();

        Assert.assertNotNull(actualResult);
        Assert.assertEquals("Length of the List should be 1", EXPECTED_LENGTH, actual);
    }

    @Test
    public void getSongInfoBySingerAndNameTest() {
        EngSongs actualResult = (EngSongs) sut.getSongInfoBySingerAndName("BonJovi", "It's my life");

        Long expected = 2L;

        Assert.assertNotNull(actualResult);
        Assert.assertEquals(expected, actualResult.getId());
    }

    @Test
    public void getAllSongsInfoTest() {

        List<EngSongs> actualResult = sut.getAllSongsInfo();

        Assert.assertNotNull(actualResult);
        Assert.assertEquals(6, actualResult.size());
    }

    @Test
    public void getAllSongsInfoViaAbstractTest() {

        List<EngSongs> actualResult = sut.getAll();

        Assert.assertNotNull(actualResult);
        Assert.assertEquals("There should be 6 elements in the db.", 6, actualResult.size());
        Assert.assertNotEquals(4, actualResult.size());
    }

    @Test
    public void getFiveRandomSongsTest() {
        List<EngSongs> actualResult = sut.getFiveRandomSongs();
        
        Assert.assertNotNull(actualResult);
        Assert.assertEquals("The length of list should be 5", 5, actualResult.size());
    }

    @Test
    public void getRandomNumberTest() {
        int actual = sut.getRandomNumber(20);
        Assert.assertNotNull(actual);
    }

    @Test
    public void getRandomSongTest() {
        EngSongs actual = sut.getRandomSong();
        Assert.assertNotNull(actual);
    }

    @Test
    public void getSingerAndSongNameTest() {
        List<EngSongs> actual = sut.getSingerAndSongName();
        Assert.assertNotNull("Should not be null", actual);
        Assert.assertEquals("List size should be 6",6,actual.size());
        Assert.assertNotEquals(5, actual.size());

    }

}
