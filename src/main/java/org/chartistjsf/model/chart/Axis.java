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

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.ResponseWriter;

/**
 * @author Hatem Alimam
 * @since 0.1
 */
public abstract class Axis implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6059542550827836357L;

	private int offset = 30;
	private int xLabelOffset = 0;
	private int yLabelOffset = 0;
	private boolean showLabel = true;
	private boolean showGrid = true;
	private String labelInterpolationFnc;
	private int scaleMinSpace = 20;

	/**
	 * The offset of the labels to the chart area
	 * 
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * The offset of the labels to the chart area
	 * 
	 * @param offset
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * Allows to correct label positioning on this axis by positive or negative
	 * x offset.
	 * 
	 * @return the xLabelOffset
	 */
	public int getXLabelOffset() {
		return xLabelOffset;
	}

	/**
	 * Allows to correct label positioning on this axis by positive or negative
	 * x offset.
	 * 
	 * @param xLabelOffset
	 */
	public void setXLabelOffset(int xLabelOffset) {
		this.xLabelOffset = xLabelOffset;
	}

	/**
	 * Allows to correct label positioning on this axis by positive or negative
	 * y offset.
	 * 
	 * @return the yLabelOffset
	 */
	public int getYLabelOffset() {
		return yLabelOffset;
	}

	/**
	 * Allows to correct label positioning on this axis by positive or negative
	 * y offset.
	 * 
	 * @param yLabelOffset
	 */
	public void setYLabelOffset(int yLabelOffset) {
		this.yLabelOffset = yLabelOffset;
	}

	/**
	 * If labels should be shown or not
	 * 
	 * @return the showLabel
	 */
	public boolean getShowLabel() {
		return showLabel;
	}

	/**
	 * If labels should be shown or not
	 * 
	 * @param showLabel
	 *            the showLabel to set
	 */
	public void setShowLabel(boolean showLabel) {
		this.showLabel = showLabel;
	}

	/**
	 * If the axis grid should be drawn or not
	 * 
	 * @return the showGrid
	 */
	public boolean getShowGrid() {
		return showGrid;
	}

	/**
	 * If the axis grid should be drawn or not
	 * 
	 * @param showGrid
	 *            the showGrid to set
	 */
	public void setShowGrid(boolean showGrid) {
		this.showGrid = showGrid;
	}

	/**
	 * Interpolation function that allows you to intercept the value from the
	 * axis label
	 * 
	 * @return the labelInterpolationFnc
	 */
	public String getLabelInterpolationFnc() {
		return labelInterpolationFnc;
	}

	/**
	 * Interpolation function that allows you to intercept the value from the
	 * axis label
	 * 
	 * @param labelInterpolationFnc
	 *            the labelInterpolationFnc to set
	 */
	public void setLabelInterpolationFnc(String labelInterpolationFnc) {
		this.labelInterpolationFnc = labelInterpolationFnc;
	}

	/**
	 * This value specifies the minimum height in pixel of the scale steps
	 * 
	 * @return the scaleMinSpace
	 */
	public int getScaleMinSpace() {
		return scaleMinSpace;
	}

	/**
	 * This value specifies the minimum height in pixel of the scale steps
	 * 
	 * @param scaleMinSpace
	 *            the scaleMinSpace to set
	 */
	public void setScaleMinSpace(int scaleMinSpace) {
		this.scaleMinSpace = scaleMinSpace;
	}

	public abstract void render(ResponseWriter writer, AxisType axisType) throws IOException;

}
