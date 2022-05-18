package com.dlc.server.model;

import com.dlc.server.enums.AuthorityType;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "user_authorities")
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Enumerated(EnumType.STRING)
    private AuthorityType authority;

    public Authorities(AuthorityType authority) {
        this.authority = authority;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public AuthorityType getAuthority() {
        return authority;
    }

    public void setAuthority(AuthorityType authority) {
        this.authority = authority;
    }
}
