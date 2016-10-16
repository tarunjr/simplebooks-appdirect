package org.simplebooks.integration.appdirect.controller;

import org.simplebooks.integration.appdirect.service.SubscriptionService;
import org.simplebooks.integration.appdirect.service.SecurityService;
import org.simplebooks.integration.appdirect.service.EventResponseBase;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@RestController
public class SubscriptionEventHandlerController {
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private SecurityService securityService;


    @RequestMapping("/subscription/create/notification")
    public EventResponseBase create(@RequestParam(value="url", defaultValue="")  String eventUrl,
                         @RequestHeader(value="authorization",required=true) String authorization) {
        securityService.validate(authorization);
        System.out.println(eventUrl);
        System.out.println(authorization);

        return subscriptionService.create(null);
    }

    /*
    @RequestMapping("/subscription/create/notification")
    public void echo(HttpServletRequest req,  HttpServletResponse res) throws IOException {
        StringBuilder sb = new StringBuilder();

        Enumeration headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String header = (String)headerNames.nextElement();
            sb.append(header);
            sb.append(":");

            Enumeration headers = req.getHeaders(header);
            while(headers.hasMoreElements()) {
                String value = (String)headers.nextElement();
                sb.append(value);
                sb.append(",");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

        res.setStatus(HttpServletResponse.SC_OK);
    }
    */
    @RequestMapping("/subscription/change/notification")
    public String change(@RequestParam(value="url", defaultValue="")  String eventUrl) {
        return subscriptionService.change(null);
    }
    @RequestMapping("/subscription/cancel/notification")
    public String cancel(@RequestParam(value="url", defaultValue="")  String eventUrl) {
        return subscriptionService.cancel(null);
    }
    @RequestMapping("/subscription/notice/notification")
    public String notice(@RequestParam(value="url", defaultValue="")  String eventUrl) {
        return subscriptionService.notice(null);
    }
}
