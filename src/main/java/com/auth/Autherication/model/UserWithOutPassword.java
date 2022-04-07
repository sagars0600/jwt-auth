package com.auth.Autherication.model;

import com.auth.Autherication.constfile.ConstFiles;
import com.auth.Autherication.enums.BloodGroup;
import com.auth.Autherication.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class UserWithOutPassword {
    @Id
    private String userId;

    @NotEmpty(message = ConstFiles.firstName)
    private String firstName;

    @NotEmpty(message = "Middle name is required")
    private String middleName;

    @NotEmpty(message = "Last name is required")
    private String lastName;

    @NotEmpty(message = "Phone Number is required")
    @Size(min=10,max = 10)
    private String phoneNumber;

    @NotNull(message = "Date of Birth is required")
    private Date dateOfBirth;

    @NotEmpty(message = "Gender is required")
    private Gender gender;

    @NotEmpty(message = "address is required")
    private String address ;

    @NotEmpty(message = "Employee Number is required")
    private String employeeNumber;

    @NotEmpty(message = "Blood Group is required")
    private BloodGroup bloodGroup;

    @NotEmpty(message = "Email is required")
    private String email;

}
