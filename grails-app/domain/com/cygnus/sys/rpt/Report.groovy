package com.cygnus.sys.rpt

import com.cygnus.sys.mnm.STMenu

class Report {
	
	String reportCode
	String reportName
	String reportFileName
	String reportControllerName
	STMenu menuCode
	
    static constraints = {
		reportCode unique:true
		reportFileName unique:true
		reportControllerName unique:true
    }
}
