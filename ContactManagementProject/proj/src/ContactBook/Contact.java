package ContactBook;

import java.sql.Date;

public class Contact {
	
	protected int contact_id;
	protected String first_name;
	protected String middle_name;
	protected String last_name;
	protected String home_phone;
	protected String cell_phone;
	protected String home_address;
	protected String home_city;
	protected String home_state;
	protected int home_zip;
	protected String work_phone;
	protected String work_address;
	protected String work_city;
	protected String work_state;
	protected int work_zip;
	protected Date birth_date;
	
	public int getContact_id() {
		return contact_id;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getHome_phone() {
		return home_phone;
	}

	public void setHome_phone(String home_phone) {
		this.home_phone = home_phone;
	}

	public String getCell_phone() {
		return cell_phone;
	}

	public void setCell_phone(String cell_phone) {
		this.cell_phone = cell_phone;
	}

	public String getHome_address() {
		return home_address;
	}

	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}

	public String getHome_city() {
		return home_city;
	}

	public void setHome_city(String home_city) {
		this.home_city = home_city;
	}

	public String getHome_state() {
		return home_state;
	}

	public void setHome_state(String home_state) {
		this.home_state = home_state;
	}

	public int getHome_zip() {
		return home_zip;
	}

	public void setHome_zip(int home_zip) {
		this.home_zip = home_zip;
	}

	public String getWork_phone() {
		return work_phone;
	}

	public void setWork_phone(String work_phone) {
		this.work_phone = work_phone;
	}

	public String getWork_address() {
		return work_address;
	}

	public void setWork_address(String work_address) {
		this.work_address = work_address;
	}

	public String getWork_city() {
		return work_city;
	}

	public void setWork_city(String work_city) {
		this.work_city = work_city;
	}

	public String getWork_state() {
		return work_state;
	}

	public void setWork_state(String work_state) {
		this.work_state = work_state;
	}

	public int getWork_zip() {
		return work_zip;
	}

	public void setWork_zip(int work_zip) {
		this.work_zip = work_zip;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	

	public Contact() {
	}

	public Contact(int contact_id) {
		this.contact_id = contact_id;
	}

	public Contact(int contact_id, String first_name, String middle_name, String last_name, String home_phone,String cell_phone, String home_address,String home_city,String home_state, int home_zip,String work_phone,String work_address,String work_city,String work_state,int work_zip,Date birth_date) {
		this(first_name, middle_name, last_name, home_phone, cell_phone, home_address, home_city,home_state,home_zip,work_phone,work_address,work_city,work_state,work_zip,birth_date);
		this.contact_id = contact_id;
	}
	
	public Contact( String first_name, String middle_name, String last_name, String home_phone,String cell_phone, String home_address,String home_city,String home_state, int home_zip,String work_phone,String work_address,String work_city,String work_state,int work_zip,Date birth_date) {
		this.first_name=first_name;
		this.middle_name=middle_name;
		this.last_name=last_name;
		this.home_phone=home_phone;
		this.cell_phone=cell_phone;
		this.home_address=home_address;
		this.home_city=home_city;
		this.home_state=home_state;
		this.home_zip=home_zip;
		this.work_phone=work_phone;
		this.work_address=work_address;
		this.work_city=work_city;
		this.work_state=work_state;
		this.work_zip=work_zip;
		this.birth_date=birth_date;
	}


}
