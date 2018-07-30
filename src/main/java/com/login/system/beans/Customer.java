package com.login.system.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

	@Entity
	@Table  // no need to mention table name by default it takes class name
	public class Customer {

		@Id
		@Column
		@GeneratedValue(strategy=GenerationType.AUTO)// it will generate unique Id automatically
		private int c_id;
		
		@NotEmpty
		@Column
		private String c_name;
		
		@NotEmpty
		@Column
		private String c_mobile;
		
		@NotEmpty
		@Column
		private String c_gender;
		
		@NotEmpty
		@Column
		private String c_email;
		
		@NotEmpty
		@Column
		private String c_password;
		
		//setters and getters
		public int getC_id() {
			return c_id;
		}
		public void setC_id(int c_id) {
			this.c_id = c_id;
		}
		public String getC_name() {
			return c_name;
		}
		public void setC_name(String c_name) {
			this.c_name = c_name;
		}
		public String getC_mobile() {
			return c_mobile;
		}
		public void setC_mobile(String c_mobile) {
			this.c_mobile = c_mobile;
		}
		public String getC_gender() {
			return c_gender;
		}
		public void setC_gender(String c_gender) {
			this.c_gender = c_gender;
		}
		public String getC_email() {
			return c_email;
		}
		public void setC_email(String c_email) {
			this.c_email = c_email;
		}
		public String getC_password() {
			return c_password;
		}
		public void setC_password(String c_password) {
			this.c_password = c_password;
		}
		
		
	}

