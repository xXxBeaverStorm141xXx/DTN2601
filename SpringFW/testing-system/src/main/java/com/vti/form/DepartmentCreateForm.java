package com.vti.form;

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
public class DepartmentCreateForm {
    @NotBlank(message = "DepartmentName không được để trống")
    @Length(max = 50, message = "department_name khong duoc dai qua 50 ki tu")
    private String name;
}
