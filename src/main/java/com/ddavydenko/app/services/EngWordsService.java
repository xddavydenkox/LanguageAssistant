
package com.ddavydenko.app.services;

import java.util.List;

import com.ddavydenko.app.domains.Impl.EngWords;
import com.ddavydenko.app.domains.bo.AllCategoriesBO;
import com.ddavydenko.app.domains.bo.AllTopicsBO;
import com.ddavydenko.app.domains.bo.DataBaseSizeBO;
import com.ddavydenko.app.domains.bo.KeyValueBO;

/**
 * @author ddavydenko
 *
 */
public interface EngWordsService {
    /**
     * Return a list of {@link EngWords} by specified category name.
     * 
     * @param category - category name in the DB.
     * @return list of {@link EngWords} objects when argument is of type String.
     * The list could be of size 0;
     */
    List<EngWords> getWordsInfoByCategory(String category);

    /**
     * Return a list of {@link EngWords} by specified topic name.
     * 
     * @param topic - topic name in the DB.
     * @return list of {@link EngWords} objects when argument is of type String.
     * The list could be of size 0;
     */
    List<EngWords> getWordsInfoByTopic(String topic);

    /**
     * Return a list of {@link EngWords} by specified english word name.
     * 
     * @param engWord - English word translation in the DB.
     * @return list of {@link EngWords} objects when argument is of type String.
     * The list could be of size 0;
     */
    EngWords getWordsInfoByEngWord(String engWord);

    /**
     * Return a list of {@link EngWords} by specified russian word.
     * 
     * @param rusWord - russian word translation in the DB.
     * @return list of {@link EngWords} objects when argument is of type String.
     * The list could be of size 0;
     */
    EngWords getWordsInfoByRusWord(String rusWord);

    /**
     * Get list of random {@link EngWords} objects from myappdb.
     * This method would use {@link getRandomSong()} to pick songs by ID. 
     * ID's could repeat oneself.
     * 
     * @param quantity - number of random Objects which would be returned.
     * @return list of random {@link EngWords} Objects which should not exceed 
     * the total length of DB objects list.
     */
    List<EngWords> getRandomWords(int quantity);

    /**
     * Return a list of English and Russian words pairs.
     * 
     * @return list of {@link EngWords} objects. The list could be of size 0;
     */
    List<KeyValueBO> getEngAndRusWordsPairs();

    /**
     * Deletes the category
     * @param category - the name of the category to delete.
     */
    void deleteCategory(String category);

    /**
     * Deletes the topic in chosen category.
     * @param category - the name of category, in which to delete topic.
     * @param topic - the name of the topic to delete.
     */
    void deleteTopic(String category, String topic);

    /**
     * Delete word in chosen topic and category.
     * @param category - the name of category, in which to delete the word.
     * @param topic - the name of the topic in which to delete the word.
     * @param engWord - English word, to delete.
     */
    void deleteWord(String category, String topic, String engWord);
    
    /**
     * Get total number of rows in EngWords DB.
     * @return total number of rows.
     */
    DataBaseSizeBO getLengthOfDB();

    /**
     * Get list of all {@link EngWords} categories in the DB
     * @return list of {@link AllCategoriesBO} categories
     */
    List<AllCategoriesBO> getCategoryList();

    /**
     * Get list of all unique {@link EngWords} topics in the DB in given category.
     * @return list of unique {@link AllTopicsBO} topics in given category.
     */
    List<AllTopicsBO> getTopicsList(String category);
}
