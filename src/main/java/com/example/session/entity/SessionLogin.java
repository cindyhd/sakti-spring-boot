package com.example.session.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ADM_R_SEC_SESSION_LOGIN")
@Getter
@Setter
public class SessionLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String SESSIONID;
    private Date ACCESSED_TIME;
    private String REMOTE_ADDRESS;
    private String USERID;
    private String CURRENT_ALPHA_ID;
    private String CURRENT_BETA_ID;
    private String CLIENT_ID;
}