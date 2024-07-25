package com.assesmentproject.services;

import com.assesmentproject.dtos.ResponseDto;

public interface UserService {

    ResponseDto getAllUsers() throws Exception;

    ResponseDto getThePosts() throws Exception;

    ResponseDto getTheComments() throws Exception;
}
