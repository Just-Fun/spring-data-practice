package ua.com.serzh.borisov;


import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serzh on 2/5/17.
 */
@Entity
public class Speaker {
//    @Id
//    @GeneratedValue
//    public Long id;

    private String name;

    private List<Talk> talks;

    public Speaker() {
    }

    public Speaker(String name) {
        this.name = name;
    }

    public void addTalk(Talk talk) {
        if(talks==null) talks = new ArrayList<>();
        talks.add(talk);
    }

    public String getName() {
        return name;
    }

    public List<Talk> getTalks() {
        return talks;
    }

    @Override
    public String toString() {
        return name;
    }
}
