
package com.ddavydenko.app;

import java.util.List;

import org.junit.Test;

import com.ddavydenko.app.domains.Impl.EngWords;

/**
 * @author ddavydenko
 *
 */
public interface EngWordsDaoITInterface {

    @Test
    void getWordsInfoByCategoryTest();

    @Test
    void getWordsInfoByTopicTest();

    @Test
    void getWordsInfoByEngWordTest();

    @Test
   void getWordsInfoByRusWordTest();

    @Test
    void getRandomWordsTest();

    @Test
    void getAllWordsInfoViaAbstractTest();

    @Test
    void deleteCategoryTest();

    @Test
    void deleteTopicTest();

    @Test
    void deleteWordTest();

}
