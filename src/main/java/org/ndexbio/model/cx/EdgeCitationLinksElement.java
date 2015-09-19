package org.ndexbio.model.cx;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EdgeCitationLinksElement extends CitationLinksElement {

	public final static String NAME = "EdgeCitation";
	public EdgeCitationLinksElement() {
	}

	public EdgeCitationLinksElement(String sourceId, Collection<String> citationIds ) {
		super(sourceId,citationIds);
	}
	
	@Override
	@JsonIgnore
	public String getAspectName() {
		return NAME;
	}

}