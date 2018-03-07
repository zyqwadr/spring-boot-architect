package xyz.nesting.example.service.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.nesting.example.asyntask.AsyncDemo;
import xyz.nesting.example.dao.mongo.MailMsgDao;
import xyz.nesting.example.dao.mongo.repository.AppleRepository;
import xyz.nesting.example.dao.mongo.repository.MailMsgRepository;
import xyz.nesting.example.domain.Apple;
import xyz.nesting.example.domain.MailMsg;
import xyz.nesting.example.service.MailService;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class MailServiceImpl implements MailService {
	private Logger log = LoggerFactory.getLogger(MailServiceImpl.class) ;

	@Autowired  
    private MailMsgDao mailMsgDao;  
	
	@Autowired
	private AppleRepository appleRepository;
	
	@Autowired
	private AsyncDemo asyncDemo;

	@Override
	public MailMsg findByTo(String to) {
		asyncDemo.asyncInvokeWithParameter("sfa");
        return mailMsgDao.findByTo(to);  
    }  
	
	
	@Override
	public void addEmail()  
    {  
        
        Apple apple = new Apple();
        apple.setTo("sdf");
        appleRepository.insert(apple);
        
        MailMsg msg1 = new MailMsg();  
        msg1.setTo("to");  
        msg1.setSubject("subjec");  
        msg1.setText("test");
        msg1.setPrice(new BigDecimal("23"));
        msg1.setApple(apple);
        mailMsgDao.insert(msg1);
		
    }  
	
	@Override
	public void findEmail()  
    {  
		MailMsg msg1 = mailMsgDao.findOne("5a73d4c66c687b5b75c99e15");
		log.info(""+msg1);
		
		Apple apple=mailMsgDao.findAppleById("5a73d4c66c687b5b75c99e15");
		log.info("apple:"+apple);
		
		MailMsg msg12 = mailMsgDao.findSubjectAndSendDtById("5a73d4c66c687b5b75c99e15");
		log.info("msg12:"+msg12);
		
		MailMsg msg34 = mailMsgDao.findSubjectAndAppleById("5a73d4c66c687b5b75c99e15");
		log.info("msg34:"+msg34);
		
    }

}
