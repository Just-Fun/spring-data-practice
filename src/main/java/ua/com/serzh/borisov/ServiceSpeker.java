package ua.com.serzh.borisov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by Serzh on 2/5/17.
 */
@Service
public class ServiceSpeker {

    @Autowired
    SpeakerRepository repository;

    public void someCheck() {
        long count = repository.count();
        Iterable<Speaker> speakers = repository.findAll(new Sort(Sort.Direction.DESC, "name"));
//        repository.findByName("Angelina");
//        repository.findPleaseByNameLike("%Angelina%");
//        repository.findPleaseByNameEndingWith("na");
//        repository.findByTalksTitleLike(".*SomeTopic.*");
    }
}
