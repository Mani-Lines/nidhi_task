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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + docId;
		result = prime * result + ((docName == null) ? 0 : docName.hashCode());
		result = prime * result + ((docRead == null) ? 0 : docRead.hashCode());
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
		Doc other = (Doc) obj;
		if (docId != other.docId)
			return false;
		if (docName == null) {
			if (other.docName != null)
				return false;
		} else if (!docName.equals(other.docName))
			return false;
		if (docRead == null) {
			if (other.docRead != null)
				return false;
		} else if (!docRead.equals(other.docRead))
			return false;
		return true;
	}
	
	

}
