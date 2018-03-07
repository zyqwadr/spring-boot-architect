/**
 * 
 */
package xyz.nesting.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.nesting.example.domain.Person;
import xyz.nesting.example.service.PersonService;

/**
 * 
 * @Description: TODO(添加描述)
 * @Author zhengyue
 * @Version: 0.0.1
 * @CreateAt 2017年12月25日-下午5:15:06
 *
 */
@RestController
public class PersonRestController {
	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/api/person", method = RequestMethod.POST)
	public Long createCity(@RequestBody Person p) {
		return personService.savePerson(p);
	}

	@RequestMapping(value = "/api/person/search", method = RequestMethod.GET)
	public List<Person> searchperson(@RequestParam(value = "pageNumber") Integer pageNumber,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "searchContent") String searchContent) {
		return personService.searchPerson(pageNumber, pageSize, searchContent);
	}
}
