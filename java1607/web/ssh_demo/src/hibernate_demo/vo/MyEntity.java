package hibernate_demo.vo;

import javax.persistence.*;

@Entity
@org.hibernate.annotations.GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
public class MyEntity {
	@Id
	@GeneratedValue(generator = "hibernate-uuid")
	@Column(name = "MY_ID")
	String uuid;
}