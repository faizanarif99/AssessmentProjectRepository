package com.assesmentproject.services;


import com.assesmentproject.config.BusinessException;
import com.assesmentproject.dtos.GetAllUserResponseDto;
import com.assesmentproject.dtos.GetCommentsResponseDto;
import com.assesmentproject.dtos.GetPostsResponseDto;
import com.assesmentproject.dtos.ResponseDto;
import com.assesmentproject.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String GET_ALL_USERS_API_URL = "https://gorest.co.in/public/v2/users";
    private static final String GET_THE_POSTS_API_URL = "https://gorest.co.in/public/v2/posts";
    private static final String GET_THE_COMMENTS_API_URL = "https://gorest.co.in/public/v2/comments";


    @Override
    public ResponseDto getAllUsers() throws Exception {

        // getting all users data
        logger.info("UserServiceImpl::getAllUsers Start Execution...");
        ResponseDto responseDto = new ResponseDto();
        // URL to get the users:
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(GET_ALL_USERS_API_URL))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String responseBody = response.body();
                ObjectMapper objectMapper = new ObjectMapper();

                responseDto.setData(objectMapper.readValue(responseBody, new TypeReference<List<GetAllUserResponseDto>>() {
                }));
            }
            BusinessException.successActionResult(responseDto, Constants.SUCCESS_MESSAGE, Constants.SUCCESS_CODE);
        } catch (Exception exception) {
            BusinessException.errorActionResult(responseDto, exception.getMessage(), Constants.API_RESPONSE_CODE_BAD_REQUEST_ERROR);
            exception.printStackTrace();
        } finally {
            logger.info("UserServiceImpl::getAllUsers End Execution...");
        }
        return responseDto;
    }

    @Override
    public ResponseDto getThePosts() throws Exception {

        // getting the posts
        logger.info("UserServiceImpl::getThePosts Start Execution...");
        ResponseDto responseDto = new ResponseDto();
        // URL to get the users:
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(GET_THE_POSTS_API_URL))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String responseBody = response.body();
                ObjectMapper objectMapper = new ObjectMapper();

                responseDto.setData(objectMapper.readValue(responseBody, new TypeReference<List<GetPostsResponseDto>>() {
                }));
            }
            BusinessException.successActionResult(responseDto, Constants.SUCCESS_MESSAGE, Constants.SUCCESS_CODE);
        } catch (Exception exception) {
            BusinessException.errorActionResult(responseDto, exception.getMessage(), Constants.API_RESPONSE_CODE_BAD_REQUEST_ERROR);
            exception.printStackTrace();
        } finally {
            logger.info("UserServiceImpl::getThePosts End Execution...");
        }
        return responseDto;
    }

    @Override
    public ResponseDto getTheComments() throws Exception {

        // getting the comments
        logger.info("UserServiceImpl::getTheComments Start Execution...");
        ResponseDto responseDto = new ResponseDto();
        // URL to get the users:
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(GET_THE_COMMENTS_API_URL))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String responseBody = response.body();
                ObjectMapper objectMapper = new ObjectMapper();

                responseDto.setData(objectMapper.readValue(responseBody, new TypeReference<List<GetCommentsResponseDto>>() {
                }));
            }
            BusinessException.successActionResult(responseDto, Constants.SUCCESS_MESSAGE, Constants.SUCCESS_CODE);
        } catch (Exception exception) {
            BusinessException.errorActionResult(responseDto, exception.getMessage(), Constants.API_RESPONSE_CODE_BAD_REQUEST_ERROR);
            exception.printStackTrace();
        } finally {
            logger.info("UserServiceImpl::getTheComments End Execution...");
        }
        return responseDto;
    }

}
