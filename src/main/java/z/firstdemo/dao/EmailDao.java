package z.firstdemo.dao;

import z.firstdemo.entity.EmailAddress;

import java.util.List;

public interface EmailDao {

    public List<EmailAddress> getByFullName(String emailFullName);
    public void save(EmailAddress emailAddress);

}
