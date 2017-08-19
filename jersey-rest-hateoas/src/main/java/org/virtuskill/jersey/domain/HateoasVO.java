package org.virtuskill.jersey.domain;

public class HateoasVO {

	private String link;
	private String rel;

	public HateoasVO() {

	}

	public HateoasVO(String link, String rel) {
		super();
		this.link = link;
		this.rel = rel;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

}
