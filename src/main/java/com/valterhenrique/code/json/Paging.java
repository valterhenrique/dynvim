package com.valterhenrique.code.json;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"next", "previous", "first", "last"})
public class Paging {

	@JsonProperty("next")
	private String next;
	@JsonProperty("previous")
	private Object previous;
	@JsonProperty("first")
	private String first;
	@JsonProperty("last")
	private String last;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("next")
	public String getNext() {
		return next;
	}

	@JsonProperty("next")
	public void setNext(String next) {
		this.next = next;
	}

	@JsonProperty("previous")
	public Object getPrevious() {
		return previous;
	}

	@JsonProperty("previous")
	public void setPrevious(Object previous) {
		this.previous = previous;
	}

	@JsonProperty("first")
	public String getFirst() {
		return first;
	}

	@JsonProperty("first")
	public void setFirst(String first) {
		this.first = first;
	}

	@JsonProperty("last")
	public String getLast() {
		return last;
	}

	@JsonProperty("last")
	public void setLast(String last) {
		this.last = last;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
