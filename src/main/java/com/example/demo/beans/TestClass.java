package com.example.demo.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Entity(name = "TestClass")
@Table(name = "test_class", uniqueConstraints = { @UniqueConstraint(columnNames = { "aadhar_card_number" }) })
@EntityListeners(AuditingEntityListener.class)
@TypeDefs({ @TypeDef(name = "AddressType", typeClass = AddressType.class) })
@Api(value = "TestCase", description = "This is just a TestClass Classs")
public class TestClass implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@ApiModelProperty(notes = "Primary key")
	private Long id;
	@Column(name = "aadhar_card_number", updatable = false)
	@NotBlank(message = "Aadhar Card Number Field Cannon't be Blank")
	private String aadharCardNumber;

	@Column(name = "dob")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dob;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	@Email(message = "You Must Enter A Valid Email ID")
	private String email;

	@Column(name = "address", columnDefinition = "jsonb", insertable = true, nullable = false, updatable = true, unique = false)
	@Type(type = "AddressType")
	// @NotBlank(message = "Address of the Customer")
	@ApiModelProperty(notes = "Address of the Customer")
	private Address address;

	public TestClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestClass(Long id, @NotBlank(message = "Aadhar Card Number Field Cannon't be Blank") String aadharCardNumber,
			Date dob, String firstName, String lastName,
			@Email(message = "You Must Enter A Valid Email ID") String email, Address address) {
		super();
		this.id = id;
		this.aadharCardNumber = aadharCardNumber;
		this.dob = dob;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAadharCardNumber() {
		return aadharCardNumber;
	}

	public void setAadharCardNumber(String aadharCardNumber) {
		this.aadharCardNumber = aadharCardNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aadharCardNumber == null) ? 0 : aadharCardNumber.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestClass other = (TestClass) obj;
		if (aadharCardNumber == null) {
			if (other.aadharCardNumber != null)
				return false;
		} else if (!aadharCardNumber.equals(other.aadharCardNumber))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TestClass [id=" + id + ", aadharCardNumber=" + aadharCardNumber + ", dob=" + dob + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", address=" + address + "]";
	}

}
