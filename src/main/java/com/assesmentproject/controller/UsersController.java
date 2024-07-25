package com.assesmentproject.controller;


import com.assesmentproject.config.BusinessException;
import com.assesmentproject.dtos.ResponseDto;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.assesmentproject.services.UserService;
import com.assesmentproject.utils.Constants;

@RestController
@Api(value = "UserController")
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @RequestMapping(value = "/getallusers", method = RequestMethod.GET)
    public ResponseDto getAllUsers() {

        // Get all the users API implementation
        logger.info("Get all the users start execution");
        Long startTime = System.currentTimeMillis();
        ResponseDto responseDto = null;
        try {
            responseDto = userService.getAllUsers();
            BusinessException.successActionResult(responseDto, Constants.SUCCESS_MESSAGE, Constants.SUCCESS_CODE);
        } catch (Exception exception) {
            BusinessException.errorActionResult(responseDto, Constants.FAILURE_MESSAGE, exception.getMessage());
        }
        Long endTime = System.currentTimeMillis();
        Long responseTime = endTime - startTime;
        responseDto.setResponseTime(responseTime + "ms");
        logger.info("Get all the users Ends at " + responseTime);
        return responseDto;
    }

    @RequestMapping(value = "/gettheposts", method = RequestMethod.GET)
    public ResponseDto getThePosts() {

        // Get the posts API
        logger.info("Get the posts start execution");
        Long startTime = System.currentTimeMillis();
        ResponseDto responseDto = null;
        try {
            responseDto = userService.getThePosts();
            BusinessException.successActionResult(responseDto, Constants.SUCCESS_MESSAGE, Constants.SUCCESS_CODE);
        } catch (Exception exception) {
            BusinessException.errorActionResult(responseDto, Constants.FAILURE_MESSAGE, exception.getMessage());
        }
        Long endTime = System.currentTimeMillis();
        Long responseTime = endTime - startTime;
        responseDto.setResponseTime(responseTime + "ms");
        logger.info("Get the posts Ends at " + responseTime);
        return responseDto;
    }

    @RequestMapping(value = "/getthecomments", method = RequestMethod.GET)
    public ResponseDto getTheComments() {

        // Get the posts API
        logger.info("Get the comments start execution");
        Long startTime = System.currentTimeMillis();
        ResponseDto responseDto = null;
        try {
            responseDto = userService.getTheComments();
            BusinessException.successActionResult(responseDto, Constants.SUCCESS_MESSAGE, Constants.SUCCESS_CODE);
        } catch (Exception exception) {
            BusinessException.errorActionResult(responseDto, Constants.FAILURE_MESSAGE, exception.getMessage());
        }
        Long endTime = System.currentTimeMillis();
        Long responseTime = endTime - startTime;
        responseDto.setResponseTime(responseTime + "ms");
        logger.info("Get the comments Ends at " + responseTime);
        return responseDto;
    }
}
