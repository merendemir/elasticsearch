package com.web.elasticsearch.repository;

import com.web.elasticsearch.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<User, String> {

    Iterable<User> findAllByName(String name);
}
