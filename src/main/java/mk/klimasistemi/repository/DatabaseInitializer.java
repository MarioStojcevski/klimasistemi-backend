//package mk.klimasistemi.repository;
//
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import mk.klimasistemi.model.AirConditioner;
//import mk.klimasistemi.model.enumeration.AirConditionerType;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.ArrayList;
//
//@Component
//@Getter
//@RequiredArgsConstructor
//public class DatabaseInitializer {
//
//    private final AirConditionerRepository airConditionerRepository;
//    private final AirConditionerBrandRepository airConditionerBrandRepository;
//    public ArrayList<AirConditioner> airConditioners;
//
//    @PostConstruct
//    public void init() throws FileNotFoundException {
//        airConditioners = new ArrayList<>();
//        File initialCsvFile = new File("src/main/resources/klimi - Sheet1.csv");
//        if(!initialCsvFile.exists()) throw new FileNotFoundException("CSV File not found.");
//        BufferedReader reader;
//        try {
//            reader = new BufferedReader(new FileReader(initialCsvFile));
//            reader.lines().forEach(line -> {
//                AirConditioner airConditioner = getAirConditionerFromLine(line);
//                if(airConditioner != null) {
//                    this.airConditioners.add(airConditioner);
//                }
//            });
//            this.airConditionerRepository.saveAll(airConditioners);
//        } catch (FileNotFoundException e) {
//            System.out.println("Error parsing file. Error: " + e.getMessage());
//        }
//    }
//
//    public AirConditioner getAirConditionerFromLine(String line) {
//        String[] lineParts = line.split(",");
//        if(lineParts[0].equals("brand")) {
//            return null;
//        } else {
//            AirConditioner airConditioner = new AirConditioner();
//
//            airConditioner.setBrandtemp(Long.parseLong(lineParts[0]));
//            airConditioner.setType(AirConditionerType.valueOf(lineParts[1]));
//            airConditioner.setModelName(lineParts[2]);
//            airConditioner.setEnergyClass(lineParts[3]);
//            airConditioner.setPower(Long.valueOf(lineParts[4]));
//            airConditioner.setArea(Long.valueOf(lineParts[5]));
//            airConditioner.setPrice(Long.valueOf(lineParts[6]));
//            airConditioner.setImageOutdoorURL(lineParts[7]);
//            airConditioner.setImageIndoorURL(lineParts[8]);
//            airConditioner.setMaxCoolingCapacity(Long.valueOf(lineParts[9]));
//            airConditioner.setMaxHeatingCapacity(Long.valueOf(lineParts[10]));
//            airConditioner.setAveragePower(Long.valueOf(lineParts[11]));
//            airConditioner.setEntryCoolingPower(Long.valueOf(lineParts[12]));
//            airConditioner.setEntryHeatingPower(Long.valueOf(lineParts[13]));
//            airConditioner.setAirFlow(Long.valueOf(lineParts[14]));
//            airConditioner.setDehumidificationRate((long) Float.parseFloat(lineParts[15]));
//            airConditioner.setNoiseLevel((long) Float.parseFloat(lineParts[16]));
//            airConditioner.setWorkingTemperatureFrom(Long.valueOf(lineParts[17]));
//            airConditioner.setWorkingTemperatureTo(Long.valueOf(lineParts[18]));
//            airConditioner.setIndoorUnitMass((long) Float.parseFloat(lineParts[19]));
//            airConditioner.setOutdoorUnitMass((long) Float.parseFloat(lineParts[20]));
//            airConditioner.setFreon(lineParts[21]);
//            airConditioner.setOutdoorUnitDimensionsX(Long.valueOf(lineParts[22]));
//            airConditioner.setOutdoorUnitDimensionsY(Long.valueOf(lineParts[23]));
//            airConditioner.setOutdoorUnitDimensionsZ(Long.valueOf(lineParts[24]));
//            airConditioner.setGuarantee(Long.valueOf(lineParts[25]));
//
//            return airConditioner;
//        }
//    }
//}
