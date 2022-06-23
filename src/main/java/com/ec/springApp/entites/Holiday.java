package com.ec.springApp.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Holiday {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHoliday;

	private int numberDay;

	private String description;

	private String status;

	@DateTimeFormat(pattern = "dd-M-yyyy hh:mm:ss")
	private Date beginDate;

	@DateTimeFormat(pattern = "dd-M-yyyy hh:mm:ss")
	private Date endDate;

	@ManyToOne
	private Consumer consumerAdmin;

	@ManyToOne
	private Consumer consumerDemand;

	public Long getIdHoliday() {
		return idHoliday;
	}

	public void setIdHoliday(Long idHoliday) {
		this.idHoliday = idHoliday;
	}

	public int getNumberDay() {
		return numberDay;
	}

	public void setNumberDay(int numberDay) {
		this.numberDay = numberDay;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Consumer getConsumerAdmin() {
		return consumerAdmin;
	}

	public void setConsumerAdmin(Consumer consumerAdmin) {
		this.consumerAdmin = consumerAdmin;
	}

	public Consumer getConsumerDemand() {
		return consumerDemand;
	}

	public void setConsumerDemand(Consumer consumerDemand) {
		this.consumerDemand = consumerDemand;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
