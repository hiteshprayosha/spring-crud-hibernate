package io.hitesh.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
@Getter
@Setter
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "short_desc")
	private String shortDescription;

	@Column(name = "long_desc")
	private String longDescription;

	@Column(name = "event_date")
	private Date eventDate;

	public Event() {
	}

	public Event(String title, String shortDescription, String longDescription, Date eventDate) {
		this.title = title;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.eventDate = eventDate;
	}
}
