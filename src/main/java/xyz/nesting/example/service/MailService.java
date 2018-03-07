package xyz.nesting.example.service;

import xyz.nesting.example.domain.MailMsg;

public interface MailService {

	/**
	 * @param to
	 * @return
	 */
	MailMsg findByTo(String to);

	/**
	 * @param mailMsg
	 */
	void addEmail();

	void findEmail();

}
