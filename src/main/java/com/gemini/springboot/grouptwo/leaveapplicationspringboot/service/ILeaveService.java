/*
Created By: Shani Kumar Gupta
*/
package com.gemini.springboot.grouptwo.leaveapplicationspringboot.service;

import com.gemini.springboot.grouptwo.leaveapplicationspringboot.entity.Leave;

import java.util.List;

public interface ILeaveService {

    List<Leave> getLeaves();
    Leave createLeave(Leave leave);
    Leave updateLeave(int id, Leave leave);
    Leave getLeave(int leaveId);
    boolean deleteLeave(int id);
}
