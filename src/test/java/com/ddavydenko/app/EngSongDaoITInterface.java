package com.ddavydenko.app;

import org.junit.Test;

/**
 * @author ddavydenko
 *
 */
public interface EngSongDaoITInterface {

    @Test
    void someTest();

    @Test
    void getSongInfoBySingerTest();

    @Test
    void getSongInfoBySongNameTest();

    @Test
    void getSongInfoBySingerAndNameTest();

    @Test
    void getAllSongsInfoTest();

    @Test
    void getAllSongsInfoViaAbstractTest();

    @Test
    void getFiveRandomSongsTest();

    @Test
    void getRandomNumberTest();

    @Test
    void getRandomSongTest();

}
