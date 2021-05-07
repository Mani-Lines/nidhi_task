package com.challenge.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doc {

	@Id
	private int docId;
	private String docName;

	@OneToMany(mappedBy = "doc", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<DocRead> docRead = new HashSet<DocRead>();

	public Set<DocRead> getDocRead() {
		return docRead;
	}

	public void setDocRead(Set<DocRead> docRead) {
		this.docRead = docRead;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

}
