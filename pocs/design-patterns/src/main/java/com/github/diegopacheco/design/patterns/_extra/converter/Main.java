package com.github.diegopacheco.design.patterns._extra.converter;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Converter<UserDto, User> userConverter = new Converter<>(
                userDto -> new User(userDto.getFirstName(), userDto.getLastName(), userDto.isActive(),
                        userDto.getEmail()),
                user -> new UserDto(user.getFirstName(), user.getLastName(), user.isActive(), user.getUserId()));

        UserDto dtoUser = new UserDto("John", "Doe", true, "whatever[at]wherever.com");
        User user = userConverter.convertFromDto(dtoUser);
        System.out.println("Entity converted from DTO:" + user);

        User[] users = {new User("Camile", "Tough", false, "124sad"),
                new User("Marti", "Luther", true, "42309fd"),
                new User("Kate", "Smith", true, "if0243")};
        System.out.println("Domain entities:");
        Arrays.stream(users).forEach(System.out::println);

        System.out.println("DTO entities converted from domain:");
        List<UserDto> dtoEntities = userConverter.createFromEntities(Arrays.asList(users));
        dtoEntities.forEach(System.out::println);
    }
}
