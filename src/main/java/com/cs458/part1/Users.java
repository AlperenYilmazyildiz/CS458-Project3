package com.cs458.part1;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Users")
@Data
public class Users {
    @Id
    Integer Id;
    String Name;
    String Surname;
    String Email;
    String PhoneNumber;
    LocalDate DateOfBirth;
}
