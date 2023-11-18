package com.microdevs.authservice.entity;

import com.microdevs.baseservice.entity.BaseEntity;
import com.microdevs.baseservice.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(sequenceName = "user_sequence", name = "user_sequence", allocationSize = 1)
    private Long id;
    private String first_name;
    private String last_name;
    private String phone;
    private String email;
    @Enumerated(EnumType.STRING)
    private StatusType status = StatusType.ACTIVE;

}