package com.auth.Autherication.model;

import com.auth.Autherication.constfile.ConstFiles;
import com.auth.Autherication.enums.BloodGroup;
import com.auth.Autherication.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;



@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserDto {

@Id
private String userId;
 @NotEmpty(message=ConstFiles.firstName)
    private String firstName;
    @NotEmpty(message = "Middle name is required")
    private String middleName;
    @NotEmpty(message = "Last name is required")
    private String lastName;
    @NotEmpty(message = "Phone Number is required")
    @Size(min=10,max = 10)
    private String phoneNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private Gender gender;
    @NotEmpty(message = "address is required")
    private String address ;
    @NotEmpty(message = "Employee Number is required")
    private String employeeNumber;
    private BloodGroup bloodGroup;
    @Pattern(regexp = "^[\\wA-Za-z0-9]+(?:\\.[\\wA-Za-z0-9+_-]+[A-Za-z0-9]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "please enter proper email")
    private String email;
    @NotEmpty(message = "Password is required")
    private String password;
}
