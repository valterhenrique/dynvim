package com.valterhenrique.code.json;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
		{"uri", "name", "link", "location", "bio", "created_time", "account", "pictures", "websites", "metadata",
				"resource_key", "preferences"})
public class User {

	@JsonProperty("uri")
	private String uri;
	@JsonProperty("name")
	private String name;
	@JsonProperty("link")
	private String link;
	@JsonProperty("location")
	private String location;
	@JsonProperty("bio")
	private String bio;
	@JsonProperty("created_time")
	private String createdTime;
	@JsonProperty("account")
	private String account;
	@JsonProperty("pictures")
	private Pictures__ pictures;
	@JsonProperty("websites")
	private List<Website> websites = null;
	@JsonProperty("metadata")
	private Metadata__ metadata;
	@JsonProperty("resource_key")
	private String resourceKey;
	@JsonProperty("preferences")
	private Preferences preferences;
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

	@JsonProperty("link")
	public String getLink() {
		return link;
	}

	@JsonProperty("link")
	public void setLink(String link) {
		this.link = link;
	}

	@JsonProperty("location")
	public String getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}

	@JsonProperty("bio")
	public String getBio() {
		return bio;
	}

	@JsonProperty("bio")
	public void setBio(String bio) {
		this.bio = bio;
	}

	@JsonProperty("created_time")
	public String getCreatedTime() {
		return createdTime;
	}

	@JsonProperty("created_time")
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	@JsonProperty("account")
	public String getAccount() {
		return account;
	}

	@JsonProperty("account")
	public void setAccount(String account) {
		this.account = account;
	}

	@JsonProperty("pictures")
	public Pictures__ getPictures() {
		return pictures;
	}

	@JsonProperty("pictures")
	public void setPictures(Pictures__ pictures) {
		this.pictures = pictures;
	}

	@JsonProperty("websites")
	public List<Website> getWebsites() {
		return websites;
	}

	@JsonProperty("websites")
	public void setWebsites(List<Website> websites) {
		this.websites = websites;
	}

	@JsonProperty("metadata")
	public Metadata__ getMetadata() {
		return metadata;
	}

	@JsonProperty("metadata")
	public void setMetadata(Metadata__ metadata) {
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

	@JsonProperty("preferences")
	public Preferences getPreferences() {
		return preferences;
	}

	@JsonProperty("preferences")
	public void setPreferences(Preferences preferences) {
		this.preferences = preferences;
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
