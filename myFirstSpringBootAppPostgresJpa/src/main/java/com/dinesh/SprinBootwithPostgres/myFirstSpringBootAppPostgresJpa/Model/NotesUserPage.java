package com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Model;

import org.springframework.data.domain.Sort;

public class NotesUserPage {
	
	private int pagenumber = 0;
	
	private int pageSize = 10;
	
	private Sort.Direction sortDirection = Sort.Direction.ASC;
	
	private String sortBy = "age";

	public int getPagenumber() {
		return pagenumber;
	}

	public void setPagenumber(int pagenumber) {
		this.pagenumber = pagenumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Sort.Direction getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(Sort.Direction sortDirection) {
		this.sortDirection = sortDirection;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	
	

}
