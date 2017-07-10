package my.groupid.models;

import com.sun.org.glassfish.gmbal.NameValue;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


/**
 * Created by JPMC-B2-PC010 on 30/06/2017.
 */
@Entity
public class SevenEleven {

    @Id
    @GeneratedValue
    private long id;

    public String name;

    public String email;
    public String month;
    public String day;
    public String year;
    public boolean box;

    public boolean getBox() {
        return box;
    }

    public void setBox(boolean box) {
        this.box = box;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

