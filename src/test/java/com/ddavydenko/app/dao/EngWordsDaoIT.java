
package com.ddavydenko.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ddavydenko.app.EngWordsDaoITInterface;
import com.ddavydenko.app.domains.Impl.EngWords;
import com.ddavydenko.app.domains.bo.AllCategoriesBO;
import com.ddavydenko.app.domains.bo.AllTopicsBO;
import com.ddavydenko.app.domains.bo.DataBaseSizeBO;
import com.ddavydenko.app.domains.bo.KeyValueBO;

/**
 * @author ddavydenko
 *
 */
public class EngWordsDaoIT extends AbstractITClass implements EngWordsDaoITInterface{

    private static final int EXPECTED_ID = 10;
    private static final int VALUE_TO_TEST = 7;

    @Autowired
    private EngWordsDao sut;

    @Autowired
    protected SessionFactory sessionFactory;
    
    @Test
    public void getWordsInfoByCategoryTest() {
        List<EngWords> actual = sut.getWordsInfoByCategory("Numbers");
        long length = actual.size();

        Assert.assertNotNull(actual);
        Assert.assertEquals("The length of the list should be 10",EXPECTED_ID,length);
    }

    @Test
    public void getWordsInfoByTopicTest() {
        List<EngWords> actual = sut.getWordsInfoByTopic("1-10");
        long length = actual.size();

        Assert.assertNotNull(actual);
        Assert.assertEquals(8, length);
    }

    @Test
    public void getWordsInfoByEngWordTest() {
        EngWords actual = sut.getWordsInfoByEngWord("five");

        Assert.assertNotNull(actual);
        Assert.assertTrue(actual.getClass() == EngWords.class);
    }

    @Test
    public void getWordsInfoByRusWordTest() {
        EngWords actual = sut.getWordsInfoByRusWord("пять");

        Assert.assertNotNull(actual);
        Assert.assertTrue(actual.getClass() == EngWords.class);
    }

    @Test
    public void getRandomWordsTest() {
        List<EngWords> actualResult = sut.getRandomWords(VALUE_TO_TEST);
        
        Assert.assertNotNull(actualResult);
        Assert.assertEquals("The length of list should be 7", VALUE_TO_TEST, actualResult.size());
    }

    @Test
    public void getAllWordsInfoViaAbstractTest() {
        
        List<EngWords> actualResult = sut.getAll();

        Assert.assertNotNull(actualResult);
        Assert.assertEquals("There should be 13 elements in the db.", 13, actualResult.size());
        Assert.assertNotEquals(4, actualResult.size());
    }

    @Test
    public void getEngAndRusWordsPairsTest() {
        List<KeyValueBO> actual = sut.getEngAndRusWordsPairs();

        Assert.assertNotNull(actual);
        Assert.assertEquals("There should be 13 elements in the db.", 13, actual.size());

            System.out.println(actual.toString());
    }

    @Test
    public void deleteCategoryTest() {

        int beforeSize = sut.getAll().size();
        sut.deleteCategory("Color");
        int afterSize = sut.getAll().size();

        Assert.assertNotEquals("The length of the list before and after should not be the same", beforeSize, afterSize);
        
    }

    @Test
    public void deleteTopicTest() {
        int beforeSize = sut.getAll().size();
        sut.deleteTopic("Color","RGB");
        int afterSize = sut.getAll().size();


        Assert.assertNotEquals("The length of the list before and after should not be the same", beforeSize, afterSize);
    }

    @Test
    public void deleteWordTest() {
        int beforeSize = sut.getAll().size();
        sut.deleteWord("Color","RGB","blue");
        int afterSize = sut.getAll().size();

        Assert.assertNotEquals("The length of the list before and after should not be the same", beforeSize, afterSize);
    }

    @Test
    public void getLengthOfDBTest() {
        DataBaseSizeBO length = (DataBaseSizeBO) sut.getLengthOfDB();
        
        Assert.assertNotNull(length);
        Assert.assertEquals("Shold be of size 13", 13, length.getSize());
    }

    @Test
    public void getCategoryListTest() {
        List<AllCategoriesBO> actualResult = sut.getCategoryList();

        Assert.assertNotNull(actualResult);
        Assert.assertEquals("Length should be 2", 2, actualResult.size());
    }

    @Test
    public void getTopicsListTest() {
        List<AllTopicsBO> actualResult = sut.getTopicsList("Color");

        Assert.assertNotNull(actualResult);
        Assert.assertEquals("Length should be 1", 1, actualResult.size());
    }
}
