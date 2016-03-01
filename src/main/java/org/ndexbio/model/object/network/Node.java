/**
 * Copyright (c) 2013, 2016, The Regents of the University of California, The Cytoscape Consortium
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package org.ndexbio.model.object.network;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Node extends NetworkCoreAspectElement
{
    private String _name;
    private Long _representsId;
    private String _representsTermType;
    private Collection<Long> _aliasIds;
    private Collection<Long> _relatedTermIds;
    private Collection<Long> _citationIds;
    private Collection<Long> _supportIds;
    
    
    /**************************************************************************
    * Default constructor.
    **************************************************************************/
    public Node()
    {
        super();
        _representsId = null;
        this.initializeCollections();
    }
    
    /*
     * initialize class Collection fields
     */
    private void initializeCollections() {
    	this._aliasIds = new ArrayList<>();
    	this._relatedTermIds = new ArrayList<>();
    	this._supportIds = new ArrayList<>();
    	this._citationIds = new ArrayList<>();
    }
    
    public Collection<Long> getAliases()
    {
        return _aliasIds;
    }

    public void setAliases(Collection<Long> aliases)
    {
        _aliasIds = aliases;
    }

    public String getName()
    {
        return _name;
    }
    
    public void setName(String name)
    {
        _name = name;
    }

    public Collection<Long> getRelatedTerms()
    {
        return _relatedTermIds;
    }

    public void setRelatedTerms(Collection<Long> relatedTerms)
    {
        _relatedTermIds = relatedTerms;
    }
    
    public Long getRepresents()
    {
        return _representsId;
    }
    
    public void setRepresents(Long representsId)
    {
        _representsId = representsId;
    }




	public Collection<Long> getCitationIds() {
		return _citationIds;
	}




	public void setCitationIds(Collection<Long> _citations) {
		this._citationIds = _citations;
	}




	public Collection<Long> getSupportIds() {
		return _supportIds;
	}




	public void setSupportIds(Collection<Long> _supports) {
		this._supportIds = _supports;
	}




	public String getRepresentsTermType() {
		return _representsTermType;
	}




	public void setRepresentsTermType(String representsTermType) {
		this._representsTermType = representsTermType;
	}

    
}
