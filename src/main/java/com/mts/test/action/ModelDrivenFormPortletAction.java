/**
 * 
 */
package com.mts.test.action;

import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.portlet.interceptor.PortletPreferencesAware;
import org.apache.struts2.portlet.interceptor.PortletRequestAware;
import org.apache.struts2.portlet.interceptor.PortletResponseAware;

import com.mts.test.model.TestModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

/**
 * @author ctwomey1
 * 
 */
public class ModelDrivenFormPortletAction extends ActionSupport implements
	 PortletPreferencesAware, ModelDriven<TestModel>,
		SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7931085835164992623L;
	private PortletRequest portletRequest;
	
	private TestModel model = new TestModel();
	private Map<String, Object> session;

	@VisitorFieldValidator()
	public TestModel getModel() {
		return model;
	}

	
	public void setPortletPreferences(PortletPreferences prefs) {

	}



	public String execute() {
		return INPUT;

	}

	@SkipValidation
	public String success() {
		return SUCCESS;

	}

	public String submitForm() {

		return SUCCESS;

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}


}
