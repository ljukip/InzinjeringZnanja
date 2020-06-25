package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.knowm.xchart.style.Styler.ChartTheme;

public class Graph {
	
	public Graph(HashMap<String, Double> map)
	{
		// TODO Auto-generated constructor stub
		PieChart chart = new PieChartBuilder().width(286).height(466).title("Disease probability")
				.theme(ChartTheme.XChart).build();

		// Customize Chart
		chart.getStyler().setLegendVisible(true);
		chart.getStyler().setLegendFont(new Font("Calibri", Font.PLAIN, 9));
		chart.getStyler().setAnnotationType(AnnotationType.Percentage);
		chart.getStyler().setAnnotationDistance(1.18);
		chart.getStyler().setAnnotationsFont(new Font("Calibri", Font.PLAIN, 8));
		chart.getStyler().setPlotContentSize(.4);
		chart.getStyler().setStartAngleInDegrees(20);
		chart.getStyler().setChartBackgroundColor( new Color(227, 218, 224));
		chart.getStyler().setPlotBackgroundColor(new Color(227, 218, 224));
		chart.getStyler().setPlotBorderColor(new Color(226, 255, 253));
		chart.getStyler().setLegendBorderColor(new Color(226, 255, 253));

		double d = 0.0;
		for (Map.Entry<String, Double> iter : map.entrySet())
		{
			d += iter.getValue();
		}

		for (Map.Entry<String, Double> iter : map.entrySet())
		{

			double br = iter.getValue() / d;

			br *= 100;

			chart.addSeries(iter.getKey(), (int) br);

		}

		try
		{
			BitmapEncoder.saveBitmapWithDPI(chart, "./InzinjeringOft_Chart", BitmapFormat.PNG, 90);
		}
		catch (IOException e)
		{
		}

	}
	
	
	public Graph(HashMap<String, Integer> mapa, int i)
	{
		// TODO Auto-generated constructor stub
		PieChart chart;
		if (i==1)
		{
			chart = new PieChartBuilder().width(260).height(260).title("Medication probability").theme(ChartTheme.XChart)
					.build();
		}
		else
		{
			chart = new PieChartBuilder().width(260).height(260).title("Procedure probability").theme(ChartTheme.XChart)
					.build();
		}

		// Customize Chart
		chart.getStyler().setLegendVisible(false);
		chart.getStyler().setLegendFont(new Font("Calibri", Font.PLAIN, 9));
		chart.getStyler().setChartBackgroundColor(Color.BLACK);
		chart.getStyler().setAnnotationType(AnnotationType.LabelAndPercentage);
		chart.getStyler().setAnnotationDistance(1.18);
		chart.getStyler().setAnnotationsFont(new Font("Calibri", Font.PLAIN, 8));
		chart.getStyler().setPlotContentSize(.4);
		chart.getStyler().setStartAngleInDegrees(20);
		chart.getStyler().setChartBackgroundColor( new Color(227, 218, 224));
		chart.getStyler().setPlotBackgroundColor(new Color(227, 218, 224));
		chart.getStyler().setPlotBorderColor(new Color(226, 255, 253));
		chart.getStyler().setLegendBorderColor(new Color(226, 255, 253));

		double d = 0;
		for (Map.Entry<String, Integer> iter : mapa.entrySet())
		{
			d += iter.getValue();
		}

		for (Map.Entry<String, Integer> iter : mapa.entrySet())
		{

			double br = iter.getValue() / d;

			br *= 100;

			chart.addSeries(iter.getKey(), (int) br);
		}
		try
		{
			if (i==1)
			{
				BitmapEncoder.saveBitmapWithDPI(chart, "./medications", BitmapFormat.PNG, 90);
			}
			else
			{
				BitmapEncoder.saveBitmapWithDPI(chart, "./procedures", BitmapFormat.PNG, 90);
			}
		}
		catch (IOException e)
		{
		}

	}
	
}
