package xyz.nesting.example.controller;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.nesting.example.domain.City;
import xyz.nesting.example.service.CityService;

import java.util.Map;

/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;
    
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
//    @ApiOperation(value="获取city", notes="创建city")
    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByName(cityName);
    }
    
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public Map addCity() {
    	cityService.addCity();
        return Maps.newHashMap();
    }
    
    @RequestMapping(value = "/api/redis", method = RequestMethod.GET)
    public Map redis(String name) {
    	redisTemplate.opsForValue().set(name, name);
        return Maps.newHashMap();
    }

}
