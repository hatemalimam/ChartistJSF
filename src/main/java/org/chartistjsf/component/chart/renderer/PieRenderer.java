package org.chartistjsf.component.chart.renderer;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.chartistjsf.component.chart.Chart;
import org.chartistjsf.model.chart.PieChartModel;
import org.primefaces.util.ComponentUtils;

public class PieRenderer extends BaseChartistRenderer {

	@Override
	protected void encodeData(FacesContext context, Chart chart) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		PieChartModel model = (PieChartModel) chart.getModel();

		writer.write(",data:{");

		if (!model.getLabels().isEmpty()) {
			writer.write("labels: [");
			for (Iterator<Object> labelsItr = model.getLabels().iterator(); labelsItr.hasNext();) {
				Object label = labelsItr.next();

				if (label instanceof String)
					writer.write("\"" + ComponentUtils.escapeText(label.toString()) + "\"");
				else
					writer.write(label !=null?label.toString():"");

				if (labelsItr.hasNext()) {
					writer.write(",");
				}
			}
			writer.write("],");
		}

		writer.write(" series:[");
		for (Iterator<Number> numbersIter = model.getData().iterator(); numbersIter.hasNext();) {
			Number number = numbersIter.next();
			String numberAsString = (number != null) ? number.toString() : "null";

			writer.write(numberAsString);

			if (numbersIter.hasNext()) {
				writer.write(",");

			}
		}

		writer.write("]");
		writer.write("}");
	}

	@Override
	protected void encodeOptions(FacesContext context, Chart chart) throws IOException {
		super.encodeOptions(context, chart);

		ResponseWriter writer = context.getResponseWriter();
		PieChartModel model = (PieChartModel) chart.getModel();
		writer.write(",animateAdvanced:" + model.isAnimateAdvanced());
		// writer.write(",animatePath:" + model.isAnimatePath());
		writer.write(",options:{");
		writer.write("startAngle:" + model.getStartAngle());
		writer.write(",total:" + model.getTotal());
		writer.write(",donut:" + model.isDonut());
		writer.write(",donutWidth:" + model.getDonutWidth());
		writer.write(",showLabel:" + model.isShowLabel());
		writer.write(",labelOffset:" + model.getLabelOffset());
		if (model.getWidth() != null)
			writer.write(",width:\"" + ComponentUtils.escapeText(model.getWidth()) + "\"");

		if (model.getHeight() != null)
			writer.write(",height:\"" + ComponentUtils.escapeText(model.getHeight()) + "\"");

		if (model.getLabelInterpolationFnc() != null && !model.getLabelInterpolationFnc().equals(""))
			writer.write(", labelInterpolationFnc: " + model.getLabelInterpolationFnc());

		writer.write(",labelDirection:'" + model.getLabelDirection() + "'");

		if (model.getChartPadding() != null)
			writer.write(",chartPadding:" + model.getChartPadding());

		writer.write(",reverseData:" + model.isReverseData());

		writer.write("}");
	}

}
