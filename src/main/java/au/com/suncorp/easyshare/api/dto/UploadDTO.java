package au.com.suncorp.easyshare.api.dto;


import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class UploadDTO {

//    public static final int EXPIRES_IN_MIN_LENGTH = 0;
//    public static final int EXPIRES_IN_MAX_LENGTH = 844640;
//
//    @NotNull
//    @Size(min = EXPIRES_IN_MIN_LENGTH, max = EXPIRES_IN_MAX_LENGTH)
//    private int expiresIn;

    @Size(max = 50)
    private String description;

    public UploadDTO() {
    }

    public UploadDTO(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

