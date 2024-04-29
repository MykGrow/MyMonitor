package mykgrow.plugins.ui.chart;

import mykgrow.plugins.ui.PanelHost;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Random;

public class DataChart implements PanelHost {

    public enum Colors{
        BABY_PINK(new Color(230, 169, 239)),
        BABY_PURPLE(new Color(139, 66, 241)),
        PURPLE(new Color(127, 15, 189)),
        DARK_PURPLE(new Color(83, 43, 236));

        private final Color color;
        Colors(Color color){
            this.color = color;
        }

        public Color getColor(){
            return color;
        }

    }
    private XYSeries temperatureSeries;
    private XYPlot plot;

    JPanel panel;

    public DataChart(String title, Color color) {
        this.panel = new JPanel();
        initChart(title, color);
    }

    private void initChart(String title, Color color) {
        this.panel.setLayout(new GridLayout(1, 1));
        // Create series for each data type
        temperatureSeries = new XYSeries("Temperature");

        // Add some sample data
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            temperatureSeries.add(i, random.nextDouble() * 30); // Random temperature between 0 and 30
        }

        // Add series to dataset
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(temperatureSeries);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                title,
                "Time",
                "Value",
                dataset,
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                false,
                false,
                false
        );
        chart.setBackgroundPaint(new Color(60, 63, 65)); // Set background color
        // Set background color to match FlatDarkLaf
        this.plot = chart.getXYPlot();
        plot.setBackgroundPaint(new Color(60, 63, 65)); // Set background color
        plot.setDomainGridlinePaint(new Color(160, 160, 160)); // Set color of domain gridlines (vertical)
        plot.setRangeGridlinePaint(new Color(160, 160, 160)); // Set color of range gridlines (horizontal)
        plot.setOutlinePaint(new Color(160, 160, 160)); // Set color of plot outline

        TextTitle chartTitle = chart.getTitle();
        chartTitle.setFont(new Font("Arial", Font.BOLD, 20));
        chartTitle.setPaint(new Color(187, 187, 187)); // Dark gray

        // Set axis label font and color to match FlatDarkLaf
        ValueAxis domainAxis = plot.getDomainAxis();
        domainAxis.setLabelFont(new Font("Arial", Font.BOLD, 14));
        domainAxis.setLabelPaint(new Color(187, 187, 187)); // Dark gray

        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("Arial", Font.BOLD, 14));
        rangeAxis.setLabelPaint(new Color(187, 187, 187)); // Dark gray

        // Set font and color for numbers on the graph
        NumberAxis domainNum = (NumberAxis) plot.getDomainAxis();
        domainNum.setTickLabelFont(new Font("Arial", Font.PLAIN, 12));
        domainNum.setTickLabelPaint(new Color(187, 187, 187)); // Dark gray

        NumberAxis rangeNum = (NumberAxis) plot.getRangeAxis();
        rangeNum.setTickLabelFont(new Font("Arial", Font.PLAIN, 12));
        rangeNum.setTickLabelPaint(new Color(187, 187, 187)); // Dark gray

        // Set font and color for legend
        //LegendTitle legend = chart.getLegend();
        //legend.setBorder(new BlockBorder(new Color(73, 77, 79)));
        //legend.setBackgroundPaint(new Color(60, 63, 65)); // Set background color
        //legend.setItemFont(new Font("Arial", Font.PLAIN, 12));
        //legend.setItemPaint(new Color(187, 187, 187)); // Dark gray

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setLayout(new GridLayout(1, 1));

        setLineAndShapeRenderer(color);

        this.panel.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), new EmptyBorder(10, 10, 10, 10)));
        this.panel.add(chartPanel);
    }

    public void setLineAndShapeRenderer(Color color){
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, color); // Set color for the first series line
    }

    @Override
    public JPanel getPanel() {
       return this.panel;
    }
}
