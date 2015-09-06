////////////////////////////////////////////////////////////////////////////////
//
// Copyright (c) 2015, Suncorp Metway Limited. All rights reserved.
//
// This is unpublished proprietary source code of Suncorp Metway Limited.
// The copyright notice above does not evidence any actual or intended
// publication of such source code.
//
////////////////////////////////////////////////////////////////////////////////

package au.com.suncorp.easyshare.model;

import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import org.hibernate.annotations.Type;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

@Entity
@Table(name = "UPLOAD")
public final class Upload {

    @Id
    @Column(name = "id")
    private int id;

    @Size(min = 18)
    @Column(nullable = false)
    private String key;

    @NotNull
    @Size(min = 1, max = 320)
    @Column(nullable = false)
    private String description;


    public Upload(String description) {
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void getKey(String id) {
        this.key = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
