package ua.com.serzh.borisov;


import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Serzh on 2/5/17.
 */
@Entity
public class Talk {

    private Date when;

    private String title;

    public Talk() {
    }

    public Talk(String title, Date date) {
        this.title = title;
        this.when = date;
    }

    @Override
    public String toString() {
        return title;
    }

    public Date getWhen() {
        return when;
    }
}