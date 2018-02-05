package JFreeChart;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.io.*;
import java.nio.Buffer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;



public class Draw_RTT {

	public static void drawRTT(String host,double[] RTT) throws Exception{
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
		mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
		mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
		ChartFactory.setChartTheme(mChartTheme);
		DefaultCategoryDataset mDataset = new DefaultCategoryDataset();

		int i=1;
		for(double rtt:RTT)
		{
				mDataset.addValue(rtt, host,String.valueOf(i++));
		}
				

		JFreeChart mChart = ChartFactory.createLineChart("网站的往返时间折线图", "", "RTT(ms)", mDataset,
				PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot mPlot = (CategoryPlot) mChart.getPlot();
		//mPlot.setBackgroundPaint(Color.PINK);
		mPlot.setRangeGridlinePaint(Color.black);// 背景底部横虚线
		mPlot.setOutlinePaint(Color.WHITE);// 边界线
		ChartFrame mChartFrame = new ChartFrame("访问时间折线图", mChart);
		mChartFrame.setLocation(390, 160);
		mChartFrame.pack();
		mChartFrame.setVisible(true);
		
		
		
	}
	
	

	
	
	

}
