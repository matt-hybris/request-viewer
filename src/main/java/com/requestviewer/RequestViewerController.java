package com.requestviewer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by Matt Rossner on 2/6/15.
 */
@Controller
public class RequestViewerController {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(RequestViewerController.class);
    
    @RequestMapping("/")
    public @ResponseBody String dumpRequest(HttpServletRequest request) {

        LOGGER.info("Headers...");
        LOGGER.info("==========");
        for (Enumeration<String> en = request.getHeaderNames(); en.hasMoreElements();) {
            String key = en.nextElement();
            LOGGER.info("{}={}", key, request.getHeader(key));
        }

        LOGGER.info("Params...");
        LOGGER.info("==========");

        request.getParameterMap().entrySet().forEach(e -> {
            LOGGER.info("{}={}", e.getKey(), e.getValue()[0]);
        });

        return "OK";
    }
}
