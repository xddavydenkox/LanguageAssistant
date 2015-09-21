package com.ddavydenko.app.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddavydenko.app.domains.Impl.EngSongs;
import com.ddavydenko.app.domains.Impl.EngWords;
import com.ddavydenko.app.services.EngSongService;

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
@RequestMapping("/restful/engsong")
public class EngSongResource {

    @Autowired
    private EngSongService service;

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        return "Hello";
    }

    /**
     * Getting list of {@link EngSongs} objects via singers name.
     * @param name - parameter based on which the {@link EngSongs} objects are retrieved.
     * @return list of {@link EngSongs} objects based on the parameter.
     */
    @RequestMapping(value = "/songinfo/singer/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<EngSongs> getSongsBySinger(@PathVariable("name") String singer) {
        return service.getSongsBySinger(singer);
    }

    /**
     * Getting list of {@link EngSongs} objects via the name of the song.
     * @param songname - parameter based on which the {@link EngSongs} objects are retrieved.
     * @return list of {@link EngSongs} objects based on the parameter.
     */
    @RequestMapping(value = "/songinfo/songname{songname}", method = RequestMethod.GET)
    @ResponseBody
    public List<EngSongs> getSongBySongName(@PathVariable("songname") String songName) {
        return service.getSongBySongName(songName);
    }

    /**
     * Getting list of {@link EngSongs} objects via the the name of the singer and the name of the song.
     * @param singer - singer name.
     * @param songname - song name.
     * @return list of {@link EngSongs} objects based on the parameters.
     */
    @RequestMapping(value = "/songinfo/singer/{singer}/songname/{songName}", method = RequestMethod.GET)
    @ResponseBody
    public EngSongs getSongBySingerAndSongName( @PathVariable String singer, @PathVariable String songName) {
        return service.getSongInfoBySingerAndName(singer, songName);
    }

    /**
     * Getting list of {@link EngSongs} objects via singers name.
     * @param name - parameter based on which the {@link EngSongs} objects are retrieved.
     * @return list of {@link EngSongs} objects based on the parameter.
     */
    @RequestMapping(value = "/songinfo/singer and song name", method = RequestMethod.GET)
    @ResponseBody
    public List<EngSongs> getSingerAndSongName() {
        return service.getSingerAndSongName();
    }
    
    /**
     * Gets all {@link EngSongs} objects from Songs database;
     * @return list of all {@link EngSongs} objects.
     */
    @RequestMapping(value = "/songinfo", method = RequestMethod.GET)
    @ResponseBody
    public List<EngSongs> getAllSongsInfo() {
        return service.getAllSongsInfo();
    }
}
