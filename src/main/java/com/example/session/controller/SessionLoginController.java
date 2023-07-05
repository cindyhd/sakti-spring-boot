package com.example.session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.session.service.SessionLoginService;
import com.example.session.entity.SessionLogin;
import com.example.session.request.ValidateSessionLoginRequest;
import com.example.session.response.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class SessionLoginController {
    @Autowired
    private SessionLoginService sessionLoginService;
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionLoginController.class);

    @RequestMapping(value= {"/validateSessionLogin"}, method=RequestMethod.POST, consumes = "application/json")
    public CommonResponse validateSessionLogin(@RequestBody ValidateSessionLoginRequest request) {
        LOGGER.info("isi request" + request);
        LOGGER.info("req1 " + request.getSessionId());
        LOGGER.info("req2 " + request.getToken());
        LOGGER.info("req3 " + request.getTimestamp());
        SessionLogin sessionLogin = sessionLoginService.isSessionLoginValid(request.getSessionId(), request.getToken(),
                request.getTimestamp());
        CommonResponse response = new CommonResponse();
        response.setStatus(true);
        response.setObject(sessionLogin);
        return response;
    }

    //ini dipakai kalau parameter agak banyak terus paramnya ditambahin file baru di package request
//    @RequestMapping(value= {"/isAccessValid"}, method=RequestMethod.POST, consumes = "application/json")
//    public CommonResponse isAccessValid(@RequestBody IsAccessValidRequest request) {
//        LOGGER.info("isi request " + request);
//        LOGGER.info("req1 " + request.getUserId());
//        LOGGER.info("req2 " + request.getUrl());
//        boolean isAccessValid = sessionLoginService.isAccessValid(request.getUserId(), request.getUrl());
//        CommonResponse response = new CommonResponse();
//        response.setStatus(true);
//        response.setObject(isAccessValid);
//        return response;
//    }

    @RequestMapping(value= {"/isAccessValid"}, method=RequestMethod.POST, consumes = "application/json")
    public CommonResponse isAccessValid(@RequestParam("userId") String userId, @RequestParam ("url") String url) {
        LOGGER.info("req1 " + userId);
        LOGGER.info("req2 " + url);
        boolean isAccessValid = sessionLoginService.isAccessValid(userId, url);
        CommonResponse response = new CommonResponse();
        response.setStatus(true);
        response.setObject(isAccessValid);
        return response;
    }
}
