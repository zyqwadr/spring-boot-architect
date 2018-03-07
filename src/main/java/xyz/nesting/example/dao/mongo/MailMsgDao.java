package xyz.nesting.example.dao.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import xyz.nesting.example.dao.mongo.repository.MailMsgRepository;
import xyz.nesting.example.domain.Apple;
import xyz.nesting.example.domain.MailMsg;

@Component
public class MailMsgDao {

	@Autowired  
    private MailMsgRepository mailMsgRepository;
	
	@Autowired  
    private MongoTemplate mongoTemplate;

	public MailMsg findByTo(String to) {
		return mailMsgRepository.findByTo(to);
	}

	public MailMsg insert(MailMsg msg1) {
		return mailMsgRepository.insert(msg1);
	}

	public MailMsg findOne(String id) {
		return mailMsgRepository.findOne(id);
	}

	public Apple findAppleById(String string) {
		return mailMsgRepository.findAppleById(string);
	}

	public MailMsg findSubjectAndSendDtById(String string) {
		return mailMsgRepository.findSubjectAndSendDtById(string);
	}

	public MailMsg findSubjectAndAppleById(String string) {
		return mailMsgRepository.findSubjectAndAppleById(string);
	}  
	
	public void updateSubjectById(String subject, String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		Update update = new Update();
		update.set("subject", subject);
		mongoTemplate.updateFirst(query, update, MailMsg.class);
	}  
	
	
}
