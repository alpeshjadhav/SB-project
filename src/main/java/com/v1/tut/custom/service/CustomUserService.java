package com.v1.tut.custom.service;

import com.v1.tut.custom.model.UserApiModel;
import com.v1.tut.custom.model.UserDTO;
import com.v1.tut.custom.model.UsersResponse;
import com.v1.tut.custom.model.UsersResponseFlat;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<UserDTO> fetchUsersFromApi1() {
        String url = "https://dummyjson.com/users";
        UsersResponse response = restTemplate.getForObject(url, UsersResponse.class);

        return response != null ? response.getUsers().stream()
                .map(this::mapToUserDTO)
                .collect(Collectors.toList()) : List.of();
    }

    public List<UserApiModel> fetchUsersFromApi11() {
        String url = "https://dummyjson.com/users";
        UsersResponseFlat response = restTemplate.getForObject(url, UsersResponseFlat.class);
        return response != null ? response.getUsers() : List.of();
    }

    private final WebClient webClient = WebClient.builder().baseUrl("https://dummyjson.com").build();

    public List<UserDTO> fetchUsersFromApi2() {
        UsersResponse response = webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToMono(UsersResponse.class)
                .block();

        return response != null ? response.getUsers().stream()
                .map(this::mapToUserDTO)
                .collect(Collectors.toList()) : List.of();
    }

    private UserDTO mapToUserDTO(UserApiModel userApiModel) {
        return new UserDTO(
                userApiModel.getId(),
                userApiModel.getFirstName(),
                userApiModel.getLastName(),
                userApiModel.getAge(),
                userApiModel.getEmail(),
                userApiModel.getUsername(),
                userApiModel.getIp(),
                userApiModel.getAddress().getAddress(),
                userApiModel.getAddress().getCity(),
                userApiModel.getAddress().getState(),
                userApiModel.getAddress().getStateCode(),
                userApiModel.getAddress().getPostalCode(),
                userApiModel.getCompany().getName(),
                userApiModel.getCompany().getDepartment(),
                userApiModel.getCompany().getTitle(),
                userApiModel.getRole()
        );
    }
}
