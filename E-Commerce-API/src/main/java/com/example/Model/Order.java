package com.example.Model;

import com.example.Model.Enums.Category;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productOrder") // because order is keyword in mysql so it shows error that's why I changed name here
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=Order.class,property="orderId")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @Enumerated(EnumType.STRING)
    private Category productCategory;
    @NotBlank
    private String productName;
    private Integer productPrice;
    @Min(value = 1)
    private Integer quantity;
    @NotBlank
    private String address;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // I want to hide it from jason that why I used it I will set it manually each time
    private LocalDateTime orderDateTime;

    @ManyToOne
    @JoinColumn(name = "fk_user_id" )
    User user;
}
