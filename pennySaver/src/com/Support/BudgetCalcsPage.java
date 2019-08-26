package com.Support;

import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.UnitType;

/**
 *
 * @author DNartey
 */
public class BudgetCalcsPage {
    public static String  mainAdvice;
    public static Double  home, shopping, dineAndDrinks, auto, travel, billsAndUtils,
        entertainment, fees, personalCare, loans, education, other;
    public static Double  netIncome, needs, wants;
    public static Double  budgetWants, budgetNeeds, budgetSavings, budgetTotal;
    
    
    public static void doCalcs(){
       needs = home + dineAndDrinks + auto+ billsAndUtils  + loans+ fees + education ;
       wants = shopping + travel + entertainment +personalCare + other;
       budgetTotal = needs + wants;
       budgetNeeds = needs;
       budgetWants = (wants*0.6);
       budgetSavings = (wants*0.4);
   }
  
    
    public static void updateBar( JPanel myChartPanel, Double needs1, Double wants1, Double savings1){
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Necessary", needs1);
        dataset.setValue("Wants", wants1);
        dataset.setValue("Savings", savings1);
        JFreeChart barChart = ChartFactory.createPieChart(
        "Budget For The Week",
        dataset,
        false, true, false);
        barChart.setBackgroundPaint(new Color(51, 51, 51));
        
        PiePlot plot = (PiePlot) barChart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {2}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));
        
        ChartPanel chartPanel = new ChartPanel( barChart );
        //chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
        myChartPanel.removeAll();
        myChartPanel.add(chartPanel);
        myChartPanel.validate();
    }
    
    public static void dynamicBar( JPanel myChartPanel, String title, List<Double> stock, List<String> stockName){
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        for(int i =0; i< stock.size();i++){
            dataset.setValue(stockName.get(i), stock.get(i));
        }
        JFreeChart barChart = ChartFactory.createPieChart(
        title,
        dataset,
        false, true, false);
        barChart.setBackgroundPaint(new Color(240,235,216));
        barChart.getTitle().setPaint(new Color(29,45,68));

        PiePlot plot = (PiePlot) barChart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setShadowPaint(null);
        //plot.setSimpleLabels(true);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} = {2}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));

        plot.setLabelFont(new Font("Takoma", Font.PLAIN, 12));
        plot.setLabelPaint(Color.BLACK);
        //plot.setLabelBackgroundPaint(color.WHITE);
        plot.setBackgroundPaint(null);
        plot.setLabelOutlinePaint(null);
        plot.setLabelShadowPaint(null);
        plot.setSectionOutlinesVisible(false);
        //plot.setSeparatorsVisible(false);
        
        plot.setNoDataMessage("No data available");
        plot.setCircular(true);
        plot.setIgnoreZeroValues(true);
        plot.setIgnoreNullValues(true);
        plot.setSimpleLabelOffset(new RectangleInsets(UnitType.RELATIVE, 0.09, 0.09, 0.09, 0.09));
        
        ChartPanel chartPanel = new ChartPanel( barChart );
        //chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
        myChartPanel.removeAll();
        myChartPanel.add(chartPanel);
        myChartPanel.validate();        
    }
    
   
}
