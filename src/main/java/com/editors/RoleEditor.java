package com.editors;

import com.models.Role;

import java.beans.PropertyEditorSupport;

public class RoleEditor extends PropertyEditorSupport
{
    @Override
    public void setAsText(String id) 
    {
    	Role d;
    	switch(Integer.parseInt(id))
		{
			case 1: d = new Role(1,  "Human Resource"); break;
			case 2: d = new Role(2,  "Finance"); break;
			case 3: d = new Role(3,  "Information Technology"); break;
			default: d = null;
		}
        this.setValue(d);
    }
}
