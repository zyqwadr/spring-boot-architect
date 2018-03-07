package xyz.nesting.example.dao.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import xyz.nesting.example.domain.Person;

/**
 * Created by bysocket on 17/05/2017.
 */
@Repository
public interface PersonRepository extends ElasticsearchRepository<Person,Long> {


}
