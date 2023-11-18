package com.microdevs.authservice.model;

import com.microdevs.baseservice.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.AssertFalse;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserFilter {
    private String phone;
    private String email;
    private StatusType status;

    @AssertFalse(message = "phone or email should be sent")
    public boolean phoneOrEmailIsInvalid() {
        return !Objects.isNull(phone) || !Objects.isNull(email);
    }

}
