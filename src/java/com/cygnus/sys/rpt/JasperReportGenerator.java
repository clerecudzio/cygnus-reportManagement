
package com.cygnus.sys.rpt;

import java.io.BufferedOutputStream;
/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;*/
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/*import java.io.FileReader;
import java.io.FileWriter;*/
import java.io.IOException;
import java.io.InputStream;
/*import java.sql.Connection;
import java.sql.DriverManager;*/
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;



@SuppressWarnings("unused")
public class JasperReportGenerator extends Thread implements Runnable {
	private static Logger log = Logger.getLogger(JasperReportGenerator.class);
	private HttpServletRequest req;
	private HttpSession ses;
	private Report report;
//	private ReportConnection conn;
	private Boolean sameWindow;
	private String reportLocation;
    private ServletContext servletContext;
    private ByteArrayOutputStream baos = null;
//	private BackupReportThread backupReportThread = null;
    private int historyData;
    private Calendar calendar;
    private Boolean exportReportSuccess = null;
    private String userCode;
    private String reportCode;
//    private ReportFileCreator rfc;
    private HttpSession session;
//    private ReportList reportList = null;
//    private ReportListService reportListService = ReportListService.getInstance();
//    private SystemPropertyDAO sysProp = SystemPropertyDAO.getInstance();
//    private ReportHistoryService reportHistoryService = ReportHistoryService.getInstance();
   
    /**
     * Constructor untuk ExportReportThreadForFileOutput
	 * @param request untuk mendapatkan data request dari client
     * @param session untuk mengambil / meletakkan data dari / ke session
     * @param report object report
     * @param conn koneksi report ke database
     * @param sameWindow flag untuk menentukan report ditampilkan pada window yang sama atau window baru
     * @param reportLocation lokasi penyimpanan report
     * @param servletContext servlet context
     * @param historyData data history laporan
     * @param calendar calendar untuk menampung tanggal system
     * @throws Exception system exception handler
     */
//    public void ExportReportThreadForFileOutput(HttpServletRequest request, HttpSession session, Report report, ReportConnection conn,
//    		Boolean sameWindow, String reportLocation, ServletContext servletContext, int historyData, Calendar calendar) throws Exception {
//    	super();
//    	this.req = request;
//    	this.report = report;
//    	this.conn = conn;
//    	this.sameWindow = sameWindow;
//    	this.reportLocation = reportLocation;
//    	this.servletContext = servletContext;
//    	this.historyData = historyData;
//    	this.calendar = calendar;
//    	this.ses = session;
//    	
//	 }
    
    /**
     * Method yang dipanggil saat mengklik tombol untuk mencetak report.
     * @see java.lang.Thread#run()
     */
//    @SuppressWarnings("unchecked")
//	public void run() throws RuntimeException {
//    	int result = 0;
//    	try {
//			String fileName = "*";
//			String printedLocation = "*";
//			String fileExt = String.valueOf(calendar.getTimeInMillis());
//			String strExt = "";
//			reportList = reportListService.getReportListEntity(report.getReportCode());
//			MenuService menuService = MenuService.getInstance();
//            Menu menu = new Menu();
//            Login user = (Login)ses.getAttribute(Constant.SES_USERLOGIN);
//            this.userCode =  user.getUser().getUserCode();
//            this.reportCode = report.getMenuCode();
//			rfc = new ReportFileCreator();
//			rfc.setReportCode(report.getReportCode());
//			rfc.setBranchGID(user.getUser().getBranchGID());
//			rfc.setStatus("In Progress");
//			rfc.setCreator(user.getUser().getUserCode());
//            
//            menu = menuService.getMenu(report.getMenuCode());
//            report.setReportName(menu.getCommand());

//            int formatValue = report.getFormatType();
//            switch (formatValue) {
//	        case 5 : strExt = "pdf";
//	        		 break;
//	        case 3 : strExt = "rtf";
//	        		 break;
//	        case 9 : strExt = "html";
//	        		 break;
//	        case 8 : strExt = "csv";
//	        		 break;
//	        case 7 : strExt = "xml";
//	        		 break;
//	        case 2 : strExt = "xls";
//	        		 break;
//	        case 4 : strExt = "txt";
//   		 			 break;
//            }
//            rfc.setFileName(reportList.getReportFileName().concat(fileExt).concat(".").concat(strExt));
//            rfc.setFileNameNoExtention(reportList.getReportFileName().concat(fileExt).concat(".").concat(strExt));
//            try
//            {
//             sysProp.startTransaction();	
//             int thisresult = sysProp.insertReportFileCreatorList(rfc);
//             if (thisresult >0) sysProp.commitTransaction();
//             else {sysProp.rollbackTransaction(); throw new RuntimeException("Error on Control");}
//            }catch(DaoException de)
//            {   sysProp.rollbackTransaction();
//            	de.printStackTrace();}
//            String contentType = "";
//           
//            Map parameters = report.getParameter();
//            parameters.put("printCode", String.valueOf(calendar.getTimeInMillis()));
//            parameters.put("SUBREPORT_DIR", servletContext.getRealPath("/compiledReports/")+ System.getProperty("file.separator"));
//            parameters.put("imageLocation", servletContext.getRealPath("/compiledReports/")+ System.getProperty("file.separator"));
            
