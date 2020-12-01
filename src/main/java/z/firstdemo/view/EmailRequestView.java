package z.firstdemo.view;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;

public class EmailRequestView {

    @NonNull
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
