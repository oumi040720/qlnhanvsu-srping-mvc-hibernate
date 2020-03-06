package poly.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Staffs")
public class Staff {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Gender")
	private Boolean gender;

	@Column(name = "Birthday")
	private String birthDay;

	@Column(name = "Photo")
	private String photo;

	@Column(name = "Email")
	private String email;

	@Column(name = "Phone")
	private String phone;

	@Column(name = "Salary")
	private Long salary;

	@Column(name = "Notes")
	private String notes;

	@ManyToOne
	@JoinColumn(name = "DepartID")
	private Depart depart;

	@OneToMany(mappedBy = "staff", fetch = FetchType.EAGER)
	private Collection<Record> records;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

	public Collection<Record> getRecords() {
		return records;
	}

	public void setRecords(Collection<Record> records) {
		this.records = records;
	}

}
