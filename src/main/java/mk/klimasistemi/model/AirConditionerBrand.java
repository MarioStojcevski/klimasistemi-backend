package mk.klimasistemi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class AirConditionerBrand {

    @Id
    @Column(name = "brand_id", nullable = false)
    private Long id;
    public String name;
    public String logoImageURL;
    public Boolean visible;

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    public List<AirConditioner> airConditioners;
}
