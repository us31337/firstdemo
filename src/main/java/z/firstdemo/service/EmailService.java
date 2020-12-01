package z.firstdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import z.firstdemo.dao.EmailDao;
import z.firstdemo.entity.EmailAddress;
import z.firstdemo.view.EmailRequestView;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailDao emailDao;

    public boolean emailExist(EmailRequestView emailRequestView) {
        List<EmailAddress> list = emailDao.getByFullName(emailRequestView.getEmail());
        return list.size() == 0 ? false : true;
    }

    public void saveIfNotExist(EmailRequestView emailRequestView) {
        if (!emailExist(emailRequestView)) {
            saveNewEmail(emailRequestView);
        } else {
            throw new IllegalArgumentException("Email " + emailRequestView.getEmail() +
                    " is already exist");
        }
    }

    public void saveNewEmail(EmailRequestView emailRequestView) {
        EmailAddress emailAddress = new EmailAddress();
        emailAddress.setEmail(emailRequestView.getEmail().toLowerCase());
        emailDao.save(emailAddress);
    }

}
