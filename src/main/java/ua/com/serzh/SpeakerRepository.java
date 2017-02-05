package ua.com.serzh;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by Serzh on 2/5/17.
 */
//public interface SpeakerRepository extends PagingAndSortingRepository<Speaker,Integer> {
public interface SpeakerRepository extends MongoRepository<Speaker,Integer> {

    Speaker findByName(String name);

    List<Speaker> findPleaseByNameLike(String s);
    List<Speaker> findPleaseByNameEndingWith(String s);

    @Query("{'talks.title':{$regex:?0}}")
    List<Speaker> findSpeakersWithSpecificsTalks(String s);

    List<Speaker> findByTalksTitleLike(String s);

    @Query(fields = "{talks:1}")
    List<Speaker> findByTalksTWhenBetween(Date from, Date to);
}
