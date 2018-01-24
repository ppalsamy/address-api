package com.api.address.common.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class for entities providing audit trail dates<br/>
 * Pre-persist and Pre-Update life cycle are provided on the audit trail dates.
 * <p/>
 * Relationship entities generally do not need a generated database Id and therefore are
 * recommended to extend this BaseEntity class directly.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private static Logger LOGGER = LoggerFactory.getLogger(BaseEntity.class);

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdated;

	/**
	 * This method is called once per entity sub-class instance just before initial creation.
	 */
	@PrePersist
	public void createPrePersistence() {
		this.dateCreated = new Date();
		this.dateUpdated = new Date();
	}

	/**
	 * This method is called before every update of a given entity subclass.
	 */
	@PreUpdate
	public void updatePrePersistence() {
		this.dateUpdated = new Date();
	}

	/**
	 * Date-Time when initially inserted into the database.
	 * @return
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * Date-Time when last updated in the database.
	 * @return
	 */
	public Date getDateUpdated() {
		return dateUpdated;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("dateCreated", dateCreated)
				.append("dateUpdated", dateUpdated)
				.toString();
	}
}
