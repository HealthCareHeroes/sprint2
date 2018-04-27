package edu.uncc.ssdi.model;


import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.ForeignKey;


@Entity
@Table(name = "B_STORAGE")
public class BlobFileStorage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FILE_ID")
	private long fileId;
	
	@Column(name = "MED_ID")
	private long medId;
	
	@Column(name = "DIGITAL_ID")
	private String digitalID;
	
	
	@Column(name = "FILE_NAME")
	private String filename;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "CONTENT")
	@Lob
	private Blob content;

	@Column(name = "CONTENT_TYPE")
	private String contentType;

	@Column(name = "CREATION_DT")
	private Date created;

	BlobFileStorage(){
		
	}
	
	
	public BlobFileStorage(long fileId, String description, String filename, Blob content,
			String contentType, Date created) {
		super();
		this.fileId = fileId;
		this.description = description;
		this.filename = filename;
		this.content = content;
		this.contentType = contentType;
		this.created = created;
	}

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}


	public String getDigitalID() {
		return digitalID;
	}


	public void setDigitalID(String digitalID) {
		this.digitalID = digitalID;
	}


	public long getMedId() {
		return medId;
	}


	public void setMedId(long medId) {
		this.medId = medId;
	}
	
	
	

}
