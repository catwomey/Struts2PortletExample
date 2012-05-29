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
		Preparable, ParameterAware, PortletPreferencesAware,
		PortletRequestAware, PortletResponseAware, ModelDriven<TestModel>,
		SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7931085835164992623L;
	private PortletRequest portletRequest;
	private PortletResponse portletResponse;
	private PortletSession portletSession;
	private PortletPreferences prefs;
	private Map<String, String[]> parameters;
	private TestModel model;
	private Map<String, Object> session;

	@VisitorFieldValidator()
	public TestModel getModel() {
		// model = (TestModel) portletSession.getAttribute(
		// TestModel.SESSION, PortletSession.PORTLET_SCOPE);
		model = (TestModel) session.get(TestModel.SESSION);
		if (model == null) {
			model = new TestModel();
		}
		// this.portletSession.setAttribute(TestModel.SESSION, model,
		// PortletSession.PORTLET_SCOPE);
		this.session.put(TestModel.SESSION, model);
		return model;
	}

	public void setPortletResponse(PortletResponse response) {
		portletResponse = response;

	}

	public void setPortletRequest(PortletRequest request) {
		portletRequest = request;

	}

	public void setPortletPreferences(PortletPreferences prefs) {
		this.prefs = prefs;

	}

	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;

	}

	public void prepare() throws Exception {
		portletSession = portletRequest.getPortletSession();

	}

	public String execute() {
		return INPUT;

	}

	@SkipValidation
	public String success() {
		return SUCCESS;

	}

	public String submitForm() {
//		this.portletSession.setAttribute(TestModel.SESSION, model,
//				PortletSession.PORTLET_SCOPE);
		this.session.put(TestModel.SESSION, model);

		return SUCCESS;

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}
}
