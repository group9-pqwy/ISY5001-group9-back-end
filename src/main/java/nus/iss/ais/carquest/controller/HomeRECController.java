package nus.iss.ais.carquest.controller;

import nus.iss.ais.carquest.entity.MainPageRECParams;
import nus.iss.ais.carquest.entity.Profile;
import nus.iss.ais.carquest.service.LoginService;
import nus.iss.ais.carquest.service.ModelService;
import nus.iss.ais.carquest.service.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeRECController {
    @Autowired
    private SearchHistoryService searchHistoryService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private LoginService loginService;

    @PostMapping("/carsList")
    public ResponseEntity<?> getHomePageCarList(@RequestParam(required = false) String token) {
        MainPageRECParams mainPageRECParams;
        if(token!=null) {
            Integer useId = loginService.getUserIdFromToken(token);
            mainPageRECParams = searchHistoryService.getUserSearchHistory(useId);
        }
        else {
            mainPageRECParams = new MainPageRECParams();
        }

        return ResponseEntity.ok(modelService.getMainPageRECList(mainPageRECParams));
    }
}
