package com.valterhenrique.code.json;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"connections"})
public class Metadata {

	@JsonProperty("connections")
	private Connections connections;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("connections")
	public Connections getConnections() {
		return connections;
	}

	@JsonProperty("connections")
	public void setConnections(Connections connections) {
		this.connections = connections;
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
