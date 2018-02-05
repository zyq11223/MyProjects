package Ping;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.io.*;
import java.nio.Buffer;

import org.codehaus.jackson.util.BufferRecycler;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import net.sf.json.*;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.NewBeanInstanceStrategy;


public class Draw_RTT {

	public static void drawRTT() throws Exception{
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
		mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
		mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
		ChartFactory.setChartTheme(mChartTheme);
		DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
		
		BufferedReader bReader1 = new BufferedReader(new FileReader("Ping_original.txt"));
		BufferedReader bReader2 = new BufferedReader(new FileReader("Website.txt"));
		String[] strings = new String[4];
		for(String str:strings)
			str = new String();
		String string1;
		int i =0;
		while ((string1 = bReader2.readLine())!=null) {
			strings[i++] = string1;			
		}
		bReader2.close();
		i=0;
		String string2;
		while ((string2 = bReader1.readLine())!=null) {
			JSONObject jo1 = JSONObject.fromObject(string2);
			JSONArray jArray = (JSONArray)jo1.get(strings[i]);

			 double[] resultRTT = new double[jArray.size()];
			    for(int j=0;j<jArray.size();j++)
			    {
			    	resultRTT[j] = jArray.getDouble(j);
			    }
			    
			    int k = 1;
				for (double rtt : resultRTT) {
					mDataset.addValue(rtt, strings[i],String.valueOf(k++));
				}
				
				i++;
			
		}
		

		
		
	
		

		
		
		JFreeChart mChart = ChartFactory.createLineChart("网站的往返时间折线图", "", "RTT(ms)", mDataset,
				PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot mPlot = (CategoryPlot) mChart.getPlot();
		//mPlot.setBackgroundPaint(Color.PINK);
		mPlot.setRangeGridlinePaint(Color.black);// 背景底部横虚线
		mPlot.setOutlinePaint(Color.WHITE);// 边界线
		ChartFrame mChartFrame = new ChartFrame("访问时间折线图", mChart);
		mChartFrame.pack();
		mChartFrame.setVisible(true);
		
		
		
	}
	
	

	
	
	
	public static void main(String[] args) throws Exception{
		drawRTT();
	}
}
