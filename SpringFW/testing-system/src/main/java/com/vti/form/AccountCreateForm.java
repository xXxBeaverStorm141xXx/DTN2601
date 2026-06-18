package com.vti.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreateForm {
    @NotBlank(message = "Username không được để trống")
    @Length(max = 50, message = "Username không được dài qúa 50 kí tự")
    private String username;
    private String password;
    private String fullname;
    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Phải nhập đúng định dạng email")
    @Length(max = 50, message = "Email không được dài qúa 50 kí tự")
    private String email;
    private Integer departmentId;
    private Integer positionId;
}
