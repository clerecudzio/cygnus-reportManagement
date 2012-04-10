package com.cygnus.sys.rpt

import com.cygnus.sys.mnm.STMenu

class Report {
	
	String reportCode
	String reportName
	String reportFileName
	String reportControllerName
	STMenu menuCode
	ThReportProperties reportProperties
    static constraints = {
		reportCode unique:true
		reportFileName unique:true
		reportControllerName unique:true
    }
}
