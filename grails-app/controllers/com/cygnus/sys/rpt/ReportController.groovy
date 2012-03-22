package com.cygnus.sys.rpt

import org.springframework.dao.DataIntegrityViolationException
import com.cygnus.sys.mnm.STMenu

import grails.converters.JSON

class ReportController {
	 
	def sessionFactory
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }
	
	
    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [reportInstanceList: Report.list(params), reportInstanceTotal: Report.count()]
    }

    def create() {
        [reportInstance: new Report(params)]
    }

    def save() {
        def reportInstance = new Report(params)
		if (!reportInstance.save(flush: true)) {
            render(view: "create", model: [reportInstance: reportInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'report.label', default: 'Report'), reportInstance.id])
        redirect(action: "show", id: reportInstance.id)
    }

    def show() {
        def reportInstance = Report.get(params.id)
        if (!reportInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'report.label', default: 'Report'), params.id])
            redirect(action: "list")
            return
        }

        [reportInstance: reportInstance]
    }

    def edit() {
        def reportInstance = Report.get(params.id)
        if (!reportInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'report.label', default: 'Report'), params.id])
            redirect(action: "list")
            return
        }

        [reportInstance: reportInstance]
    }

    def update() {
        def reportInstance = Report.get(params.id)
        if (!reportInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'report.label', default: 'Report'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (reportInstance.version > version) {
                reportInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'report.label', default: 'Report')] as Object[],
                          "Another user has updated this Report while you were editing")
                render(view: "edit", model: [reportInstance: reportInstance])
                return
            }
        }

        reportInstance.properties = params

        if (!reportInstance.save(flush: true)) {
            render(view: "edit", model: [reportInstance: reportInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'report.label', default: 'Report'), reportInstance.id])
        redirect(action: "show", id: reportInstance.id)
    }

    def delete() {
        def reportInstance = Report.get(params.id)
        if (!reportInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'report.label', default: 'Report'), params.id])
            redirect(action: "list")
            return
        }

        try {
            reportInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'report.label', default: 'Report'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'report.label', default: 'Report'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
