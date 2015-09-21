package com.ddavydenko.app.dao;

import java.util.List;

import com.ddavydenko.app.domains.Impl.EngSongs;

public interface EngSongsDao extends AbstractDao<EngSongs> {
    /**
     * Return a list of {@link EngSongs} by specified singer name.
     * 
     * @param singer - singers name in the DB.
     * @return list of {@link EngSongs} objects when argument is of type String.
     * The list could be of size 0;
     */
    List<EngSongs> getSongInfoBySinger(String singer);

    /**
     * Returns the list of {@link EngSongs} when searching by the name of the song. 
     * The songs name could be duplicate for different Singers. 
     * 
     * @param songName - the name of the song.
     * @return list of {@link EngSongs} objects. The list could be of size 0;
     */
    List<EngSongs> getSongInfoBySongName(String songName);

    /**
     * Returns {@list EngSongs} object by specified singer and song name.
     * 
     *  @param singer - the singers name,
     *  @param songName - the name of the song.
     *  
     *  @return {@link EngSongs} object according to parameters.
     *  Returns null, if there is no such song associated with given singer.
     */
    EngSongs getSongInfoBySingerAndName(String singer, String name);

    /**
     * Get the list of all {@link EngSongs} objects from DataBase.
     * 
     * @return the list of all {@link EngSongs} objects.
     */
    List<EngSongs> getAllSongsInfo();

    /**
     * Get the list of all Singers and Song names from DataBase.
     * 
     * @return the list of all {@link EngSongs} objects.
     */
    List<EngSongs> getSingerAndSongName();

    /**
     * Get list of 5 random {@link EngSongs} objects from myappdb.
     * This method would use {@link getRandomSong()} to pick songs by ID. 
     * ID's could repeat oneself.
     * 
     */
    List<EngSongs> getFiveRandomSongs();

    /**
     * Support method for {@link getRandomSong()} method to get random number.
     * 
     * @param range - the length of {@link EngSongs} list.
     * @return random number from 0 to range.
     */
    int getRandomNumber(int range);

    /**
     * Support method for {@link getFiveRandomSongs()} method to get random song.
     * @return {@link EngSongs} object to add to the list of random songs.
     */
    EngSongs getRandomSong();


}
