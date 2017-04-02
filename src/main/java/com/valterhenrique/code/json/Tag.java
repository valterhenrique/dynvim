package com.valterhenrique.code.json;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"uri", "name", "tag", "canonical", "metadata", "resource_key"})
public class Tag {

	@JsonProperty("uri")
	private String uri;
	@JsonProperty("name")
	private String name;
	@JsonProperty("tag")
	private String tag;
	@JsonProperty("canonical")
	private String canonical;
	@JsonProperty("metadata")
	private Metadata metadata;
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

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("tag")
	public String getTag() {
		return tag;
	}

	@JsonProperty("tag")
	public void setTag(String tag) {
		this.tag = tag;
	}

	@JsonProperty("canonical")
	public String getCanonical() {
		return canonical;
	}

	@JsonProperty("canonical")
	public void setCanonical(String canonical) {
		this.canonical = canonical;
	}

	@JsonProperty("metadata")
	public Metadata getMetadata() {
		return metadata;
	}

	@JsonProperty("metadata")
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
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
