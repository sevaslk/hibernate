package com.myhibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    private Long id;
    @Enumerated
    private AccountStatus status;

    @OneToOne(mappedBy = "account")
    private Developer developer;

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

}
