package nus.iss.ais.carquest.service.impl;

import nus.iss.ais.carquest.entity.CarSearchRequest;
import nus.iss.ais.carquest.entity.MainPageRECParams;
import nus.iss.ais.carquest.mapper.SearchHistoryMapper;
import nus.iss.ais.carquest.model.SearchHistory;
import nus.iss.ais.carquest.service.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {
    @Autowired
    private SearchHistoryMapper searchHistoryMapper;

    @Override
    public MainPageRECParams getUserSearchHistory(Integer userId) {
       List<SearchHistory> searchHistories =  searchHistoryMapper.selectMostFrequentSearch(userId);
       SearchHistory searchHistory=null;
       if (searchHistories!=null)
       {
           searchHistory = searchHistories.get(0);
           String make = searchHistory.getMake();
           String model = searchHistory.getModel();
           String color = searchHistory.getColor();
           String trim = searchHistory.getTrim();
           String body = searchHistory.getBody();
           BigDecimal minPrice = searchHistory.getMinPrice();
           BigDecimal maxPrice = searchHistory.getMaxPrice();
           return new MainPageRECParams(make,model,color,trim,body,minPrice,maxPrice);
       }
       else
       {
           return new MainPageRECParams();
       }
    }

    @Override
    public void saveSearchHistory(Integer userId, CarSearchRequest carSearchRequest) {
        SearchHistory searchHistory = new SearchHistory();

        searchHistory.setUserId(userId);
        searchHistory.setMake(carSearchRequest.getMake());
        searchHistory.setModel(carSearchRequest.getModel());
        searchHistory.setColor(carSearchRequest.getColor());
        searchHistory.setTrim(carSearchRequest.getTrim());
        searchHistory.setBody(carSearchRequest.getBody());
        searchHistory.setTransmission(carSearchRequest.getTransmission());
        searchHistory.setVin(carSearchRequest.getVin());
        searchHistory.setState(carSearchRequest.getState());
        searchHistory.setCondition(carSearchRequest.getCondition());
        searchHistory.setMinOdometer(carSearchRequest.getMinOdometer());
        searchHistory.setMaxOdometer(carSearchRequest.getMaxOdometer());
        searchHistory.setInterior(carSearchRequest.getInterior());
        searchHistory.setSeller(carSearchRequest.getSeller());
        if (carSearchRequest.getMmr() != null) {
            searchHistory.setMmr(BigDecimal.valueOf(carSearchRequest.getMmr()));
        } else {
            // 设置默认值或忽略
            searchHistory.setMmr(BigDecimal.ZERO);
        }
        if (carSearchRequest.getMinPrice() != null) {
            searchHistory.setMinPrice(BigDecimal.valueOf(carSearchRequest.getMinPrice()));
        } else {
            searchHistory.setMinPrice(BigDecimal.ZERO);
        }
        if (carSearchRequest.getMaxPrice() != null) {
            searchHistory.setMaxPrice(BigDecimal.valueOf(carSearchRequest.getMaxPrice()));
        } else {
            searchHistory.setMaxPrice(BigDecimal.ZERO);
        }
        searchHistory.setSearchTime(new Date());
        searchHistoryMapper.insert(searchHistory);
    }
}
