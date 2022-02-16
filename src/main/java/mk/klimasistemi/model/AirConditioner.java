package mk.klimasistemi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.klimasistemi.model.enumeration.AirConditionerType;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class AirConditioner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    public AirConditionerBrand brand;

    public Long brandtemp;

    public AirConditionerType type;
    public String modelName;
    public String energyClass;
    /**
     * The power expressed in watts.
     */
    public Long power;
    /**
     * The area coverage expressed in meters squared.
     */
    public Long area;
    /**
    * The price expressed in MKD.
     */
    public Long price;
    public String imageOutdoorURL;
    public String imageIndoorURL;
    /**
    * The cooling capacity expressed in watts.
     */
    public Long maxCoolingCapacity;
    /**
     * The heating capacity expressed in watts.
     */
    public Long maxHeatingCapacity;
    /**
     * The average power expressed in watts.
     */
    public Long averagePower;
    public Long entryCoolingPower;
    public Long entryHeatingPower;
    /**
     * The air flow expressed in meters cubed.
     */
    public Long airFlow;
    /**
     * The Dehumidification rate expressed in liters per hour.
     */
    public Long dehumidificationRate;
    /**
     * The noise expressed in dB.
     */
    public Long noiseLevel;
    /**
     * The working temperature from min celsius degrees.
     */
    public Long workingTemperatureFrom;
    /**
     * The working temperature to max celsius degrees.
     */
    public Long workingTemperatureTo;
    /**
     * The indoor unit mass expressed in kilograms.
     */
    public Long indoorUnitMass;
    /**
     * The outdoor unit mass expressed in kilograms.
     */
    public Long outdoorUnitMass;
    /**
     * The type of freon.
     */
    public String freon;
    /**
     * The dimensions expressed in millimeters by X axis.
     */
    public Long outdoorUnitDimensionsX;
    /**
     * The dimensions expressed in millimeters by Y axis.
     */
    public Long outdoorUnitDimensionsY;
    /**
     * The dimensions expressed in millimeters by Z axis.
     */
    public Long outdoorUnitDimensionsZ;
    /**
     * The guarantee of the air conditioner in months.
     */
    public Long guarantee;
}
