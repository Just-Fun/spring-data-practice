package ua.com.serzh;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

/**
 * Created by Serzh on 2/5/17.
 */
@Configuration
//@EnableJpaRepositories
@EnableMongoRepositories
public class ApplicationConfiguration {
    @Bean
    MongoClient mongoClient() throws UnknownHostException {
        return new MongoClient();
    }

    @Bean
    MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(mongoClient(), "mongo");
    }
}
