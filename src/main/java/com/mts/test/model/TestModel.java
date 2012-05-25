/**
 * 
 */
package com.mts.test.model;

import java.io.Serializable;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

/**
 * @author ctwomey1
 *
 */
public class TestModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String SESSION = "SESSIONVAR";
	
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	@StringLengthFieldValidator(fieldName="name",message="you need a valid name",shortCircuit=true,type=ValidatorType.FIELD,trim=true, minLength="2")
	public void setName(String name) {
		this.name = name;
	}

}
