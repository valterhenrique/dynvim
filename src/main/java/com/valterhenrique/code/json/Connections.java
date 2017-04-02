package com.valterhenrique.code.json;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"videos"})
public class Connections {

	@JsonProperty("videos")
	private Videos videos;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("videos")
	public Videos getVideos() {
		return videos;
	}

	@JsonProperty("videos")
	public void setVideos(Videos videos) {
		this.videos = videos;
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
