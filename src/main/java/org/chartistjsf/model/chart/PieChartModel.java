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
import java.util.List;

/**
 * @author Hatem Alimam
 * @since 0.1
 */
public class PieChartModel extends ChartModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2091395699404032744L;
	private List<Number> data = new ArrayList<Number>();
	private int startAngle = 0;
	private int total = 0;
	private boolean donut = false;
	private int donutWidth = 60;
	private boolean showLabel = true;
	private int labelOffset = 0;
	private String labelInterpolationFnc;
	private LabelDirection labelDirection = LabelDirection.NEUTRAL;

	public PieChartModel() {

	}

	public void set(Number number) {
		this.data.add(number);
	}

	/**
	 * @return the data
	 */
	public List<Number> getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(List<Number> data) {
		this.data = data;
	}

	/**
	 * The start angle of the pie chart in degrees where 0 points north. A
	 * higher value offsets the start angle clockwise.
	 * 
	 * @return the startAngle
	 */
	public int getStartAngle() {
		return startAngle;
	}

	/**
	 * The start angle of the pie chart in degrees where 0 points north. A
	 * higher value offsets the start angle clockwise.
	 * 
	 * @param startAngle
	 *            the startAngle to set
	 */
	public void setStartAngle(int startAngle) {
		this.startAngle = startAngle;
	}

	/**
	 * An optional total you can specify. By specifying a total value, the sum
	 * of the values in the series must be this total in order to draw a full
	 * pie. You can use this attribute to draw only parts of a pie or gauge
	 * charts.
	 * 
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * An optional total you can specify. By specifying a total value, the sum
	 * of the values in the series must be this total in order to draw a full
	 * pie. You can use this attribute to draw only parts of a pie or gauge
	 * charts.
	 * 
	 * @param total
	 *            the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * If specified the donut CSS classes will be used and strokes will be drawn
	 * instead of pie slices.
	 * 
	 * @return the donut
	 */
	public boolean isDonut() {
		return donut;
	}

	/**
	 * If specified the donut CSS classes will be used and strokes will be drawn
	 * instead of pie slices.
	 * 
	 * @param donut
	 *            the donut to set
	 */
	public void setDonut(boolean donut) {
		this.donut = donut;
	}

	/**
	 * Specify the donut stroke width.
	 * 
	 * @return the donutWidth
	 */
	public int getDonutWidth() {
		return donutWidth;
	}

	/**
	 * Specify the donut stroke width.
	 * 
	 * @param donutWidth
	 *            the donutWidth to set
	 */
	public void setDonutWidth(int donutWidth) {
		this.donutWidth = donutWidth;
	}

	/**
	 * If a label should be shown or not.
	 * 
	 * @return the showLabel
	 */
	public boolean isShowLabel() {
		return showLabel;
	}

	/**
	 * If a label should be shown or not.
	 * 
	 * @param showLabel
	 *            the showLabel to set
	 */
	public void setShowLabel(boolean showLabel) {
		this.showLabel = showLabel;
	}

	/**
	 * Label position offset from the standard position which is half distance
	 * of the radius. This value can be either positive or negative. Positive
	 * values will position the label away from the center.
	 * 
	 * @return the labelOffset
	 */
	public int getLabelOffset() {
		return labelOffset;
	}

	/**
	 * Label position offset from the standard position which is half distance
	 * of the radius. This value can be either positive or negative. Positive
	 * values will position the label away from the center.
	 * 
	 * @param labelOffset
	 *            the labelOffset to set
	 */
	public void setLabelOffset(int labelOffset) {
		this.labelOffset = labelOffset;
	}

	/**
	 * An interpolation function for the label value
	 * 
	 * @return the labelInterpolationFnc
	 */
	public String getLabelInterpolationFnc() {
		return labelInterpolationFnc;
	}

	/**
	 * An interpolation function for the label value
	 * 
	 * @param labelInterpolationFnc
	 *            the labelInterpolationFnc to set
	 */
	public void setLabelInterpolationFnc(String labelInterpolationFnc) {
		this.labelInterpolationFnc = labelInterpolationFnc;
	}

	/**
	 * Label direction can be 'neutral', 'explode' or 'implode'. The labels
	 * anchor will be positioned based on those settings as well as the fact if
	 * the labels are on the right or left side of the center of the chart.
	 * Usually explode is useful when labels are positioned far away from the
	 * center.
	 * 
	 * @return the labelDirection
	 */
	public LabelDirection getLabelDirection() {
		return labelDirection;
	}

	/**
	 * Label direction can be 'neutral', 'explode' or 'implode'. The labels
	 * anchor will be positioned based on those settings as well as the fact if
	 * the labels are on the right or left side of the center of the chart.
	 * Usually explode is useful when labels are positioned far away from the
	 * center.
	 * 
	 * @param labelDirection
	 *            the labelDirection to set
	 */
	public void setLabelDirection(LabelDirection labelDirection) {
		this.labelDirection = labelDirection;
	}

}
