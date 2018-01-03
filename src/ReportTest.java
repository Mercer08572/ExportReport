import java.io.File;
import java.io.FileOutputStream;

import com.stimulsoft.report.StiExportManager;
import com.stimulsoft.report.StiReport;
import com.stimulsoft.report.StiSerializeManager;
import com.stimulsoft.report.dictionary.databases.StiXmlDatabase;
import com.stimulsoft.report.enums.StiCalculationMode;

public class ReportTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String dataPath = "data/";
        StiXmlDatabase xmlDatabase = new StiXmlDatabase("data", dataPath+"228001.xsd", dataPath+"5_20180103_100110124_41524.xml");
        try {
            StiReport renderReport = StiSerializeManager.deserializeReport(new File("report/20180103_10463920279614.mrt"));
            renderReport.getDictionary().getDatabases().add(xmlDatabase);
            renderReport.setCalculationMode(StiCalculationMode.Interpretation);
            renderReport.Render(false);
            
            FileOutputStream outputStreamPdf = null;
            outputStreamPdf = new FileOutputStream(new File("C:/Users/Administrator/Desktop/Demo.pdf"));//输出路径，修改为你自己的路径
            System.out.println("PDF路径已确认，准备输出");
            StiExportManager.exportPdf(renderReport, outputStreamPdf);
            System.out.println("PDF输出成功！！");
            
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
