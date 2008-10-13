/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.grid;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.gwtext.client.core.SortDir;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.DateFieldDef;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.FloatFieldDef;
import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.SortState;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.BaseColumnConfig;
import com.gwtext.client.widgets.grid.CellMetadata;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.GridView;
import com.gwtext.client.widgets.grid.Renderer;
import com.gwtextux.client.widgets.grid.plugins.ColumnWithRowExpander;
import com.gwtextux.client.widgets.grid.plugins.RowExpanderListener;
import com.gwtextux.client.widgets.grid.plugins.RowExpanderPlugin;
import com.gwtextux.sample.showcase2.client.SampleData;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

/**
 * @author Krzysztof
 *
 */
public class RowExpanderSample extends ShowcasePanel {

	public String getSourceUrl() {
        return "source/grid/RowExpanderSample.java.html";
    }
	
	/* (non-Javadoc)
	 * @see com.gwtextux.sample.showcase2.client.ShowcasePanel#getViewPanel()
	 */
	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();
			panel.setBorder(false);
			panel.setPaddings(15);

			RecordDef recordDef = new RecordDef(new FieldDef[] {
					new StringFieldDef("company"),
					new FloatFieldDef("price"), new FloatFieldDef("change"), new FloatFieldDef("pctChange"),
					new DateFieldDef("lastChanged", "n/j h:ia"), new StringFieldDef("symbol"), new StringFieldDef("industry") 
					 });

			GridPanel grid = new GridPanel();

			Object[][] data = SampleData.getCompanyDataSmall();
			MemoryProxy proxy = new MemoryProxy(data);

			ArrayReader reader = new ArrayReader(recordDef);
			Store store = new Store(proxy, reader);
			store.setSortInfo(new SortState("industry", SortDir.ASC));
			store.load();
			grid.setStore(store);

			final DateTimeFormat dateFormatter = DateTimeFormat.getFormat("M/d/y");
			
			ColumnWithRowExpander columnWithRowExpander = new ColumnWithRowExpander(new RowExpanderListener(){
				public Component onExpand(GridPanel grid, Store underlyingStore, Record record, int rowIndex) {
					 final GridPanel panel = new GridPanel();
					 
					 Object[][] data = new Object[][]{
				                new Object[]{record.getAsString("symbol"), record.getAsFloat("change"), 
				                		record.getAsFloat("pctChange")}};
				 ArrayReader reader = new ArrayReader(new RecordDef(
				   new FieldDef[]{
						   new StringFieldDef("symbol"),
						   new FloatFieldDef("change"), new FloatFieldDef("pctChange")
				     }
				  ));
				 	MemoryProxy dataProxy = new MemoryProxy(data);
				 	Store store = new Store(dataProxy, reader);
				 	store.load();
				 	BaseColumnConfig[] columns = new BaseColumnConfig[] {new ColumnConfig("Symbol", "symbol", 200, true, null, "symbol") ,
							new ColumnConfig("Change", "change", 95, true), new ColumnConfig("% Change", "pctChange", 100, true, null)};
				 	
				 	ColumnModel columnModel = new ColumnModel(columns);
					panel.setStore(store);
					panel.setPaddings(1);
					panel.setBorder(false);
					panel.setFrame(false);
					panel.setColumnModel(columnModel);
					return panel;
				}
			});
			
			BaseColumnConfig[] columns = new BaseColumnConfig[] { columnWithRowExpander, 
					new ColumnConfig("Company", "company", 55, true), new ColumnConfig("Industry", "industry", 55, true),
					new ColumnConfig("Last Updated", "lastChanged", 65, true, new Renderer() {
						public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, 
								int colNum, Store store) {
							Date date = (Date) value;
							return dateFormatter.format(date);
						}
					})};

			ColumnModel columnModel = new ColumnModel(columns);
			grid.setColumnModel(columnModel);

			GridView gridView = new GridView();
			gridView.setForceFit(true);
			gridView.setScrollOffset(10);
			
			final RowExpanderPlugin rowExpanderPlugin = new RowExpanderPlugin(columnWithRowExpander);
			
			grid.setView(gridView);
			grid.setFrame(true);
			grid.setStripeRows(true);
			grid.addPlugin(rowExpanderPlugin);

			grid.setHeight(350);
			grid.setWidth(500);
			grid.setTitle("Grid with Row Expander");

			panel.add(grid);
		}

		return panel;
	}
	
	public String getIntro() {
		return "This example demonstrates the Row Expander plugin <br/>" +
				"<p>This sample, JavaScript and wrapper was added by <b>Krzysztof</b></p>";
	}
}
