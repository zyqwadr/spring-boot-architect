package xyz.nesting.example.dao.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import xyz.nesting.example.domain.Apple;
import xyz.nesting.example.domain.MailMsg;

@Repository
public interface MailMsgRepository extends MongoRepository<MailMsg, String> {

    MailMsg findByTo(String to);

	Apple findAppleById(String string);
	
	@Query(fields="{'subject':1,'apple':1}")
	MailMsg findSubjectAndAppleById(String string);

	@Query(fields="{'subject':1,'sendDt':1}")
	MailMsg findSubjectAndSendDtById(String string);
}
