package ua.com.serzh.borisov;

import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/**
 * Created by Serzh on 2/5/17.
 */
@RepositoryDefinition(domainClass = Talk.class, idClass = Long.class)
public interface TalkRepository {
    List<Talk> findByTitleLikeIgnoreCase(String s);
}
