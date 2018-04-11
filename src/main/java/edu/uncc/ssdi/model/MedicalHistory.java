package edu.uncc.ssdi.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "MEDICAL_HISTORY")
public class MedicalHistory {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long medId;
	
	private String digitalId;
	
	private Date dateOfVisit;
	
	private Date dateOfRelease;

	private String hospitalName;

	private String purposeOfVisit;

	private String doctorName;

	private String doctorStatement;

	private String releaseStatus;

	private Set<BlobFileStorage> listsOfId = new HashSet<BlobFileStorage>(0);

	    public MedicalHistory()  {
	    	super();
	    }
	
	public MedicalHistory(Long medId, String digitalId, Date dateOfVisit,Date dateOfRelease, String hospitalName, String purposeOfVisit,
			String doctorName, String doctorStatement, String releaseStatus, Set<BlobFileStorage> listsOfId) {
		super();
		this.medId = medId;
		this.digitalId = digitalId;
		this.dateOfVisit = dateOfVisit;
		this.dateOfRelease = dateOfRelease;
		this.hospitalName = hospitalName;
		this.purposeOfVisit = purposeOfVisit;
		this.doctorName = doctorName;
		this.doctorStatement = doctorStatement;
		this.releaseStatus = releaseStatus;
		this.listsOfId = listsOfId;
	}

	@Id
	@Column(name = "MED_ID")
	public Long getMedId() {
		return medId;
	}

	public void setMedId(Long medId) {
		this.medId = medId;
	}

	
	@Column(name = "DIGITAL_ID")
	public String getDigitalId() {
		return digitalId;
	}

	
	public void setDigitalId(String digitalId) {
		this.digitalId = digitalId;
	}

	@Column(name = "VISIT_DT", nullable = true, length = 10)
	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	
	
	@Column(name = "RELEASE_DT", nullable = true, length = 10)
	public Date getDateOfRelease() {
		return dateOfRelease;
	}

	public void setDateOfRelease(Date dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}

	@Column(name = "HOSPITAL_NAME", nullable = true)
	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	@Column(name = "VISIT_PURPOSE", nullable = true)
	public String getPurposeOfVisit() {
		return purposeOfVisit;
	}

	public void setPurposeOfVisit(String purposeOfVisit) {
		this.purposeOfVisit = purposeOfVisit;
	}

	@Column(name = "DOCTOR_NAME", nullable = true)
	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	@Column(name = "DOC_STATEMENT", nullable = true)
	public String getDoctorStatement() {
		return doctorStatement;
	}

	public void setDoctorStatement(String doctorStatement) {
		this.doctorStatement = doctorStatement;
	}

	@Column(name = "RELEASE_STATUS", nullable = true)
	public String getReleaseStatus() {
		return releaseStatus;
	}

	public void setReleaseStatus(String releaseStatus) {
		this.releaseStatus = releaseStatus;
	}

	@Column(name = "LIST_ID", nullable = true)
	@OneToMany
    @JoinTable(
            name="HISTORY_STORAGE",
            joinColumns = @JoinColumn( name="DIGITAL_ID")
           , inverseJoinColumns = @JoinColumn( name="LIST_ID")
    )
	public Set<BlobFileStorage> getListsOfId() {
		return listsOfId;
	}

	public void setListsOfId(Set<BlobFileStorage> listsOfId) {
		this.listsOfId = listsOfId;
	}

}
