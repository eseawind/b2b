package com.saas.biz.commen;

import com.saas.sys.log.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class CreateChart
{
  public static Logger log;

  public CreateChart()
  {
    log = new Logger(this);
  }

  public static void main(String[] paramArrayOfString)
  {
  }

  public static void saveAsFile(JFreeChart paramJFreeChart, String paramString, int paramInt1, int paramInt2)
  {
    FileOutputStream localFileOutputStream = null;
    try
    {
      File localFile = new File(paramString);
      if (!localFile.getParentFile().exists())
        localFile.getParentFile().mkdirs();
      localFileOutputStream = new FileOutputStream(paramString);
      ChartUtilities.writeChartAsPNG(localFileOutputStream, paramJFreeChart, paramInt2, paramInt1);
      localFileOutputStream.flush();
    }
    catch (FileNotFoundException localIOException2)
    {
    	 localIOException2.printStackTrace();
    }
    catch (IOException localIOException4)
    {
    	localIOException4.printStackTrace();
    }
    finally
    {
      if (localFileOutputStream != null)
        try
        {
          localFileOutputStream.close();
        }
        catch (IOException localIOException5)
        {
        }
    }
  }

  public static JFreeChart createChart(PieDataset paramPieDataset, String paramString)
  {
    JFreeChart localJFreeChart = ChartFactory.createPieChart(paramString, paramPieDataset, true, false, false);
    PiePlot localPiePlot = (PiePlot)localJFreeChart.getPlot();
    localPiePlot.setBackgroundAlpha(0.5F);
    localPiePlot.setForegroundAlpha(0.5F);
    return localJFreeChart;
  }

  public static PieDataset createDataset(ArrayList paramArrayList)
  {
    DefaultPieDataset localDefaultPieDataset = new DefaultPieDataset();
    if (paramArrayList == null)
      return null;
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator.next();
      String str1 = "";
      String str2 = "";
      Double localDouble = Double.valueOf(0.0D);
      if (localHashMap.get("title") != null)
        str1 = localHashMap.get("title").toString();
      if (localHashMap.get("value") != null)
        str2 = localHashMap.get("value").toString();
      localDouble = Double.valueOf(Double.parseDouble(str2));
      localDefaultPieDataset.setValue(str1, localDouble);
    }
    return localDefaultPieDataset;
  }

  public static DefaultCategoryDataset createCategoryDataset(ArrayList paramArrayList)
  {
    DefaultCategoryDataset localDefaultCategoryDataset = new DefaultCategoryDataset();
    localDefaultCategoryDataset.setValue(6.0D, "Profit", "Jane");
    localDefaultCategoryDataset.setValue(3.0D, "Profit2", "Jane");
    localDefaultCategoryDataset.setValue(7.0D, "Profit", "Tom");
    localDefaultCategoryDataset.setValue(6.0D, "Profit2", "Tom");
    localDefaultCategoryDataset.setValue(8.0D, "Profit", "Jill");
    localDefaultCategoryDataset.setValue(9.0D, "Profit2", "Jill");
    localDefaultCategoryDataset.setValue(5.0D, "Profit", "John");
    localDefaultCategoryDataset.setValue(8.0D, "Profit2", "John");
    localDefaultCategoryDataset.setValue(12.0D, "Profit", "Fred");
    localDefaultCategoryDataset.setValue(11.0D, "Profit2", "Fred");
    return localDefaultCategoryDataset;
  }

  public static JFreeChart createCategory(DefaultCategoryDataset paramDefaultCategoryDataset, String paramString)
  {
    JFreeChart localJFreeChart = ChartFactory.createBarChart3D(paramString, "Salesman", "Profit", paramDefaultCategoryDataset, PlotOrientation.VERTICAL, true, true, false);
    localJFreeChart.setBackgroundPaint(ChartColor.yellow);
    localJFreeChart.getTitle().setPaint(ChartColor.blue);
    CategoryPlot localCategoryPlot = localJFreeChart.getCategoryPlot();
    localCategoryPlot.setBackgroundPaint(ChartColor.black);
    localCategoryPlot.setRangeGridlinePaint(ChartColor.red);
    return localJFreeChart;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.CreateChart
 * JD-Core Version:    0.6.0
 */