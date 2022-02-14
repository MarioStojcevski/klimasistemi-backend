package mk.klimasistemi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AirConditionerBrand {

    @Id
    @Column(name = "brand_id", nullable = false)
    private Long id;
    public String name;
    public String logoImageURL;

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    public List<AirConditioner> airConditioners;
}
