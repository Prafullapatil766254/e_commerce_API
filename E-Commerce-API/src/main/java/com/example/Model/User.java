package com.example.Model;

import com.example.Model.Enums.Gender;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=User.class,property="userId") // when we will try to get it will stuck into a loop because of bidirectional mapping so that's I written this annotation.
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // for auto increment
    private Integer userId;
    @NotBlank
    private String userName;
    @Enumerated(EnumType.STRING) // for save as an string in database
    private Gender gender;
    @Pattern(regexp = "^\\w+@gmail\\.com$") // used regex for email means it should be atleast end with gmail.com
    private String userEmail;
    @NotBlank
    private String userPassword;
    @NotBlank
    private String userMobileNo;

    @OneToMany(mappedBy = "user") // used mapped by to avoid a redundant foreign key..
    List<Order> order;
}
