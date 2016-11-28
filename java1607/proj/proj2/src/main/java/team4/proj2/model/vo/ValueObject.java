package team4.proj2.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ValueObject {

	String id;
	int version;

	public ValueObject() {
		super();
	}

	/** surrogate key */
	@Id
	@GeneratedValue(generator = "_uuid")
	@GenericGenerator(name = "_uuid", strategy = "uuid")
	@Column(name = "_id")
	public String getId() {
		return id;
	}

	/** an integer standard the version of the database */
	@Column(name = "_version")
	public int getVersion() {
		return version;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "ValueObject [id=" + id + ", version=" + version + "]";
	}

}
