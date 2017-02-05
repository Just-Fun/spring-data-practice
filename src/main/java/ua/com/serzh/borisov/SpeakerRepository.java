package ua.com.serzh.borisov;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Serzh on 2/5/17.
 */
//public interface SpeakerRepository extends PagingAndSortingRepository<Speaker,Integer> {
public interface SpeakerRepository extends MongoRepository<Speaker, Long> {

    List<Speaker> findByName(String name);

    List<Speaker> findByNameLike(String name);

    @Query("{'talks.when' : {$gt : ?0, $lt : ?1}}")
    List<Speaker> findSpeakersWithTalksBetween(Date from, Date to);

    default List<Talk> findTalksBetween(Date from, Date to) {
        List<Speaker> speakers = findSpeakersWithTalksBetween(from, to);
        return speakers.stream().map(Speaker::getTalks).flatMap(Collection::stream).filter(t -> isBetween(from, to, t)).collect(Collectors.toList());
    }

    default boolean isBetween(Date from, Date to, Talk time) {
        return time.getWhen().after(from) && time.getWhen().before(to);
    }

    @Query("{ 'talks.title': {$regex : ?0 }}")
    Set<Speaker> getSpeakersWithTalksAbout(String name);



    /*@FindByName

    List<Speaker> findByNameStartingWith(String name);

    List<Speaker> findPleeeeaseByNameEndingWith(String suffix);

    @Query(fields = "{talks.title:1}")
    List<Speaker>  findByTalksWhenBetween(Date from, Date to);

    Set<Speaker> findByTalksTitleContaining(String partOfTalkName);

    default List<Talk> findTalksBetween(Date from, Date to){
        List<Speaker> speakers = findByTalksWhenBetween(from, to);
        return speakers.stream().map(Speaker::getTalks).flatMap(Collection::stream).filter(t -> isBetween(from, to, t)).collect(Collectors.toList());
    }

    default boolean isBetween(Date from, Date to, Talk time) {
        return time.getWhen().after(from) && time.getWhen().before(to);
    }

    Speaker findByName(String name);

    List<Speaker> findPleaseByNameLike(String s);
    List<Speaker> findPleaseByNameEndingWith(String s);

    @Query("{'talks.title':{$regex:?0}}")
    List<Speaker> findSpeakersWithSpecificsTalks(String s);

    List<Speaker> findByTalksTitleLike(String s);

    @Query(fields = "{talks:1}")
    List<Speaker> findByTalksTWhenBetween(Date from, Date to);*/
}
