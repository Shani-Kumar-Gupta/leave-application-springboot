/*
Created By: Shani Kumar Gupta
*/
package com.gemini.springboot.grouptwo.leaveapplicationspringboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "leavedetails")
@ApiModel(description = "Details about the leave")
public class Leave implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty(notes = "The unique id of the leave detail")
    private int id;

    @Column(name = "reason")
    @ApiModelProperty(notes = "The reason for the leave")
    private String reason;

    @Column(name = "startDate")
    @ApiModelProperty(notes = "Starting Date of the leave")
    private String startDate;

    @Column(name = "endDate")
    @ApiModelProperty(notes = "End Date of the leave")
    private String endDate;

    @Column(name = "isHalfDay")
    @ApiModelProperty(notes = "Option for provide Half Day info")
    private boolean isHalfDay;

    @Column(name = "leaveType")
    @ApiModelProperty(notes = "It is the levae type like: CL,PL,LWP")
    private String leaveType;

    @Column(name = "status")
    @ApiModelProperty(notes = "Status about leave like: Applied, Approved, Rejected or Avaited")
    private String status;

    @Column(name = "appliedDate")
    @ApiModelProperty(notes = "Applied date of the leave")
    private String appliedDate;

    @Column(name = "updatedDate")
    @ApiModelProperty(notes = "Updated date of the leave")
    private String updatedDate;

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean getisHalfDay() {
        return isHalfDay;
    }

    public void setIsHalfDay(boolean isHalfDay) {
        this.isHalfDay = isHalfDay;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

}
