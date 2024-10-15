package com.v1.tut.service;

import com.v1.tut.model.Address;
import com.v1.tut.model.User;
import com.v1.tut.model.UserDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    public List<User> fetchUsersFromApi() {
        return List.of(
                new User("1", "John", "john@example.com", LocalDateTime.now().minusHours(2), null,
                        new Address("123 Main St", "New York")),
                new User("2", "Jane", "jane@example.com", LocalDateTime.now().minusDays(1), LocalDateTime.now(),
                        new Address("456 Elm St", "Los Angeles")),
                new User("3", "Doe", "doe@example.com", LocalDateTime.now().minusDays(10), LocalDateTime.now().minusDays(9),
                        new Address("789 Oak St", "Chicago")),
                new User("4", "Alex", "alex@example.com", LocalDateTime.now().minusMonths(1), null,
                        new Address("101 Maple St", "Boston")),
                new User("5", "Emily", "emily@example.com", LocalDateTime.now(), LocalDateTime.now(),
                        new Address("202 Pine St", "Houston")),
                new User("6", "Michael", "michael@example.com", LocalDateTime.now().minusYears(1), LocalDateTime.now().minusMonths(6),
                        new Address("303 Cedar St", "Phoenix")),
                new User("7", "Sophie", "sophie@example.com", LocalDateTime.now().minusDays(2), LocalDateTime.now().minusHours(1),
                        null), // Null Address
                new User("8", "John", "john.doe@example.com", LocalDateTime.now().minusWeeks(1), LocalDateTime.now().minusDays(1),
                        new Address("987 Birch St", "San Francisco")),
                new User("9", "Jane", "jane.smith@example.com", LocalDateTime.now().minusDays(5), LocalDateTime.now(),
                        new Address("654 Walnut St", "Seattle")),
                new User("10", "William", "william@example.com", LocalDateTime.now().minusMonths(3), LocalDateTime.now().minusWeeks(2),
                        null),
                new User("1", "John", "john@example.com", LocalDateTime.now().minusHours(2), LocalDateTime.now(),
                        new Address("123 Main St", "New York")),
                new User("5", "Emily", "emily@example.com", LocalDateTime.now(), LocalDateTime.now().minusDays(1),
                        new Address("202 Pine St", "Houston"))
        );
    }

    public UserDTO convertToUserDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreateDate(),
                user.getUpdateDate(),
                user.getAddress() != null ? user.getAddress().getStreet() : null,
                user.getAddress() != null ? user.getAddress().getCity() : null
        );
    }

    public List<UserDTO> getUniqueUsers() {
        List<User> users = fetchUsersFromApi();
        Set<User> uniqueUsers = new HashSet<>(users);
        return uniqueUsers.stream()
                .map(this::convertToUserDTO)
                .collect(Collectors.toList());
    }

    // Method to get users created today (returning UserDTO)
    public List<UserDTO> getUsersCreatedToday() {
        Set<String> uniqueIds = new HashSet<>();
        return getUniqueUsers().stream()
                .filter(userDTO -> userDTO.getCreateDate() != null && userDTO.getCreateDate().toLocalDate().equals(LocalDate.now()))
                .filter(userDTO -> uniqueIds.add(userDTO.getId()))
                .collect(Collectors.toList());
    }

    // Method to get users updated today (returning UserDTO)
    public List<UserDTO> getUsersUpdatedToday() {
        Set<String> uniqueIds = new HashSet<>();
        return getUniqueUsers().stream()
                .filter(userDTO -> userDTO.getUpdateDate() != null && userDTO.getUpdateDate().toLocalDate().equals(LocalDate.now()))
                .filter(userDTO -> uniqueIds.add(userDTO.getId()))
                .collect(Collectors.toList());
    }
}
