package org.ndexbio.model.cx;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class NodeSupportLinksElement extends SupportLinksElement {

	public static final String ASPECT_NAME = "nodeSupports";
	public NodeSupportLinksElement() {
	}
	
	public NodeSupportLinksElement(Collection<String> sourceId, Collection<String> supportIds ) {
		super(sourceId,supportIds);
	}
	
	public NodeSupportLinksElement(String sourceId, Collection<String> supportIds ) {
		super(sourceId,supportIds);
	}

	@Override
	@JsonIgnore
	public String getAspectName() {
		return ASPECT_NAME;
	}

}
