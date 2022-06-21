package io.hitesh.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/** JPA entity : Employee */
@Entity
@Table(name = "search")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TypeDef(name = "json", typeClass = com.vladmihalcea.hibernate.type.json.JsonStringType.class)
public class Search {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Map<String, Object> searchData;//= new HashMap<>();
}
