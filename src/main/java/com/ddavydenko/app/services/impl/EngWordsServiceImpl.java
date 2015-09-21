
package com.ddavydenko.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddavydenko.app.dao.EngWordsDao;
import com.ddavydenko.app.domains.Impl.EngWords;
import com.ddavydenko.app.domains.bo.AllCategoriesBO;
import com.ddavydenko.app.domains.bo.AllTopicsBO;
import com.ddavydenko.app.domains.bo.DataBaseSizeBO;
import com.ddavydenko.app.domains.bo.KeyValueBO;
import com.ddavydenko.app.services.EngWordsService;

/**
 * @author ddavydenko
 *
 */
@Service
public class EngWordsServiceImpl implements EngWordsService {

    @Autowired
    private EngWordsDao dao;

    @Override
    public List<EngWords> getWordsInfoByCategory(String category) {
        return dao.getWordsInfoByCategory(category);
    }

    @Override
    public List<EngWords> getWordsInfoByTopic(String topic) {
        return dao.getWordsInfoByTopic(topic);
    }

    @Override
    public EngWords getWordsInfoByEngWord(String engWord) {
        return dao.getWordsInfoByEngWord(engWord);
    }

    @Override
    public EngWords getWordsInfoByRusWord(String rusWord) {
        return dao.getWordsInfoByRusWord(rusWord);
    }

    @Override
    public List<EngWords> getRandomWords(int quantity) {
        return dao.getRandomWords(quantity);
    }

    @Override
    public List<KeyValueBO> getEngAndRusWordsPairs() {
        return dao.getEngAndRusWordsPairs();
    }

    @Override
    public void deleteCategory(String category) {
        dao.deleteCategory(category);
    }

    @Override
    public void deleteTopic(String category, String topic) {
        dao.deleteTopic(category, topic);
    }

    @Override
    public void deleteWord(String category, String topic, String engWord) {
        dao.deleteWord(category, topic, engWord);
    }

    @Override
    public DataBaseSizeBO getLengthOfDB() {
        return dao.getLengthOfDB();
    }

    @Override
    public List<AllCategoriesBO> getCategoryList() {
        return dao.getCategoryList();
    }

    @Override
    public List<AllTopicsBO> getTopicsList(String category) {
        return dao.getTopicsList(category);
    }


}
