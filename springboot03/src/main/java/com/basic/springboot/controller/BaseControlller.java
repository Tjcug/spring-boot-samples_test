package com.basic.springboot.controller;

import com.basic.springboot.util.FreeMarkerUtil;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dell-pc on 2016/4/20.
 */

@Controller
@RequestMapping(value = "/",produces = "text/html;charset=UTF-8")
public class BaseControlller {

    protected Gson gson = new Gson();

    protected static final Logger log = LoggerFactory.getLogger(WebController.class);

    @Autowired
    protected FreeMarkerUtil markerUtil;

}
