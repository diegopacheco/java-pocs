package com.github.diegopacheco.design.patterns._extra.converter;

import java.util.Objects;

public class UserDto {

    private String firstName;
    private String lastName;
    private boolean isActive;
    private String email;

    public UserDto(String firstName, String lastName, boolean isActive, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public boolean isActive() {
        return isActive;
    }
    public String getEmail() {
        return email;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDto userDto = (UserDto) o;
        return isActive == userDto.isActive && Objects.equals(firstName, userDto.firstName) && Objects
                .equals(lastName, userDto.lastName) && Objects.equals(email, userDto.email);
    }

    @Override public int hashCode() {
        return Objects.hash(firstName, lastName, isActive, email);
    }

    @Override public String toString() {
        return "UserDto{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
                + ", isActive=" + isActive + ", email='" + email + '\'' + '}';
    }
}
