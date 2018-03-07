/**
 * 
 */
package xyz.nesting.example.service;

import java.util.List;

import xyz.nesting.example.domain.Person;

/**
 * 
 * @Description: TODO(添加描述)
 * @Author zhengyue
 * @Version: 0.0.1
 * @CreateAt 2017年12月25日-下午5:20:52
 *
 */
public interface PersonService {
    Long savePerson(Person city);

    List<Person> searchPerson(Integer pageNumber, Integer pageSize, String searchContent);
}
