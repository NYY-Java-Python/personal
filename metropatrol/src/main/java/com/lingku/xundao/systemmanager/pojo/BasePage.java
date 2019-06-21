package com.lingku.xundao.systemmanager.pojo;

import java.io.Serializable;

/**
 * @author NYY
 * @2019年6月21日
 * @description 分页信息
 */
public class BasePage implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private Integer currentPage;
	// 当前页

	private Integer pageSize;
	// 每页显示个数

	public BasePage() {
		super();

	}

	public BasePage(Integer currentPage, Integer pageSize) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "BasePage [currentPage=" + currentPage + ", pageSize=" + pageSize + "]";
	}
}
