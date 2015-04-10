/*
 * Copyright 2015 ChartistJSF.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.chartistjsf.model.chart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hatem Alimam Since 0.1
 */
public class CartesianChartModel extends ChartModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6182574506516748699L;

	private List<ChartSeries> series;
	protected Map<AxisType, Axis> axes;
	private int high;
	private int low;

	public CartesianChartModel() {
		series = new ArrayList<ChartSeries>();
		createAxes();
	}

	/**
	 * Creates the default Axes for CartesianChartModel
	 * 
	 */
	protected void createAxes() {
		axes = new HashMap<AxisType, Axis>();
		axes.put(AxisType.X, new LinearAxis());
		axes.put(AxisType.Y, new LinearAxis());
	}

	/**
	 * Returns the current Series
	 * 
	 * @return List<ChartSeries>
	 */
	public List<ChartSeries> getSeries() {
		return series;
	}

	/**
	 * Adds a series
	 * 
	 * @param {@link ChartSeries}
	 */
	public void addSeries(ChartSeries chartSeries) {
		this.series.add(chartSeries);
	}

	/**
	 * Clears the added series
	 * 
	 */
	public void clear() {
		this.series.clear();
	}

	/**
	 * Returns the current Axes
	 * 
	 * @return Map<AxisType, Axis>
	 */
	public Map<AxisType, Axis> getAxes() {
		return axes;
	}

	/**
	 * Returns the appropriate Axis based on the supplied type
	 * 
	 * @param {@link AxisType}
	 * @return the {@link Axis}
	 */
	public Axis getAxis(AxisType type) {
		return axes.get(type);
	}

	/**
	 * Overriding the natural high of the chart allows you to zoom in or limit
	 * the charts highest displayed value
	 * 
	 * @return the high
	 */
	public int getHigh() {
		return high;
	}

	/**
	 * Overriding the natural high of the chart allows you to zoom in or limit
	 * the charts highest displayed value
	 * 
	 * @param high
	 * the high to set
	 */
	public void setHigh(int high) {
		this.high = high;
	}

	/**
	 * Overriding the natural low of the chart allows you to zoom in or limit
	 * the charts lowest displayed value
	 * 
	 * @return the low
	 */
	public int getLow() {
		return low;
	}

	/**
	 * Overriding the natural low of the chart allows you to zoom in or limit
	 * the charts lowest displayed value
	 * 
	 * @param low
	 * the low to set
	 */
	public void setLow(int low) {
		this.low = low;
	}

}
