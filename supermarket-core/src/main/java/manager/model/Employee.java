package manager.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_id_seq", sequenceName = "employee_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_id_seq")
    private int id;

    @NotNull(message = "First Name Can't be Null")
    @ApiModelProperty(notes = "First Name", required = true)
    private String firstName;

    @ApiModelProperty(notes = "Last Name", required = true)
    private String lastName;

    @ApiModelProperty(notes = "NIC", required = true)
    private String nic;

    @NotNull(message = "Telephone Number Can't be null")
    @ApiModelProperty(notes = "Telephone Number", required = true)
    private String tp1;

    @ApiModelProperty(notes = "Telephone Number")
    private String tp2;

    @NotNull(message = "Address Line One can't be null")
    @ApiModelProperty(notes = "Address Line One", required = true)
    private String addressLineOne;

    @ApiModelProperty(notes = "Address Line Two")
    private String addressLineTwo;

    @ApiModelProperty(notes = "Address Line Three", required = true)
    private String addressLineThree;

    @ApiModelProperty(notes = "Status", required = true)
    @Column(columnDefinition = "BOOLEAN default TRUE")
    private Boolean status;
}
