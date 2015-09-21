package com.ddavydenko.app.dao.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.criterion.Projections;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ddavydenko.app.dao.EngWordsDao;
import com.ddavydenko.app.domains.Impl.EngWords;
import com.ddavydenko.app.domains.bo.AllCategoriesBO;
import com.ddavydenko.app.domains.bo.AllTopicsBO;
import com.ddavydenko.app.domains.bo.DataBaseSizeBO;
import com.ddavydenko.app.domains.bo.KeyValueBO;

@Repository
@Transactional
public class EngWordsDaoImpl extends AbstractDaoImpl<EngWords> implements EngWordsDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<EngWords> getWordsInfoByCategory(String category) {

        return (List<EngWords>)sessionFactory.getCurrentSession()
                .getNamedQuery(EngWords.Q_GET_WORDS_BY_CATEGORY)
                .setParameter("category", category).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<EngWords> getWordsInfoByTopic(String topic) {
        return (List<EngWords>) sessionFactory.getCurrentSession()
                .getNamedQuery(EngWords.Q_GET_WORDS_BY_TOPIC)
                .setParameter("topic", topic).list();
    }

    @Override
    public EngWords getWordsInfoByEngWord(String engWord) {
        return (EngWords) sessionFactory.getCurrentSession()
                .getNamedQuery(EngWords.Q_GET_WORDS_BY_ENGWORD)
                .setParameter("engWord", engWord).uniqueResult();
    }

    @Override
    public EngWords getWordsInfoByRusWord(String rusWord) {
        return (EngWords) sessionFactory.getCurrentSession()
                .getNamedQuery(EngWords.Q_GET_WORDS_BY_RUSWORD)
                .setParameter("rusWord", rusWord).uniqueResult();
    }

    @Override
    public List<EngWords> getRandomWords(int quantity) {
        List<EngWords> listOfRandom = new ArrayList<EngWords>(quantity);

        while(listOfRandom.size()<quantity) {
            EngWords song = getRandomWord();
            if(song!=null){
                listOfRandom.add(song);
            }
        }
        return listOfRandom;
    }

    @Override
    public int getRandomNumber(int range) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(range);
    }

    @Override
    public EngWords getRandomWord() {

        if(getAll().size()>=0) {
            EngWords word = getAll().get(getRandomNumber(getAll().size()));
            return word;
        }
        else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<KeyValueBO> getEngAndRusWordsPairs() {
        return (List<KeyValueBO>) sessionFactory.getCurrentSession()
                .getNamedQuery(EngWords.Q_GET_ENG_AND_RUS_WORDS)
                .setResultTransformer(new AliasToBeanResultTransformer(KeyValueBO.class))
                .list();
    }

    @Override
    public void deleteCategory(String category) {
        sessionFactory.getCurrentSession().getNamedQuery(EngWords.Q_DELETE_CATEGORY)
                        .setParameter("category", category).executeUpdate();
    }

    @Override
    public void deleteTopic(String category, String topic) {
        sessionFactory.getCurrentSession().getNamedQuery(EngWords.Q_DELETE_TOPIC)
                        .setParameter("category", category)
                        .setParameter("topic", topic).executeUpdate();
    }

    @Override
    public void deleteWord(String category, String topic, String engWord) {
        sessionFactory.getCurrentSession().getNamedQuery(EngWords.Q_DELETE_WORD)
                        .setParameter("category", category)
                        .setParameter("topic", topic)
                        .setParameter("engWord", engWord).executeUpdate();
    }

    @Override
    public DataBaseSizeBO getLengthOfDB() {
        return (DataBaseSizeBO) sessionFactory.getCurrentSession()
                .getNamedQuery(EngWords.Q_GET_TOTAL_LENGTH)
                .setResultTransformer(new AliasToBeanResultTransformer(DataBaseSizeBO.class))
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AllCategoriesBO> getCategoryList() {
        return (List<AllCategoriesBO>) sessionFactory.getCurrentSession()
                .getNamedQuery(EngWords.Q_GET_ALL_CATEGORIES)
                .setResultTransformer(new AliasToBeanResultTransformer(AllCategoriesBO.class))
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AllTopicsBO> getTopicsList(String category) {
        return (List<AllTopicsBO>) sessionFactory.getCurrentSession()
                .getNamedQuery(EngWords.Q_GET_TOPIC_LIST)
                .setResultTransformer(new AliasToBeanResultTransformer(AllTopicsBO.class))
                .setParameter("category", category)
                .list();
    }

}
