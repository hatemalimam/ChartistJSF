package org.chartistjsf.component.chart.renderer;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.chartistjsf.component.chart.Chart;
import org.chartistjsf.model.chart.ChartSeries;
import org.chartistjsf.model.chart.LineChartModel;
import org.primefaces.util.ComponentUtils;

public class LineRenderer extends BaseChartistRenderer {

	@Override
	protected void encodeData(FacesContext context, Chart chart) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		LineChartModel model = (LineChartModel) chart.getModel();

		writer.write(",data:{");
		writer.write("labels: [");
		for (Iterator<Object> labelsItr = model.getLabels().iterator(); labelsItr.hasNext();) {
			Object label = labelsItr.next();

			if (label instanceof String)
				writer.write("\"" + ComponentUtils.escapeText(label.toString()) + "\"");
			else
				writer.write(label.toString());

			if (labelsItr.hasNext()) {
				writer.write(",");
			}
		}
		writer.write("]");

		writer.write(", series:[");
		for (Iterator<ChartSeries> it = model.getSeries().iterator(); it.hasNext();) {
			ChartSeries series = it.next();
			writer.write("[");
			for (Iterator<Number> numbersIter = series.getData().iterator(); numbersIter.hasNext();) {
				Number number = numbersIter.next();
				String numberAsString = (number != null) ? number.toString() : "null";
				
				writer.write(numberAsString);
				
				if (numbersIter.hasNext()) {
					writer.write(",");
				}
												
			}
			writer.write("]");

			if (it.hasNext()) {
				writer.write(",");
			}
		}
		writer.write("]");
		writer.write("}");
	}

	@Override
	protected void encodeOptions(FacesContext context, Chart chart) throws IOException {
		super.encodeOptions(context, chart);

//		ResponseWriter writer = context.getResponseWriter();
//		LineChartModel model = (LineChartModel) chart.getModel();
//
//		writer.write(",series:[");
//		for (Iterator<ChartSeries> it = model.getSeries().iterator(); it.hasNext();) {
//			ChartSeries series = (ChartSeries) it.next();
//			series.encode(writer);
//
//			if (it.hasNext()) {
//				writer.write(",");
//			}
//		}
//
//		writer.write("]");
//
//		if (model.isStacked())
//			writer.write(",stackSeries:true");
//		if (model.isBreakOnNull())
//			writer.write(",breakOnNull:true");
//		if (model.isZoom())
//			writer.write(",zoom:true");
//		if (model.isAnimate())
//			writer.write(",animate:true");
//		if (model.isShowPointLabels())
//			writer.write(",showPointLabels:true");
//
//		if (model.isShowDatatip()) {
//			writer.write(",datatip:true");
//			if (model.getDatatipFormat() != null)
//				writer.write(",datatipFormat:\"" + model.getDatatipFormat() + "\"");
//		}
	}

}
