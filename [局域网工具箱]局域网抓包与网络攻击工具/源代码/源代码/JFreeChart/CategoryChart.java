package JFreeChart;

import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;

import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.TextAnchor;
import org.jfree.util.Rotation;

public class CategoryChart {
	public static JFreeChart createChart(String name, CategoryDataset dataset,Color color) {

		JFreeChart chart = ChartFactory.createBarChart3D(name, null, null, dataset, PlotOrientation.VERTICAL, true,
				false, false);
		
		CategoryPlot plot = chart.getCategoryPlot();// 设置图的高级属性
		BarRenderer3D renderer = new BarRenderer3D();// 3D属性修改
		plot.setNoDataMessage("无 信 息");  
		renderer.setSeriesPaint(0,color); //设置柱的颜色 
		// 设置网格竖线颜色
		plot.setDomainGridlinePaint(Color.gray);
		plot.setDomainGridlinesVisible(true);
		// 设置网格横线颜色
		plot.setRangeGridlinePaint(Color.gray);
		plot.setRangeGridlinesVisible(true);
		// 图片背景色
		plot.setBackgroundPaint(Color.LIGHT_GRAY);
		plot.setOutlineVisible(true);
		// 设置墙体颜色
		renderer.setWallPaint(Color.gray);

		// 对X轴做操作
		CategoryAxis domainAxis = plot.getDomainAxis();
		// 对Y轴做操作
		ValueAxis rAxis = plot.getRangeAxis();


		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBaseItemLabelFont(new Font("黑体", Font.CENTER_BASELINE, 12), true);
		renderer.setBasePositiveItemLabelPosition(
				new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.CENTER_LEFT));
		renderer.setItemLabelAnchorOffset(15); 

        //设置距离图片左端距离 
   domainAxis.setUpperMargin(0.2); 
    //设置距离图片右端距离 
   domainAxis.setLowerMargin(0.2); 
       //设置柱的透明度 
   plot.setForegroundAlpha(0.6f); 
		
		// 最后还得将renderer 放到plot 中
		plot.setRenderer(renderer);// 将修改后的属性值保存到图中

		return chart;
	}
}
