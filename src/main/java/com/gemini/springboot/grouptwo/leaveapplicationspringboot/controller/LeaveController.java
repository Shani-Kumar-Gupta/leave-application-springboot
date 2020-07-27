package com.gemini.springboot.grouptwo.leaveapplicationspringboot.controller;

import com.gemini.springboot.grouptwo.leaveapplicationspringboot.entity.Leave;
import com.gemini.springboot.grouptwo.leaveapplicationspringboot.exception.RecordNotFoundException;
import com.gemini.springboot.grouptwo.leaveapplicationspringboot.service.ILeaveService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/leave")
public class LeaveController {

    Logger logger = LoggerFactory.getLogger(LeaveController.class);

    @Autowired
    private ILeaveService service;

    @GetMapping("/leaves")
    @ApiOperation(value = "Find all the leaves details",
            notes = "Put the particular api to get all the leave details",
            response = Leave.class)
    public ResponseEntity<List<Leave>> getLeaves(){
        List<Leave> leaves = service.getLeaves();
        logger.trace("/leaves api call to getLeaves method");
        return new ResponseEntity<List<Leave>>(leaves, HttpStatus.OK);
    }

    @GetMapping("/leaves/{id}")
    @ApiOperation(value = "Find the leave details using leave id",
            notes = "Get the particular leave details using leave id",
            response = Leave.class)
    public ResponseEntity<Leave> getLeave(@PathVariable("id") Integer id) throws RecordNotFoundException {
        Leave leave = service.getLeave(id);
        logger.trace("/leave/{id} api call to getLeave method");
        return new ResponseEntity<Leave>(leave,HttpStatus.OK);
    }

    @PostMapping("/leaves")
    @ApiOperation(value = "Apply for new leave",
            notes = "Apply for new leave this specific details",
            response = Leave.class)
    public ResponseEntity<Leave> createLeave(@RequestBody Leave leave) {
        Leave l = service.createLeave(leave);
        logger.trace("/leaves POST api call to createLeave method");
        return new ResponseEntity<Leave>(l,HttpStatus.OK);
    }

    @PutMapping("/leaves/{id}")
    @ApiOperation(value = "Update leaves using leave id",
            notes = "Update particular leave details using leave id",
            response = Leave.class)
    public ResponseEntity<Leave> updateLeave(@PathVariable("id") int id, @RequestBody Leave leave) throws RecordNotFoundException{
        Leave l = service.updateLeave(id,leave);
        logger.trace("/leaves/{id} PUT api call to updateLeave method");
        return new ResponseEntity<Leave>(l,HttpStatus.OK);
    }

    @DeleteMapping("/leaves/{id}")
    @ApiOperation(value = "Delete leave using leave id",
            notes = "Delete the particular leave deatail using leave id",
            response = Leave.class)
    public ResponseEntity<String> deleteLeave(@PathVariable("id") int id) throws RecordNotFoundException{
        boolean isDeleted = service.deleteLeave(id);
        if(isDeleted){
            String responseContent = "Leave details has been deleted successfully";
            logger.trace("/leaves/{id} DELETE api call successfully and delete leave details");
            return new ResponseEntity<String>(responseContent,HttpStatus.OK);
        }
        String error = "Error while deleteing leaves from database";
        logger.error("Erro while deleteing leaves from database coming");
        return new ResponseEntity<String>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
