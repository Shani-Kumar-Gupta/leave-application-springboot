/*
Created By: Shani Kumar Gupta
*/
package com.gemini.springboot.grouptwo.leaveapplicationspringboot.service;

import com.gemini.springboot.grouptwo.leaveapplicationspringboot.dao.ILeaveDAO;
import com.gemini.springboot.grouptwo.leaveapplicationspringboot.entity.Leave;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService implements ILeaveService{

    @Autowired
    private ILeaveDAO dao;

    @Override
    public List<Leave> getLeaves(){
        return dao.getLeaves();
    }

    @Override
    public Leave createLeave(Leave leave){
        return dao.createLeave(leave);
    }

    @Override
    public Leave updateLeave(int leaveId, Leave leave){
        return dao.updateLeave(leaveId,leave);
    }

    @Override
    public Leave getLeave(int leaveId){
        return dao.getLeave(leaveId);
    }

    @Override
    public boolean deleteLeave(int leaveId){
        return dao.deleteLeave(leaveId);
    }
}
