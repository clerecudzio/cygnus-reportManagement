<%@ page import="com.cygnus.sys.rpt.Report" %>



<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'reportCode', 'error')} ">
	<label for="reportCode">
		<g:message code="report.reportCode.label" default="Report Code" />
		
	</label>
	<g:textField name="reportCode" value="${reportInstance?.reportCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'reportFileName', 'error')} ">
	<label for="reportFileName">
		<g:message code="report.reportFileName.label" default="Report File Name" />
		
	</label>
	<g:textField name="reportFileName" value="${reportInstance?.reportFileName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'reportControllerName', 'error')} ">
	<label for="reportControllerName">
		<g:message code="report.reportControllerName.label" default="Report Controller Name" />
		
	</label>
	<g:textField name="reportControllerName" value="${reportInstance?.reportControllerName}" size="52" readOnly="true"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'menuCode', 'error')} required">
	<label for="menuCode">
		<g:message code="report.menuCode.label" default="Menu Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="menuCode.id" value="${reportInstance?.menuCode?.id}" size="3" readOnly="true"/>
	<g:textField name="menuCodeName" value="${reportInstance?.menuCode?.menuCode}" size="24"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'reportName', 'error')} ">
	<label for="reportName">
		<g:message code="report.reportName.label" default="Report Name" />
		
	</label>
	<g:textField name="reportName" value="${reportInstance?.reportName}"/>
</div>
<script type="text/javascript">
	var menuCodeAjax = '${createLink(action: 'listMenuCodeAsJson', controller:'STMenu')}'
	$(function(){
		 $("#menuCodeName").autocomplete({ 
			    source:function(request,response){
			    	ajaxRequest(menuCodeAjax,request,response);
				    },
			    minLength:2,
			    select:function(event,ui){
			    $("#menuCode\\.id").val(ui.item.id);    
				$("#reportControllerName").val(ui.item.controller);    
				}	
	});
	});
</script>
