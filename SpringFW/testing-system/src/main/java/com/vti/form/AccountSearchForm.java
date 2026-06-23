package com.vti.form;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountSearchForm {
    private String username;
    private String fullname;
    private String email;
    private String departmentName;
    private String positionName;
}
