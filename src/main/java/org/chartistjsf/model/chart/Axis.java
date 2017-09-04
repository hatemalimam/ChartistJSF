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
import java.util.ArrayList;
import java.util.List;

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
	private AxisPosition axisPosition;
	private int xLabelOffset = 0;
	private int yLabelOffset = 0;
	private boolean showLabel = true;
	private boolean showGrid = true;
	private String labelInterpolationFnc;
	private int scaleMinSpace = 20;
	private boolean onlyInteger = false;
	private AxisType type;
	// used for AxisTypes
	private int divisor = 1;
	private List<Number> ticks;
	private boolean stretch;
	private Integer high;
	private Integer low;

	public Axis() {
		ticks = new ArrayList<Number>();
	}

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
	 * Position where labels are placed. Can be set to AxisPosition.START or AxisPosition.END where `start` is
	 * equivalent to left or top on vertical axis and `end` is equivalent to right or bottom on horizontal axis.
	 * 
	 * @return the axisPosition
	 */
	public AxisPosition getAxisPosition() {
		return axisPosition;
	}

	/**
	 * Position where labels are placed. Can be set to AxisPosition.START or AxisPosition.END where `start` is
	 * equivalent to left or top on vertical axis and `end` is equivalent to right or bottom on horizontal axis.
	 * 
	 * @param axisPosition
	 *            the axisPosition to set
	 */
	public void setAxisPosition(AxisPosition axisPosition) {
		this.axisPosition = axisPosition;
	}

	/**
	 * Allows to correct label positioning on this axis by positive or negative x offset.
	 * 
	 * @return the xLabelOffset
	 */
	public int getXLabelOffset() {
		return xLabelOffset;
	}

	/**
	 * Allows to correct label positioning on this axis by positive or negative x offset.
	 * 
	 * @param xLabelOffset
	 */
	public void setXLabelOffset(int xLabelOffset) {
		this.xLabelOffset = xLabelOffset;
	}

	/**
	 * Allows to correct label positioning on this axis by positive or negative y offset.
	 * 
	 * @return the yLabelOffset
	 */
	public int getYLabelOffset() {
		return yLabelOffset;
	}

	/**
	 * Allows to correct label positioning on this axis by positive or negative y offset.
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
	 * Interpolation function that allows you to intercept the value from the axis label
	 * 
	 * @return the labelInterpolationFnc
	 */
	public String getLabelInterpolationFnc() {
		return labelInterpolationFnc;
	}

	/**
	 * Interpolation function that allows you to intercept the value from the axis label
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

	/**
	 * Use only integer values (whole numbers) for the scale steps
	 * 
	 * @return the onlyInteger
	 */
	public boolean isOnlyInteger() {
		return onlyInteger;
	}

	/**
	 * Use only integer values (whole numbers) for the scale steps
	 * 
	 * @param onlyInteger
	 *            the onlyInteger to set
	 */
	public void setOnlyInteger(boolean onlyInteger) {
		this.onlyInteger = onlyInteger;
	}

	/**
	 * Set the axis type to be used to project values on this axis. If not defined, Chartist.StepAxis will be used for
	 * the X-Axis, where the ticks option will be set to the labels in the data and the stretch option will be set to
	 * the global fullWidth option.
	 * 
	 * Or Chartist.AutoScaleAxis will be used for the Y-Axis, where the high and low options will be set to the global
	 * high and low options. This type can be changed to any axis constructor available (e.g. Chartist.FixedScaleAxis),
	 * where all axis options should be present here.
	 * 
	 * @return the axisType
	 */
	public AxisType getType() {
		return type;
	}

	/**
	 * @param axisType
	 *            the axisType to set
	 */
	public void setType(AxisType type) {
		this.type = type;
	}

	/**
	 * If specified then the value range determined from minimum to maximum (or low and high) will be divided by this
	 * number and ticks will be generated at those division points. The default divisor is 1.
	 * 
	 * @return the divisor
	 */
	public int getDivisor() {
		return divisor;
	}

	/**
	 * If specified then the value range determined from minimum to maximum (or low and high) will be divided by this
	 * number and ticks will be generated at those division points. The default divisor is 1.
	 * 
	 * @param divisor
	 *            the divisor to set
	 */
	public void setDivisor(int divisor) {
		this.divisor = divisor;
	}

	/**
	 * If ticks is explicitly set, then the axis will not compute the ticks with the divisor, but directly use the data
	 * in ticks to determine at what points on the axis a tick need to be generated.
	 * 
	 * @return the ticks
	 */
	public List<Number> getTicks() {
		return ticks;
	}

	/**
	 * Adds a tick
	 * 
	 * @param {@link Number}
	 */
	public void addTick(Number number) {
		ticks.add(number);
	}

	/**
	 * If set to true the full width will be used to distribute the values where the last value will be at the maximum
	 * of the axis length. If false the spaces between the ticks will be evenly distributed instead.
	 * 
	 * @return the stretch
	 */
	public boolean isStretch() {
		return stretch;
	}

	/**
	 * If set to true the full width will be used to distribute the values where the last value will be at the maximum
	 * of the axis length. If false the spaces between the ticks will be evenly distributed instead.
	 * 
	 * @param stretch
	 *            the stretch to set
	 */
	public void setStretch(boolean stretch) {
		this.stretch = stretch;
	}

	/**
	 * If high is specified then the axis will display values explicitly up to this value and the computed maximum from
	 * the data is ignored
	 * 
	 * @return the high
	 */
	public Integer getHigh() {
		return high;
	}

	/**
	 * If high is specified then the axis will display values explicitly up to this value and the computed maximum from
	 * the data is ignored
	 * 
	 * @param high
	 *            the high to set
	 */
	public void setHigh(Integer high) {
		this.high = high;
	}

	/**
	 * This option will be used when finding the right scale division settings. The amount of ticks on the scale will be
	 * determined so that as many ticks as possible will be displayed, while not violating this minimum required space
	 * (in pixel).
	 * 
	 * @return the low
	 */
	public Integer getLow() {
		return low;
	}

	/**
	 * This option will be used when finding the right scale division settings. The amount of ticks on the scale will be
	 * determined so that as many ticks as possible will be displayed, while not violating this minimum required space
	 * (in pixel).
	 * 
	 * @param low
	 *            the low to set
	 */
	public void setLow(Integer low) {
		this.low = low;
	}

	public abstract void render(ResponseWriter writer, AxisType axisType) throws IOException;

}
