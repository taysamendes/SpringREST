package com.algaworks.osapi.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class Problem {
	private Integer status;
	private LocalDateTime dateHour;
	private String title;
	private List<Campo> campos;

	public static class Campo {
		private String name;
		private String msg;

		public Campo(String name, String msg) {
			super();
			this.name = name;
			this.msg = msg;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getDateHour() {
		return dateHour;
	}

	public void setDateHour(LocalDateTime dateHour) {
		this.dateHour = dateHour;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Campo> getCampos() {
		return campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}

}