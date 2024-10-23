package nus.iss.ais.carquest.service;

import nus.iss.ais.carquest.entity.CarSearchRequest;
import nus.iss.ais.carquest.entity.MainPageRECParams;

import java.util.List;
import java.util.Map;

public interface SearchHistoryService {
    MainPageRECParams getUserSearchHistory(Integer userId);
    void saveSearchHistory(Integer userId, CarSearchRequest carSearchRequest);
}
