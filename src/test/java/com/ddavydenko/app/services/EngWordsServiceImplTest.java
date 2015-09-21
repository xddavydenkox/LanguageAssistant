/**
 * 
 */
package com.ddavydenko.app.services;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.ddavydenko.app.dao.EngWordsDao;
import com.ddavydenko.app.domains.Impl.EngWords;
import com.ddavydenko.app.domains.bo.AllCategoriesBO;
import com.ddavydenko.app.domains.bo.AllTopicsBO;
import com.ddavydenko.app.domains.bo.DataBaseSizeBO;
import com.ddavydenko.app.domains.bo.KeyValueBO;
import com.ddavydenko.app.services.impl.EngWordsServiceImpl;

/**
 * @author ddavydenko
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class EngWordsServiceImplTest {

    @InjectMocks
    private EngWordsServiceImpl sut;

    @Mock
    private EngWordsDao dao;

    @Test
    public void testGetWordsInfoByCategory() {
        List<EngWords> expectedList = Arrays.asList(new EngWords());
        Mockito.when(dao.getWordsInfoByCategory(Mockito.anyString())).thenReturn(expectedList);

        List<EngWords> actualList = sut.getWordsInfoByCategory("Numbers");
        Mockito.verify(dao).getWordsInfoByCategory(Mockito.anyString());
    }

    @Test
    public void testGetWordsInfoByTopic() {
        List<EngWords> expectedList = Arrays.asList(new EngWords());
        Mockito.when(dao.getWordsInfoByTopic(Mockito.anyString())).thenReturn(expectedList);

        List<EngWords> actualList = sut.getWordsInfoByTopic("1-10");
        Mockito.verify(dao).getWordsInfoByTopic(Mockito.anyString());
    }

    @Test
    public void testGetWordsInfoByEngWord() {
        EngWords expected = new EngWords();
        Mockito.when(dao.getWordsInfoByEngWord(Mockito.anyString())).thenReturn(expected);

        EngWords actual = sut.getWordsInfoByEngWord("two");
        Mockito.verify(dao, Mockito.atLeastOnce()).getWordsInfoByEngWord(Mockito.anyString());
    }

    @Test
    public void testGetWordsInfoByRusWord() {
        EngWords expected = new EngWords();
        Mockito.when(dao.getWordsInfoByRusWord(Mockito.anyString())).thenReturn(expected);

        EngWords actual = sut.getWordsInfoByRusWord("два");
        sut.getWordsInfoByRusWord("два");
        sut.getWordsInfoByRusWord("два");
        Mockito.verify(dao, Mockito.times(3)).getWordsInfoByRusWord(Mockito.anyString());
    }

    @Test
    public void testGetRandomWords() {
        List<EngWords> expectedList = Arrays.asList(new EngWords());
        Mockito.when(dao.getRandomWords(6)).thenReturn(expectedList);

        List<EngWords> actualList = sut.getRandomWords(6);
        sut.getRandomWords(6);
        sut.getRandomWords(6);
        Mockito.verify(dao, Mockito.times(3)).getRandomWords(6);
    }

    @Test
    public void testGetEngAndRusWordsPairs() {
        List<KeyValueBO> expectedList = Arrays.asList(new KeyValueBO());
        Mockito.when(dao.getEngAndRusWordsPairs()).thenReturn(expectedList);

        List<KeyValueBO> actualList = sut.getEngAndRusWordsPairs();
        sut.getEngAndRusWordsPairs();
        sut.getEngAndRusWordsPairs();
        Mockito.verify(dao, Mockito.times(3)).getEngAndRusWordsPairs();
    }

    @Test
    public void testDeleteCategory() {
        sut.deleteCategory("Color");
        Mockito.verify(dao).deleteCategory("Color");
    }

    @Test
    public void testDeleteTopic() {
        sut.deleteTopic("Color","RGB");
        Mockito.verify(dao).deleteTopic("Color","RGB");
    }

    @Test
    public void testDeleteWord() {
        sut.deleteWord("Color","RGB","red");
        Mockito.verify(dao).deleteWord("Color","RGB","red");
    }

    @Test
    public void testGetLengthOfDB() {
        DataBaseSizeBO expected =  new DataBaseSizeBO();
        expected.setSize(13);
        Mockito.when(dao.getLengthOfDB()).thenReturn(expected);

        sut.getLengthOfDB();
        Mockito.verify(dao, Mockito.atLeastOnce()).getLengthOfDB();
    }

    @Test
    public void testGetCategoryList() {
        List<AllCategoriesBO> expectedList = Arrays.asList(new AllCategoriesBO());
        Mockito.when(dao.getCategoryList()).thenReturn(expectedList);

        List<AllCategoriesBO> actualList = sut.getCategoryList();
        Mockito.verify(dao, Mockito.atLeastOnce()).getCategoryList();
    }

    @Test
    public void testGetTopicsList() {
        List<AllTopicsBO> expectedList = Arrays.asList(new AllTopicsBO());
        Mockito.when(dao.getTopicsList(Mockito.anyString())).thenReturn(expectedList);

        List<AllTopicsBO> actualList = sut.getTopicsList(Mockito.anyString());
        Mockito.verify(dao, Mockito.atLeastOnce()).getTopicsList(Mockito.anyString());
    }
}
