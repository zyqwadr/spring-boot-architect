package xyz.nesting.example.dao.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import xyz.nesting.example.domain.Apple;

@Repository
public interface AppleRepository extends MongoRepository<Apple, String> {

}
