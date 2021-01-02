package com.utils.file.controller;

import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lj
 */
@RestController
public class DemoController {
    private Logger log =
            Logger.getLogger(DemoController.class.getSimpleName());

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello (String name) {
        log.info(name+"hello springboot!!");
        return name+"hello springboot!!";
    }


}
