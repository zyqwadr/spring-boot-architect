package xyz.nesting.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.nesting.example.dao.mysql.CityDao;
import xyz.nesting.example.domain.City;
import xyz.nesting.example.service.CityService;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }
    
    
    @Override
    @Transactional
    public void addCity() {
        cityDao.addCity(3L, "safasd", "cc");
    }

}
