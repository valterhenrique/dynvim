package com.valterhenrique.code.json;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"uri", "active", "type", "sizes", "resource_key"})
public class Pictures {

	@JsonProperty("uri")
	private String uri;
	@JsonProperty("active")
	private Boolean active;
	@JsonProperty("type")
	private String type;
	@JsonProperty("sizes")
	private List<Size> sizes = null;
	@JsonProperty("resource_key")
	private String resourceKey;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("uri")
	public String getUri() {
		return uri;
	}

	@JsonProperty("uri")
	public void setUri(String uri) {
		this.uri = uri;
	}

	@JsonProperty("active")
	public Boolean getActive() {
		return active;
	}

	@JsonProperty("active")
	public void setActive(Boolean active) {
		this.active = active;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("sizes")
	public List<Size> getSizes() {
		return sizes;
	}

	@JsonProperty("sizes")
	public void setSizes(List<Size> sizes) {
		this.sizes = sizes;
	}

	@JsonProperty("resource_key")
	public String getResourceKey() {
		return resourceKey;
	}

	@JsonProperty("resource_key")
	public void setResourceKey(String resourceKey) {
		this.resourceKey = resourceKey;
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
