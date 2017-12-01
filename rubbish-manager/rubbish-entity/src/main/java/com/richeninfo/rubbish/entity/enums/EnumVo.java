package com.richeninfo.rubbish.entity.enums;



/**
 * 枚举转对象类
 * 
 * @author Eric
 * 
 */
public class EnumVo {

	private String name;
	
	private String s_id;

	private Long id;

	private String toHtml;  //ProcessEnum
	
	private String toView; //ProcessViewEnum
	
	private String viewClass; //ProcessViewEnum

	public EnumVo(String name, Long id) {

		this.name = name;
		this.id = id;

	}

	// ProcessEnum
	public EnumVo(String name, Long id, String toHtml){
		this.name = name;
		this.id = id;
		this.toHtml = toHtml;
	}

	// ProcessViewEnum
	public EnumVo(String name, Long id, String toView, String viewClass) {

		this.name = name;
		this.id = id;
		this.toView = toView;
		this.viewClass = viewClass;
	}

	
	
	public EnumVo(String s_id, String name) {
		super();
		this.s_id = s_id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public String getToHtml() {
		return toHtml;
	}

	public String getViewClass() {
		return viewClass;
	}

	public String getToView() {
		return toView;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}


}