            /* Generate without Compiling Report */
//            conn.createConnection(reportCode,userCode); 
//            File reportFile = new File(servletContext.getRealPath("/compiledReports/"+report.getReportName().trim()+".jasper"));
//            JasperReport jasperreport = (JasperReport) JRLoader.loadObject(reportFile.getPath());
//            
//            JasperPrint jasperprint = JasperFillManager.fillReport(jasperreport, parameters,conn.reportConnection);
//            ByteArrayOutputStream os = new ByteArrayOutputStream();
//
//	        switch(formatValue){
//	        case 5 :{
//	            	 //Exporting report for PDF format
//	                 JasperExportManager.exportReportToPdfStream(jasperprint, os);
//	                 contentType = "application/pdf";
//	                 strExt = "pdf";
//	        		};break;
//	        case 3 :{
//	            	 //Exporting report for RTF format
//	                 JRRtfExporter exporterRTF = new JRRtfExporter();
//	                 contentType = "application/msword";
//	                 strExt = "rtf";
//	                 Map imagesMap = new HashMap();
//	                 
//	                 if(imagesMap.size() > 0)
//	                	 req.getSession().setAttribute("IMAGES_MAP", imagesMap);
//
//	                 exporterRTF.setParameter(JRExporterParameter.JASPER_PRINT, jasperprint);
//	                 exporterRTF.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
//	                 exporterRTF.exportReport();
//	                };break;
//	        case 9 :{
//	            	//Exporting Report for HTML format
//	        	    JRHtmlExporter exporterHTML = new JRHtmlExporter();
//	                contentType = "text/html";
//	                strExt = "html";
//	                exporterHTML.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,reportLocation + "/" + report.getReportName() + ".html");
//	                exporterHTML.setParameter(JRExporterParameter.JASPER_PRINT, jasperprint);
//	                exporterHTML.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
//	                exporterHTML.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, false);
//	                //exporterHTML.setParameter(JRHtmlExporterParameter.IS_OUTPUT_IMAGES_TO_DIR, true);
//	                //exporterHTML.setParameter(JRHtmlExporterParameter.IMAGES_DIR, new File(reportList.getReportBackupLocation()));
//	                //exporterHTML.setParameter(JRHtmlExporterParameter.IMAGES_URI,"image?image=");
//	                exporterHTML.exportReport();
//	                sameWindow = false;
//	                };break;
//	        case 8 :{
//	            	 //Exporting Report for Spreadsheet CSV format
//	            	JRCsvExporter exporterCSV = new JRCsvExporter();
//	            	contentType = "text/html";
//
//	            	strExt = "csv";
//	            	exporterCSV.setParameter(JRExporterParameter.JASPER_PRINT, jasperprint);
//	            	exporterCSV.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
//	            	exporterCSV.exportReport();
//	        		};break;
//	        case 7 :{
//		             //Exporting Report for XML format
//		           	 contentType = "text/html";
//		         	 JRXmlExporter exporterXML = new JRXmlExporter();
//		           	 System.out.println("dari ExportReportThreadForFileOutput");
//		         	 Map imagesMap = new HashMap();
//		         	 if(imagesMap.size() > 0)
//		         		 req.getSession().setAttribute("IMAGES_MAP", imagesMap);
//		             exporterXML.setParameter(JRExporterParameter.JASPER_PRINT, jasperprint);
//		             exporterXML.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
//		             exporterXML.exportReport();
//		            };break;
//	        case 2 :{
//		             //Exporting Report for XLS format
//					strExt = "xls";
//	                contentType = "application/vnd.ms-excel";
//	                JRXlsExporter exporterXLS = new JRXlsExporter();
//	                Map imagesMap = new HashMap();
//	                if(imagesMap.size() > 0)
//	                	 req.getSession().setAttribute("IMAGES_MAP", imagesMap);
//	                exporterXLS.setParameter(JRExporterParameter.JASPER_PRINT, jasperprint);
//	                exporterXLS.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, menu.getName());
//	                exporterXLS.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
//	                exporterXLS.exportReport();
//		            };break;
//	        case 4 :{
//		           	contentType = "plain/text";
//
//		            JRCsvExporter exporterCSV = new JRCsvExporter();
//		            strExt = "txt";
//	            	
//	            	exporterCSV.setParameter(JRExporterParameter.JASPER_PRINT, jasperprint);
//	            	exporterCSV.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
//	            	exporterCSV.exportReport();
//	            };break;       
//	        }
//	        if (historyData == 1) {
//		        synchronized (this) {
//		        	this.setBaos(os);
//		        }
//	        }
//
//	        log.info("creating Folder");
//	    	File outputFolder = new File(reportList.getReportBackupLocation());
//	    	boolean createFolderSuccess = false;
//	    	if (!outputFolder.exists()) createFolderSuccess = outputFolder.mkdirs();
//	    	else createFolderSuccess = true;
//            if (createFolderSuccess)
//            {
//	    		if(strExt.equalsIgnoreCase("txt"))
//	    			fileName = reportList.getReportFileName() + fileExt + ".txt" ;
//	    		else
//	    			fileName = reportList.getReportFileName() + fileExt + "." + strExt;
//	    		printedLocation = outputFolder + File.separator + fileName;
//	    		
//	    		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(printedLocation)));
//	    		out.write(os.toByteArray());   		
//	    		
//	    		out.close();
//	    		os.flush();
//	    		FileInputStream fis = new FileInputStream(printedLocation);
//	    		rfc.setFileName(reportList.getReportFileName() + fileExt+".zip");
//	    	    result = this.createFileZip(fis, printedLocation,outputFolder + File.separator+reportList.getReportFileName() + fileExt+".zip");
//	    		fis.close();
//    		}	
//	        
//	        synchronized (this) {
//	        	this.setExportReportSuccess(new Boolean(true));
//	        }
//	        if (result == 0)this.setExportReportSuccess(false);
//	        else this.setExportReportSuccess(true);
//		    if (this.getExportReportSuccess() == true)
//		    {log.info("Succes Creating Report");
//	    		ReportHistory rh = new ReportHistory();
//	    		rh.setReportCode(reportList.getReportCode());
//	    		rh.setReportFileName(reportList.getReportFileName() + fileExt+".zip");
//	    		rh.setPrintedLocation(reportList.getReportBackupLocation());
//	    		rh.setTimeInMillis(String.valueOf(calendar.getTimeInMillis()));
//	    		rh.setArchiveDate(calendar.getTime());
//	    		rh.setArchiveLocation(rh.getPrintedLocation());
//	    		rh.setArchiveName(reportList.getReportFileName() + fileExt+".zip");
//	    		rh.setAuditTrail(((Login) ses.getAttribute("UserLogin")).getUser(), "Insert History");
//	    		rh.setFieldsContents(rh);
//	    	  
//	    		reportHistoryService.insertReportList(rh, ((Login)ses.getAttribute(Constant.SES_USERLOGIN)).getUser(), "Insert History");
//	    	  
//	    		File delFile = new File(printedLocation);
//	    		log.info("Trying to delete pdf data = "+delFile.getAbsoluteFile()+" isFile = "+delFile.isFile());    
//	        	if (delFile.exists()) {
//	        		 log.info("deleting = "+delFile.getAbsoluteFile());
//	        		try{
//	        			
//	            	boolean rslt = delFile.delete();
//	            	 log.info("status = "+rslt);    
//	        		}catch(Exception e){e.printStackTrace();}	
//	            }
//	        	delFile = null;
//		     } else {
//		    	  log.info("failed To Create Report");
//		      }
//		} catch (Exception ex) {
//        	this.setExportReportSuccess(new Boolean(false));
//        	ex.printStackTrace();
//        	log.info("failed To Create Report");
//			throw new RuntimeException(ex);
//		} finally {
//			log.info("finally");
//			ReportConnection.shutdownDriver(this.reportCode,this.userCode); 
//			if(getExportReportSuccess() != null && getExportReportSuccess())rfc.setStatus("Done");
//			else rfc.setStatus("Failed");
//	        try {
//	        	sysProp.startTransaction();
//	        	int result1 = sysProp.updateReportFileCreatorList(rfc);
//	        	if (result1 > 0) {
//	        		log.info("transaction Done, Committing "); 
//	        		sysProp.commitTransaction();
//	        	} else {
//	        		sysProp.rollbackTransaction();
//	        		rfc.setStatus("Failed");
//	        		result1 = sysProp.updateReportFileCreatorList(rfc);
//	        		if (result1 > 0){
//	        			log.info("transaction Done, Committing "); 
//	        			sysProp.commitTransaction();} else {
//    	        		sysProp.rollbackTransaction();
//    	        		throw new RuntimeException("Unknown Error");
//    	        	 }		 
//	        	}
//	         } catch(DaoException de) {
//	        	 de.printStackTrace();
//	        	 sysProp.rollbackTransaction();
//	         }
//	     }
//	}
//
//    /**
//     * @return baos
//     */
//	public ByteArrayOutputStream getBaos()
//	{
//		return baos;
//	}
//
//	/**
//	 * @param baos
//	 */
//	public void setBaos(ByteArrayOutputStream baos)
//	{
//		this.baos = baos;
//	}
//
//	/**
//	 * @param backupReportThread
//	 */
//	public void setBackupReportThread(BackupReportThread backupReportThread)
//	{
//		this.backupReportThread = backupReportThread;
//	}
//
//	/**
//	 * @return exportReportSuccess
//	 */
//	public Boolean getExportReportSuccess()
//	{
//		return exportReportSuccess;
//	}
//
//	/**
//	 * @param exportReportSuccess
//	 */
//	public void setExportReportSuccess(Boolean exportReportSuccess)
//	{
//		this.exportReportSuccess = exportReportSuccess;
//	}
//	
//	/**
//	 * Method untuk mengkompres file dokumen report buatan jasper dengan format zip
//	 * @param in input stream
//	 * @param reportName nama file report
//	 * @param outputFileName nama file output
//	 * @return 1 jika berhasil, 0 jika gagal mengkompres file
//	 * @throws IOException input / output exception handler
//	 * @throws Exception system exception handler
//	 */
//	 public int createFileZip(InputStream in, String reportName,String outputFileName) throws IOException, Exception {
//        log.info("Zipping File");
//        log.info("inputFileName = "+reportName);
//        log.info("outputFileName = "+outputFileName);
//        int result = 0;
//        final int MAX_COMPRESSION = 9;
//        
//        File inputFile = null;
//        try {
//            inputFile = new File(reportName);
//            FileOutputStream dest = new FileOutputStream(outputFileName);
//            FileInputStream bis = new FileInputStream(inputFile);
//            CheckedOutputStream checksum = new CheckedOutputStream(dest, new Adler32());
//            ZipOutputStream outZip = new ZipOutputStream(new BufferedOutputStream(checksum));
//            outZip.setLevel(MAX_COMPRESSION);
//            File file = new File(reportName);
//            String fileName = file.getName();
//            outZip.putNextEntry(new ZipEntry(fileName));
//
//            byte[] buffer = new byte[1024];
//            int iLength = 0;
//            while ((iLength = bis.read(buffer)) > 0) {
//                outZip.write(buffer, 0, iLength);
//            }
//
//            outZip.flush();
//            outZip.close();
//            bis.close();
//            
//            result = 1;
//        } catch (Exception e) {
//            e.printStackTrace();
//            result = 0;
//        }
//       return result;
//    }
}