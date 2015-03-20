package org.ndexbio.model.object.network;


import java.util.ArrayList;
import java.util.List;

import org.ndexbio.model.object.NdexExternalObject;
import org.ndexbio.model.object.NdexPropertyValuePair;
import org.ndexbio.model.object.PropertiedObject;
import org.ndexbio.model.object.SimplePropertyValuePair;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)


public class NetworkSummary extends NdexExternalObject implements PropertiedObject {

    private String _description;
    private int _edgeCount;
    private boolean _isComplete;
    private boolean _isLocked;
    private VisibilityType _visibility;
    private boolean _isReadOnly;
    private String _name;
    private int _nodeCount;
    private String _owner;
    
    private String _URI;
    
//	private long _highestElementId;
	private String _version;
	
	private List<NdexPropertyValuePair> _properties;
	private List<SimplePropertyValuePair> _presentationProperties;

	
	public NetworkSummary () {
		super();
        _type = this.getClass().getSimpleName();

        _isComplete = false;
        _isLocked = false;
    //    setVisibility(VisibilityType.PRIVATE);
        _edgeCount = 0;
        _nodeCount = 0;
        
        _properties = new ArrayList<NdexPropertyValuePair> (10);
    	_presentationProperties = new ArrayList<SimplePropertyValuePair> (10);

	}

    public String getDescription()
    {
        return _description;
    }
    
    public void setDescription(String description)
    {
        _description = description;
    }
    
    public int getEdgeCount()
    {
        return _edgeCount;
    }

    public void setEdgeCount(int edgeCount)
    {
        _edgeCount = edgeCount;
    }
	
	
	public String getVersion() {
		return _version;
	}


	public void setVersion(String version) {
		this._version = version;
	}


	public VisibilityType getVisibility() {
		return _visibility;
	}


	public void setVisibility(VisibilityType visibility) {
		this._visibility = visibility;
	}

    public boolean getIsComplete()
    {
        return _isComplete;
    }
    
    public void setIsComplete(boolean isComplete)
    {
        _isComplete = isComplete;
    }

    public boolean getIsLocked()
    {
        return _isLocked;
    }
    
    public void setIsLocked(boolean isLocked)
    {
        _isLocked = isLocked;
    }
    
    public String getName()
    {
        return _name;
    }
    
    public void setName(String name)
    {
        _name = name;
    }

    public int getNodeCount()
    {
        return _nodeCount;
    }

    public void setNodeCount(int nodeCount)
    {
        _nodeCount = nodeCount;
    }

	public List<NdexPropertyValuePair> getProperties() {
		return _properties;
	}

	public List<SimplePropertyValuePair> getPresentationProperties() {
		return _presentationProperties;
	}

	public void setProperties(List<NdexPropertyValuePair> properties) {
		_properties = properties;
	}

	public void setPresentationProperties(List<SimplePropertyValuePair> properties) {
		_presentationProperties = properties;
	}

	public String getURI() {
		return _URI;
	}

	public void setURI(String URI) {
		this._URI = URI;
	}

	public boolean getIsReadOnly() {
		return _isReadOnly;
	}

	public void setIsReadOnly(boolean isReadOnly) {
		this._isReadOnly = isReadOnly;
	}

	public String getOwner() {
		return _owner;
	}

	public void setOwner(String owner) {
		this._owner = owner;
	}


    
}
