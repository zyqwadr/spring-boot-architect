package xyz.nesting.example.controller;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.nesting.example.asyntask.AsyncDemo;
import xyz.nesting.example.domain.MailMsg;
import xyz.nesting.example.service.MailService;

import java.util.Map;

/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class MailRestController {
	private Logger log = LoggerFactory.getLogger(MailRestController.class) ;
	
    @Autowired
    private MailService mailService;
    @Autowired
	private AsyncDemo asyncDemo;

    @RequestMapping(value = "/api/mail", method = RequestMethod.GET)
    public MailMsg findOneCity(String to) {
    	asyncDemo.asyncInvokeWithParameter("sfa");
    	return mailService.findByTo(to);
    }
    
    @RequestMapping(value = "/api/mail", method = RequestMethod.POST)
    public Map addCity() {
    	mailService.addEmail();
        return Maps.newHashMap();
    }

}
