/*******************************************************************************
 * Copyright (C) 2007 The University of Manchester   
 * 
 *  Modifications to the initial code base are copyright of their
 *  respective authors, or their employers as appropriate.
 * 
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public License
 *  as published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 *    
 *  This program is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *    
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 ******************************************************************************/
package net.sf.taverna.t2.activities.biomart.query;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import net.sf.taverna.t2.activities.biomart.BiomartActivity;
import net.sf.taverna.t2.partition.AbstractActivityItem;
import net.sf.taverna.t2.workflowmodel.processor.activity.Activity;

import org.biomart.martservice.MartQuery;
import org.biomart.martservice.MartServiceXMLHandler;

public class BiomartActivityItem extends AbstractActivityItem {
	
	private String url;
	private String dataset;
	private String location;
	private MartQuery biomartQuery;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return "Biomart";
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDataset() {
		return dataset;
	}

	public void setDataset(String dataset) {
		this.dataset = dataset;
	}

	@Override
	public Object getConfigBean() {
		return MartServiceXMLHandler.martQueryToElement(biomartQuery, null);
	}

	@Override
	public Icon getIcon() {
		return new ImageIcon(BiomartActivityItem.class.getResource("/biomart.png"));
	}

	@Override
	public Activity<?> getUnconfiguredActivity() {
		return new BiomartActivity();
	}

	protected void setMartQuery(MartQuery biomartQuery) {
		this.biomartQuery = biomartQuery;
	}

	@Override
	public String toString() {
		return dataset;
	}
	
	

}