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
import java.util.Iterator;

import javax.faces.context.ResponseWriter;

/**
 * @author Hatem Alimam
 * @since 0.1
 */
public class LinearAxis extends Axis {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1502211061227399235L;

	public LinearAxis() {
		setOffset(30);
	}

	public String getRenderer() {
		return "LinearAxisRenderer";
	}

	@Override
	public void render(ResponseWriter writer, AxisType axisType) throws IOException {
		writer.write(axisType + ":{");

		writer.write("offset:" + this.getOffset());

		writer.write(", labelOffset: {");
		writer.write("x:" + getXLabelOffset());
		writer.write(",y:" + getYLabelOffset());
		writer.write("}");

		writer.write(", showLabel: " + this.getShowLabel());
		writer.write(", showGrid: " + this.getShowGrid());

		if (this.getType() != null)
			writer.write(", type: " + this.getType());

		if (this.getAxisPosition() != null) {
			writer.write(", position: '" + this.getAxisPosition() + "'");
		}

		if (getLabelInterpolationFnc() != null && !getLabelInterpolationFnc().equals(""))
			writer.write(", labelInterpolationFnc: " + getLabelInterpolationFnc());

		writer.write(", scaleMinSpace: " + getScaleMinSpace());
		writer.write(", onlyInteger: " + isOnlyInteger());
		writer.write(",divisor:" + getDivisor());
		writer.write(",stretch:" + isStretch());

		if (this.getLow() != null) {
			writer.write(",low:" + getLow());
		}

		if (this.getHigh() != null) {
			writer.write(",high:" + getHigh());
		}

		if (getTicks() != null && !getTicks().isEmpty()) {
			writer.write(", ticks:[");
			for (Iterator<Number> numbersIter = getTicks().iterator(); numbersIter.hasNext();) {
				Number number = numbersIter.next();
				String numberAsString = (number != null) ? number.toString() : "null";

				writer.write(numberAsString);

				if (numbersIter.hasNext()) {
					writer.write(",");
				}

			}
			writer.write("]");
		}

		writer.write("}");
	}
}
