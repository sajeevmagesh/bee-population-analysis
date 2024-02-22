// import org.jfree.chart.ChartFactory;
// import org.jfree.chart.ChartPanel;
// import org.jfree.chart.JFreeChart;
// import org.jfree.data.category.DefaultCategoryDataset;
// import org.jfree.ui.ApplicationFrame;
// import org.jfree.ui.RefineryUtilities;

// import java.util.List;

// public class BeeDataChart extends ApplicationFrame {

//     public BeeDataChart(String title, List<BeeColonyData> beeDataList) {
//         super(title);
//         JFreeChart barChart = ChartFactory.createBarChart(
//                 "Bee Colonies by State",
//                 "State",
//                 "Colonies",
//                 createDataset(beeDataList),
//                 org.jfree.chart.plot.PlotOrientation.VERTICAL,
//                 true, true, false);

//         ChartPanel chartPanel = new ChartPanel(barChart);
//         chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
//         setContentPane(chartPanel);
//     }

//     private DefaultCategoryDataset createDataset(List<BeeColonyData> beeDataList) {
//         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//         for (BeeColonyData data : beeDataList) {
//             dataset.addValue(data.colonies, "Colonies", data.state);
//         }
//         return dataset;
//     }

//     public static void displayChart(List<BeeColonyData> beeDataList) {
//         BeeDataChart chart = new BeeDataChart("Bee Colonies by State", beeDataList);
//         chart.pack();
//         RefineryUtilities.centerFrameOnScreen(chart);
//         chart.setVisible(true);
//     }
// }
// BeeDataChart.java





// import org.jfree.chart.ChartFactory;
// import org.jfree.chart.ChartPanel;
// import org.jfree.chart.JFreeChart;
// import org.jfree.data.category.DefaultCategoryDataset;
// import javax.swing.*;
// import java.util.List;

// public class BeeDataChart extends JFrame {
//     public BeeDataChart(String title, List<BeeColonyData> beeDataList) {
//         super(title);
//         JFreeChart barChart = createChart(beeDataList);
//         ChartPanel chartPanel = new ChartPanel(barChart);
//         chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
//         setContentPane(chartPanel);
//     }

//     private JFreeChart createChart(List<BeeColonyData> beeDataList) {
//         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//         for (BeeColonyData data : beeDataList) {
//             dataset.addValue(data.getLostColonies(), "Lost Colonies", data.getState());
//         }

//         return ChartFactory.createBarChart(
//                 "Bee Colony Losses", "State", "Lost Colonies",
//                 dataset);
//     }

//     public static void displayChart(List<BeeColonyData> beeDataList) {
//         SwingUtilities.invokeLater(() -> {
//             BeeDataChart chart = new BeeDataChart("Bee Colony Data", beeDataList);
//             chart.pack();
//             chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             chart.setVisible(true);
//         });
//     }

//     // To test the chart display, you can call displayChart method and pass beeDataList from BeeDataParser after parsing the CSV.
//     public static void main(String[] args) {
//         // This main method is for demonstration. In practice, you would call displayChart from where you parse the CSV and have the data list.
//         String filePath = "./hcny_p03_t005.csv"; // Update this path to your CSV file's path
//         List<BeeColonyData> beeDataList = BeeDataParser.parseCsvData();
//         displayChart(beeDataList);
//     }
// }


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import javax.swing.*;

import java.io.IOException;
import java.util.List;

public class BeeDataChart extends ApplicationFrame {

    public BeeDataChart(String title, List<BeeColonyData> beeDataList) {
        super(title);
        JFreeChart barChart = ChartFactory.createBarChart(
                "Bee Colony Statistics",
                "State",
                "Colonies",
                createDataset(beeDataList),
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset(List<BeeColonyData> beeDataList) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (BeeColonyData data : beeDataList) {
            dataset.addValue(data.getJanuaryColonies(), "January 1 Colonies", data.getState());
            dataset.addValue(data.getLostColonies(), "Lost Colonies", data.getState());
            dataset.addValue(data.getAddedColonies(), "Added Colonies", data.getState());
        }

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BeeDataChart chart;
            try {
                chart = new BeeDataChart("Bee Colony Statistics", BeeDataParser.parseCsvData("./hcny_p03_t005.csv"));
                chart.pack();
                chart.setVisible(true);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        });
    }
}
