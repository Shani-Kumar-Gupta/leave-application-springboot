/*
Created By: Shani Kumar Gupta
*/
package com.gemini.springboot.grouptwo.leaveapplicationspringboot.dao;

import com.gemini.springboot.grouptwo.leaveapplicationspringboot.entity.Leave;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class LeaveDAO implements ILeaveDAO{

    Logger logger = LoggerFactory.getLogger(LeaveDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Leave> getLeaves(){
        String hql="FROM Leave as lev ORDER BY lev.id";
        logger.trace("Get all leaves successfully");
        return (List<Leave>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Leave getLeave(int leaveId){
        logger.trace("Get leave details using leave id");
        return entityManager.find(Leave.class, leaveId);
    }

    @Override
    public Leave createLeave(Leave leave){
        entityManager.persist(leave);
        Leave l = getLastInsertedLeave();
        logger.trace("createLeave method call another getLastInsertedLeave method");
        return l;
    }

    @Override
    public Leave updateLeave(int leaveId, Leave leave){
        Leave leaveDB = getLeave(leaveId);
        leaveDB.setReason(leave.getReason());
        leaveDB.setStartDate(leave.getStartDate());
        leaveDB.setEndDate(leave.getEndDate());
        leaveDB.setIsHalfDay(leave.getisHalfDay());
        leaveDB.setStatus(leave.getStatus());
        leaveDB.setLeaveType(leave.getLeaveType());
        leaveDB.setAppliedDate(leave.getAppliedDate());
        leaveDB.setUpdatedDate(leave.getUpdatedDate());

        entityManager.flush();

        Leave updatedLeave = getLeave(leaveId);
        logger.trace("update leave successfully");
        return updatedLeave;
    }

    @Override
    public boolean deleteLeave(int leaveId){
        Leave leave = getLeave(leaveId);
        entityManager.remove(leave);

        boolean status = entityManager.contains(leave);
        if(status){
            logger.error("leave id doesn't match");
            return false;
        }
        return true;
    }

    private Leave getLastInsertedLeave(){
        String hql = "from Leave order by id DESC";
        Query query = entityManager.createQuery(hql);
        query.setMaxResults(1);
        Leave leave = (Leave)query.getSingleResult();
        logger.trace("applied leave succefully");
        return leave;
    }

}
