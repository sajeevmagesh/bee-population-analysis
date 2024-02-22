// import org.apache.commons.csv.CSVFormat;
// import org.apache.commons.csv.CSVParser;
// import org.apache.commons.csv.CSVRecord;
// import java.io.FileReader;
// import java.io.Reader;
// import java.util.ArrayList;
// import java.util.List;

// public class BeeDataParser {
//     private static final String CSV_FILE_PATH = "./hcny_all_tables.csv"; // Update this path

//     public static void main(String[] args) {
//         List<BeeColonyData> beeDataList = parseCsvData(CSV_FILE_PATH);
//         // Optionally, print the parsed data to check
//         // for (BeeColonyData data : beeDataList) {
//         //     System.out.println(data);
//         // }
//         BeeDataChart.displayChart(beeDataList); // Display the chart with the parsed data
//         // Next, you can pass beeDataList to a method that creates charts with JFreeChart
//     }

//     private static List<BeeColonyData> parseCsvData(String csvFilePath) {
//         List<BeeColonyData> dataList = new ArrayList<>();
//         try (Reader reader = new FileReader(csvFilePath);
//              CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
//             for (CSVRecord record : csvParser) {
//                 BeeColonyData data = new BeeColonyData(record.get("State"), Integer.parseInt(record.get("January 1 colonies")));
//                 dataList.add(data);
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         return dataList;
//     }
// }

// class BeeColonyData {
//     String state;
//     int colonies;

//     public BeeColonyData(String state, int colonies) {
//         this.state = state;
//         this.colonies = colonies;
//     }

//     @Override
//     public String toString() {
//         return "State: " + state + ", Colonies: " + colonies;
//     }
// }

// BeeDataParser.java
// import org.apache.commons.csv.CSVFormat;
// import org.apache.commons.csv.CSVParser;
// import org.apache.commons.csv.CSVRecord;
// import java.io.FileReader;
// import java.io.Reader;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;

// public class BeeDataParser {
//     private static final String CSV_FILE_PATH = "./hcny_p03_t005.csv";

//     public static List<BeeColonyData> parseCsvData() throws IOException {
//         List<BeeColonyData> beeDataList = new ArrayList<>();

//         try (Reader reader = new FileReader(CSV_FILE_PATH)) {
//             // Skip initial non-data lines manually or adjust as necessary for your file structure
//             for (int i = 0; i < 10; i++) {
//                 reader.read(); // This is a simplistic way to skip lines. You might need a more robust approach.
//             }
            
//             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
//                     .withFirstRecordAsHeader()
//                     .withIgnoreHeaderCase()
//                     .withTrim());
            
//             for (CSVRecord record : csvParser) {
//                 String state = record.get("State");
//                 int januaryFirstColonies = Integer.parseInt(record.get("January 1 colonies"));
//                 int lostColonies = Integer.parseInt(record.get("Lost colonies"));
//                 int percentLost = Integer.parseInt(record.get("Percent lost"));
//                 int addedColonies = Integer.parseInt(record.get("Added colonies"));
//                 int renovatedColonies = Integer.parseInt(record.get("Renovated colonies"));
//                 int percentRenovated = Integer.parseInt(record.get("Percent renovated"));

//                 beeDataList.add(new BeeColonyData(state, januaryFirstColonies, lostColonies, percentLost, addedColonies, renovatedColonies, percentRenovated));
//             }
//         }

//         return beeDataList;
//     }

//     public static void main(String[] args) {
//         try {
//             List<BeeColonyData> beeDataList = parseCsvData();
//             System.out.println("Data parsed successfully.");
//             // Further processing or visualization...
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }


// public class BeeColonyData {
//     private String state;
//     private int januaryColonies;
//     private int maximumColonies;
//     private int lostColonies;
//     private double percentLost;
//     private int addedColonies;
//     private int renovatedColonies;
//     private double percentRenovated;

//     public BeeColonyData(String state, int januaryColonies, int maximumColonies, int lostColonies, double percentLost, int addedColonies, int renovatedColonies, double percentRenovated) {
//         this.state = state;
//         this.januaryColonies = januaryColonies;
//         this.maximumColonies = maximumColonies;
//         this.lostColonies = lostColonies;
//         this.percentLost = percentLost;
//         this.addedColonies = addedColonies;
//         this.renovatedColonies = renovatedColonies;
//         this.percentRenovated = percentRenovated;
//     }

//     // Getters
//     public String getState() {
//         return state;
//     }

//     public int getJanuaryColonies() {
//         return januaryColonies;
//     }

//     public int getMaximumColonies() {
//         return maximumColonies;
//     }

//     public int getLostColonies() {
//         return lostColonies;
//     }

//     public double getPercentLost() {
//         return percentLost;
//     }

//     public int getAddedColonies() {
//         return addedColonies;
//     }

//     public int getRenovatedColonies() {
//         return renovatedColonies;
//     }

//     public double getPercentRenovated() {
//         return percentRenovated;
//     }

//     // Setters for each field if needed
//     // toString method for debugging
//     @Override
//     public String toString() {
//         return "BeeColonyData{" +
//                 "state='" + state + '\'' +
//                 ", januaryColonies=" + januaryColonies +
//                 ", maximumColonies=" + maximumColonies +
//                 ", lostColonies=" + lostColonies +
//                 ", percentLost=" + percentLost +
//                 ", addedColonies=" + addedColonies +
//                 ", renovatedColonies=" + renovatedColonies +
//                 ", percentRenovated=" + percentRenovated +
//                 '}';
//     }
// }



import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class BeeDataParser {

    public static List<BeeColonyData> parseCsvData(String filePath) throws IOException {
        List<BeeColonyData> beeDataList = new ArrayList<>();
        try (Reader reader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
            for (CSVRecord record : csvParser) {
                String state = record.get("State");
                int januaryColonies = Integer.parseInt(record.get("January 1 colonies"));
                int maximumColonies = Integer.parseInt(record.get("Maximum colonies 1/"));
                int lostColonies = Integer.parseInt(record.get("Lost colonies"));
                double percentLost = Double.parseDouble(record.get("Percent lost 2/").replace("%", ""));
                int addedColonies = Integer.parseInt(record.get("Added colonies"));
                int renovatedColonies = Integer.parseInt(record.get("Renovated colonies 3/"));
                double percentRenovated = Double.parseDouble(record.get("Percent renovated 4/").replace("%", "").replace("(Z)", "0"));

                beeDataList.add(new BeeColonyData(state, januaryColonies, maximumColonies, lostColonies, percentLost, addedColonies, renovatedColonies, percentRenovated));
            }
        }
        return beeDataList;
    }

    public static void main(String[] args) {
        try {
            List<BeeColonyData> beeDataList = parseCsvData("./hcny_p03_t005.csv");
            BeeDataChart chart = new BeeDataChart("Bee Colony Statistics", beeDataList);
            chart.pack();
            chart.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
