package com.gemini.springboot.grouptwo.leaveapplicationspringboot.dao;

import com.gemini.springboot.grouptwo.leaveapplicationspringboot.entity.Leave;

import java.util.List;

public interface ILeaveDAO {
    List<Leave> getLeaves();
    Leave getLeave(int leaveId);
    Leave createLeave(Leave leave);
    Leave updateLeave(int id, Leave leave);
    boolean deleteLeave(int id);
}
