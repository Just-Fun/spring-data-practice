package ua.com.serzh;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Serzh on 2/5/17.
 */
@Entity
public class Speaker {
    @Id
    @GeneratedValue
    public Long id;

    public String name;
    public String sureName;

    @OneToMany
    List<Talk> talks;
}
