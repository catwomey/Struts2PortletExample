<%@ taglib prefix="s" uri="/struts-tags"%>
<s:actionerror escape="false" cssClass="alert" />
<s:form id="createprofile" action="submitForm" theme="simple"
	portletUrlType="action" namespace="">

	<ul>
		<li><s:fielderror fieldName="model.name" escape="false"
				cssClass="alert" /> <s:label for="name"
				 >name</s:label> <s:textfield id="name"
				name="name" required="true" /></li>
			
	</ul>
	<s:submit />
</s:form>