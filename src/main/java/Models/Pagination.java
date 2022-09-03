package Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pagination{

	@JsonProperty("total")
	private String total;

	@JsonProperty("pages")
	private String pages;

	@JsonProperty("limit")
	private String limit;

	@JsonProperty("page")
	private String page;

	public String getTotal(){
		return total;
	}

	public String getPages(){
		return pages;
	}

	public String getLimit(){
		return limit;
	}

	public String getPage(){
		return page;
	}
}