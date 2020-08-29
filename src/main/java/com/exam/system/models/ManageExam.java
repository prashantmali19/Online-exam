package com.exam.system.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.NonNull;
import net.bytebuddy.implementation.bind.annotation.Empty;

@Entity
public class ManageExam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ManageExamid;
	@NonNull
	private String category;
	@NotNull
	private String examname;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date examdate;


	public long getManageExamid() {
		return ManageExamid;
	}

	public void setManageExamid(long manageExamid) {
		ManageExamid = manageExamid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public Date getExamdate() {
		return examdate;
	}

	public void setExamdate(Date examdate) {
		this.examdate = examdate;
	}

	

	


	
}
