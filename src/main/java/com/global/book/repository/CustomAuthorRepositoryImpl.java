package com.global.book.repository;

import com.global.book.entity.Author;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthorRepositoryImpl implements CustomAuthorRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public CustomAuthorRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void updateEmail(String email, String name, String phone) {
        Query query = new Query(Criteria.where("email").is(email));
        Update update = new Update()
                .set("name", name)
                .set("phone", phone);



        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Author.class);

        if(updateResult == null){
            System.out.println("no update");
        }else{
            System.out.println("update");
        }

    }
}
