package poly.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Records")
public class Record {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "Type")
	private int type;

	@Column(name = "Reason")
	private String reason;

	@Column(name = "Date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "StaffID")
	private Staff staff;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}
