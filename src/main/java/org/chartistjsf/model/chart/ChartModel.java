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

import java.io.Serializable;

/**
 * <p>
 * The main model for ChartistJSF
 * <p>
 *
 * @author Hatem Alimam
 * @since 0.1
 */
public class ChartModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8649635660286079308L;

	private String width;
	private String height;
	private String chartPadding;
	private boolean reverseData;

	/**
	 * Specify a fixed width for the chart as a string (i.e. '100px' or '50%')
	 * 
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * Specify a fixed width for the chart as a string (i.e. '100px' or '50%')
	 * 
	 * @param width
	 * the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * Specify a fixed height for the chart as a string (i.e. '100px' or '50%')
	 * 
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * Specify a fixed height for the chart as a string (i.e. '100px' or '50%')
	 * 
	 * @param height
	 * the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * Padding of the chart drawing area to the container element and labels as
	 * a number or padding object {top: 5, right: 5, bottom: 5, left: 5}
	 * 
	 * @return the chartPadding
	 */
	public String getChartPadding() {
		return chartPadding;
	}

	/**
	 * Padding of the chart drawing area to the container element and labels as
	 * a number or padding object {top: 5, right: 5, bottom: 5, left: 5}
	 * 
	 * @param chartPadding
	 * the reverseData to set
	 */
	public void setChartPadding(String chartPadding) {
		this.chartPadding = chartPadding;
	}

	/**
	 * If true the whole data is reversed including labels, the series order as
	 * well as the whole series data arrays.
	 * 
	 * @return the reverseData
	 */
	public boolean isReverseData() {
		return reverseData;
	}

	/**
	 * If true the whole data is reversed including labels, the series order as
	 * well as the whole series data arrays.
	 * 
	 * @param reverseData
	 * the reverseData to set
	 */
	public void setReverseData(boolean reverseData) {
		this.reverseData = reverseData;
	}

}
