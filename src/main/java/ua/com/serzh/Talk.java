package ua.com.serzh;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Serzh on 2/5/17.
 */
@Entity
public class Talk {
    @Id
    @GeneratedValue
    public Long id;

    public String title;
    public Date date;
}
