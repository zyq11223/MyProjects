package JFreeChart;

import java.awt.Color;

import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class PieChart {
	public static JFreeChart createChart(String name,PieDataset piedataset) {    
	    JFreeChart jfreechart = ChartFactory.createPieChart3D(    
	            name, piedataset, true, true, false);    
	    PiePlot3D pieplot3d = (PiePlot3D) jfreechart.getPlot();    
	    pieplot3d.setNoDataMessage("无 信 息");  
	    pieplot3d.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{1}({2})"));//设置标签显示的格式。
	    pieplot3d.setSectionOutlinesVisible(false);
	    pieplot3d.setLabelBackgroundPaint(new Color(220, 220, 220));//设置标签的背景颜色。
	    //设置旋转角度    
	    pieplot3d.setStartAngle(180.0);    
	    //设置旋转方向，Rotation.CLOCKWISE)为顺时针。    
	    pieplot3d.setDirection(Rotation.CLOCKWISE);    
	    //设置图表透明图0.0~1.0范围。0.0为完全透明，1.0为完全不透明。    
	    pieplot3d.setForegroundAlpha(0.9F);     
	    return jfreechart;    
	}
}
