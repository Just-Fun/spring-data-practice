package ua.com.serzh.borisov;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Serzh on 2/5/17.
 */
@Configuration
//@EnableJpaRepositories
@EnableMongoRepositories
public class ApplicationConfiguration {

    @Bean
    public Mongo getMongo() throws Exception{
        return new MongoClient();
    }

    @Bean
    @Autowired
    public MongoTemplate mongoTemplate(Mongo m) throws Exception{
        MongoTemplate mongoTemplate = new MongoTemplate(m, "mongoTemplate");
        return mongoTemplate;
    }
}
