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

/**
 * @author Hatem Alimam
 * @since 0.1
 */
public class LineChartModel extends CartesianChartModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4572261473336806816L;

	private boolean showLine = true;
	private boolean showPoint = true;
	private boolean showArea = false;
	private int areaBase = 0;
	private boolean lineSmooth = true;
	private boolean fullWidth = false;
	

	/**
	 * If the line should be drawn or not
	 * 
	 * @return the showLine
	 */
	public boolean isShowLine() {
		return showLine;
	}

	/**
	 * If the line should be drawn or not
	 * 
	 * @param showLine
	 *            the showLine to set
	 */
	public void setShowLine(boolean showLine) {
		this.showLine = showLine;
	}

	/**
	 * If dots should be drawn or not
	 * 
	 * @return the showPoint
	 */
	public boolean isShowPoint() {
		return showPoint;
	}

	/**
	 * If dots should be drawn or not
	 * 
	 * @param showPoint
	 *            the showPoint to set
	 */
	public void setShowPoint(boolean showPoint) {
		this.showPoint = showPoint;
	}

	/**
	 * If the line chart should draw an area
	 * 
	 * @return the showArea
	 */
	public boolean isShowArea() {
		return showArea;
	}

	/**
	 * If the line chart should draw an area
	 * 
	 * @param showArea
	 *            the showArea to set
	 */
	public void setShowArea(boolean showArea) {
		this.showArea = showArea;
	}

	/**
	 * The base for the area chart that will be used to close the area shape (is
	 * normally 0)
	 * 
	 * @return the areaBase
	 */
	public int getAreaBase() {
		return areaBase;
	}

	/**
	 * The base for the area chart that will be used to close the area shape (is
	 * normally 0)
	 * 
	 * @param areaBase
	 *            the areaBase to set
	 */
	public void setAreaBase(int areaBase) {
		this.areaBase = areaBase;
	}

	/**
	 * Specify if the lines should be smoothed. This value true will result in
	 * smoothing using the default smoothing interpolation function
	 * Chartist.Interpolation.cardinal and false results in
	 * Chartist.Interpolation.none. You can also choose other smoothing /
	 * interpolation functions available in the Chartist.Interpolation module,
	 * or write your own interpolation function. Check the examples for a brief
	 * description.
	 * 
	 * @return the lineSmooth
	 */
	public boolean isLineSmooth() {
		return lineSmooth;
	}

	/**
	 * Specify if the lines should be smoothed. This value true will result in
	 * smoothing using the default smoothing interpolation function
	 * Chartist.Interpolation.cardinal and false results in
	 * Chartist.Interpolation.none. You can also choose other smoothing /
	 * interpolation functions available in the Chartist.Interpolation module,
	 * or write your own interpolation function. Check the examples for a brief
	 * description.
	 * 
	 * @param lineSmooth
	 *            the lineSmooth to set
	 */
	public void setLineSmooth(boolean lineSmooth) {
		this.lineSmooth = lineSmooth;
	}

	/**
	 * When set to true, the last grid line on the x-axis is not drawn and the
	 * chart elements will expand to the full available width of the chart. For
	 * the last label to be drawn correctly you might need to add chart padding
	 * or offset the last label with a draw event handler.
	 * 
	 * @return the fullWidth
	 */
	public boolean isFullWidth() {
		return fullWidth;
	}

	/**
	 * When set to true, the last grid line on the x-axis is not drawn and the
	 * chart elements will expand to the full available width of the chart. For
	 * the last label to be drawn correctly you might need to add chart padding
	 * or offset the last label with a draw event handler.
	 * 
	 * @param fullWidth
	 *            the fullWidth to set
	 */
	public void setFullWidth(boolean fullWidth) {
		this.fullWidth = fullWidth;
	}	
}
