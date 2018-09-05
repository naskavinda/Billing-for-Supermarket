package com.ruhuna.project.supermarketcore.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "users_id_seq")
    private int id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @ApiModelProperty(notes = "Users Name", required = true)
    private String userName;

    @NotNull
    @ApiModelProperty(notes = "Password", required = true)
    private String password;

    @ApiModelProperty(notes = "Status", required = true)
    @Column(columnDefinition = "BOOLEAN default TRUE")
    private Boolean status;
}
