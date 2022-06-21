package io.hitesh.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Map;

/**
 * JPA entity : Search
 */
@Entity
@Table(name = "search")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TypeDef(name = "jsonb", typeClass = com.vladmihalcea.hibernate.type.json.JsonBinaryType.class)
public class Search {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	private Map<String, Object> searchData;
}
