package com.cygnus.sys.rpt

class UniversalReportController {
	def universalSearchService

	def generateReportDefaultParams(){
		def results = universalSearchService.generateSearchParameters(params)
		def outputMap = [:]
		results.each{ type ->
			if (type.equals("strings"))
				type.value.each{ stringsvalue ->
					stringsvalue.each{ detail ->
						detail.value = message(code:type.key+"."+detail.key)
					}
				}
		}
		log.info "for view "+results.toString()
		outputMap.put("strings", results.strings)
		render (view:"showSearch",model:[searchParams:outputMap,"cygnusSearchDomainClassName":params.dcName])
	}
}
