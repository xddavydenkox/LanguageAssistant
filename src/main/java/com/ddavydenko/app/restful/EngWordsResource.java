/**
 * 
 */
package com.ddavydenko.app.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddavydenko.app.domains.Impl.EngWords;
import com.ddavydenko.app.domains.bo.AllCategoriesBO;
import com.ddavydenko.app.domains.bo.AllTopicsBO;
import com.ddavydenko.app.domains.bo.DataBaseSizeBO;
import com.ddavydenko.app.domains.bo.KeyValueBO;
import com.ddavydenko.app.services.EngWordsService;

/**
 * @author ddavydenko
 *
 * @Controller - Аннотация используется для магического превращения любого java класса в класс контроллера.
 * Данный класс представляет собой компонент, похожий на обычный сервлет (HttpServlet) 
 * (работающий с объектами HttpServletRequest и HttpServletResponse), но с расширенными 
 * возможностями по применению в MVC-приложениях.
 *@RequestMapping("/engsong") - Аннотация используется для маппинга урл-адреса запроса на указанный метод или класс. 
 * Запрос можно маппить как на метод класса, так и на целый класс. Допускается указывать конкретный 
 * HTTP-метод, который будет обрабатываться (GET/POST), передавать параметры запроса.
 */
@Controller
@RequestMapping("/engwords")
public class EngWordsResource {

    @Autowired
    private EngWordsService service;

    /**
     * Simple method to test if method structure works.
     * @return the message "Hello".
     */
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        return "Hello";
    }

    /**
     * Getting list of {@link EngWords} objects via category
     * @param category - parameter based on which the {@link EngWords} objects are retrieved.
     * @return list of {@link EngWords} objects based on the parameter.
     */
    @RequestMapping(value = "/wordsinfo/bycategory/{category}", method = RequestMethod.GET)
    @ResponseBody
    public List<EngWords> getWordsByCategory(@PathVariable("category") String category) {
        return service.getWordsInfoByCategory(category);
    }

    /**
     * Getting list of {@link EngWords} objects via topic.
     * @param topic - parameter based on which the {@link EngWords} objects are retrieved.
     * @return list of {@link EngWords} objects based on the parameter.
     */
    @RequestMapping(value = "/wordsinfo/bytopic/{topic}", method = RequestMethod.GET)
    @ResponseBody
    public List<EngWords> getWordsByTopic(@PathVariable("topic") String topic) {
        return service.getWordsInfoByTopic(topic);
    }

    /**
     * Getting {@link EngWords} object looked by English word.
     * @param word - parameter based on which the {@link EngWords} object is retrieved.
     * @return {@link EngWords} object based on the parameter.
     */
    @RequestMapping(value = "/wordsinfo/byEngWord/{word}", method = RequestMethod.GET)
    @ResponseBody
    public EngWords getWordsByEngWord(@PathVariable("word") String engWord) {
        return service.getWordsInfoByEngWord(engWord);
    }

    /**
     * Getting {@link EngWords} object looked by Russian word.
     * @param word - parameter based on which the {@link EngWords} object is retrieved.
     * @return {@link EngWords} object based on the parameter.
     */
    @RequestMapping(value = "/wordsinfo/byRusWord/{word}", method = RequestMethod.GET)
    @ResponseBody
    public EngWords getWordsByRusWord(@PathVariable("word") String rusWord) {
        return service.getWordsInfoByRusWord(rusWord);
    }

    /**
     * Getting random number of {@link EngWords} objects. The quantity is defined by user. 
     * @param quantity - quantity of random {@link EngWords} objects to retrieve from DB.
     * @return the list of random {@link EngWords} objects. The quantity is defined manually.
     */
    @RequestMapping(value = "/wordsinfo/random/{quantity}", method = RequestMethod.GET)
    @ResponseBody
    public List<EngWords> getRandomWords(@PathVariable("quantity") String quantity) {
        return service.getRandomWords(Integer.parseInt(quantity));
    }

    /**
     * Getting all English and Russian word pairs from DB. 
     * @return the list of {@link EngWords} objects.
     */
    @RequestMapping(value = "/wordsinfo/englishAndRussianWords", method = RequestMethod.GET)
    @ResponseBody
    public List<KeyValueBO> getEngAndRusWordsPairs() {
        return service.getEngAndRusWordsPairs();
    }

    /**
     * Delete all words information with the given category
     * @param category - category of the word, by which to delete word information.
     */
    @RequestMapping(value = "/deleteWordsInfo/byCategory/{category}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCategory(@PathVariable("category") String category) {
        service.deleteCategory(category);
    }

    /**
     * Delete all words information with the given category and topic
     * @param category - category of the word, by which to delete word information.
     * @param topic - name of the topic to delete.
     */
    @RequestMapping(value = "/deleteWordsInfo/byCategory/{category}/byTopic/{topic}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTopic(@PathVariable String category, @PathVariable String topic) {
        service.deleteTopic(category,topic);
    }

    /**
     * Delete all words information with the given category and topic
     * @param category - category of the word, by which to delete word information.
     * @param topic - name of the topic by which to delete word.
     * @param word - word to delete from DB.
     */
    @RequestMapping(value = "/deleteWordsInfo/byCategory/{category}/byTopic/{topic}/byWord{engWord}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteWord(@PathVariable String category, @PathVariable String topic, @PathVariable String engWord) {
        service.deleteWord(category,topic,engWord);
    }

    /**
     * Get the length of all values in {@link EngWords} DataBase.
     * @return length of Data Base
     */
    @RequestMapping(value = "/dataBaseSize", method = RequestMethod.GET)
    @ResponseBody
    public DataBaseSizeBO getLengthOfDB() {
        return service.getLengthOfDB();
    }

    /**
     * Getting all {@link EngWords} categories from DB. 
     * @return the list of {@link AllCategoriesBO} objects.
     */
    @RequestMapping(value = "/wordsinfo/getCategoryList", method = RequestMethod.GET)
    @ResponseBody
    public List<AllCategoriesBO> getAllCategories() {
        return service.getCategoryList();
    }

    /**
     * Getting all unique {@link EngWords} topics in given category. 
     * @return the list of unque {@link AllTopicsBO} objects.
     */
    @RequestMapping(value = "/wordsinfo/getTopicList/{category}", method = RequestMethod.GET)
    @ResponseBody
    public List<AllTopicsBO> getAllTopics(@PathVariable String category) {
        return service.getTopicsList(category);
    }
}
