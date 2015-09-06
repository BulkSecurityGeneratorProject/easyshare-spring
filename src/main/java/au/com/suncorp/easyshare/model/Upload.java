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

import javax.persistence.*;
import org.hibernate.annotations.Type;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "UPLOAD")
public final class Upload {

    @Id
    @Column(name = "ID")
    private String id;

    @NotNull
    @Size(min = 18)
    @Column(name = "KEY")
    private String key;

    @NotNull
    @Size(min = 1, max = 320)
    @Column(name = "DESCRIPTION")
    private String description;

    public Upload() {}

    public Upload(String id, String description, String key) {
        this.id = id;
        this.description = description;
        this.key = key;
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
