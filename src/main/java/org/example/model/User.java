package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "users_HW")

public class User {
    @Id
    @SequenceGenerator(
            name = "user_HW_sequence",
            sequenceName = "users_HW_id_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_HW_sequence")
    private Long id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private Byte age;

    public User() {
    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public User(Long id, String name, String lastName, Byte age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public String toString() {


        System.out.println("  User id: "+id+ ", name: " + name +", lastName: " + lastName + ", age: " + age );
        System.out.println("———————————————————————————————————————————————————————————————");

        return ",,,,,,,,,";
    }
}