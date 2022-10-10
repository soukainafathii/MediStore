package com.example.medistore.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class CustomerDto implements Serializable {

    private static final long serialVersionUID = -3960795681303503295L;

    private long id;
    private String name;
    private String address;
    private int phone;
    private String email;
    private String password;
    private String encryptedPassword;
    private String emailVerificationToken;
    private String getEmailVerificationStatus;
}
