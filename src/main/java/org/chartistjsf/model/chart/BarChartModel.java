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

import java.util.HashMap;

/**
 * @author Hatem Alimam
 * @since 0.1
 */
public class BarChartModel extends CartesianChartModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2635183620629789466L;

	private int seriesBarDistance = 15;
	private boolean stackBars = false;
	private boolean horizontalBars = false;

	@Override
	public void createAxes() {
		axes = new HashMap<AxisType, Axis>();
		axes.put(AxisType.X, new LinearAxis());
		axes.put(AxisType.Y, new LinearAxis());
	}

	/**
	 * Specify the distance in pixel of bars in a group
	 * 
	 * @return the seriesBarDistance
	 */
	public int getSeriesBarDistance() {
		return seriesBarDistance;
	}

	/**
	 * Specify the distance in pixel of bars in a group
	 * 
	 * @param seriesBarDistance
	 *            the seriesBarDistance to set
	 */
	public void setSeriesBarDistance(int seriesBarDistance) {
		this.seriesBarDistance = seriesBarDistance;
	}

	/**
	 * If set to true this property will cause the series bars to be stacked and
	 * form a total for each series point. This will also influence the y-axis
	 * and the overall bounds of the chart. In stacked mode the
	 * seriesBarDistance property will have no effect.
	 * 
	 * @return the stackBars
	 */
	public boolean isStackBars() {
		return stackBars;
	}

	/**
	 * If set to true this property will cause the series bars to be stacked and
	 * form a total for each series point. This will also influence the y-axis
	 * and the overall bounds of the chart. In stacked mode the
	 * seriesBarDistance property will have no effect.
	 * 
	 * @param stackBars
	 *            the stackBars to set
	 */
	public void setStackBars(boolean stackBars) {
		this.stackBars = stackBars;
	}

	/**
	 * Inverts the axes of the bar chart in order to draw a horizontal bar
	 * chart. Be aware that you also need to invert your axis settings as the Y
	 * Axis will now display the labels and the X Axis the values.
	 * 
	 * @return the horizontalBars
	 */
	public boolean isHorizontalBars() {
		return horizontalBars;
	}

	/**
	 * Inverts the axes of the bar chart in order to draw a horizontal bar
	 * chart. Be aware that you also need to invert your axis settings as the Y
	 * Axis will now display the labels and the X Axis the values.
	 * 
	 * @param horizontalBars
	 *            the horizontalBars to set
	 */
	public void setHorizontalBars(boolean horizontalBars) {
		this.horizontalBars = horizontalBars;
	}

}
