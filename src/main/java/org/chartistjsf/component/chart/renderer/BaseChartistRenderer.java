package org.chartistjsf.component.chart.renderer;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.chartistjsf.component.chart.Chart;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LegendPlacement;
import org.primefaces.util.ComponentUtils;

public abstract class BaseChartistRenderer {
	
	public void render(FacesContext context, Chart chart) throws IOException {
		encodeData(context, chart);
		encodeOptions(context, chart);
	}

	protected abstract void encodeData(FacesContext context, Chart chart) throws IOException;

	protected void encodeOptions(FacesContext context, Chart chart) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		ChartModel model = chart.getModel();
		String legendPosition = model.getLegendPosition();
		String title = model.getTitle();
		String seriesColors = model.getSeriesColors();
		String negativeSeriesColors = model.getNegativeSeriesColors();
		String extender = model.getExtender();

		if (title != null)
			writer.write(",title:\"" + ComponentUtils.escapeText(title) + "\"");

		if (!model.isShadow())
			writer.write(",shadow:false");

		if (seriesColors != null)
			writer.write(",seriesColors:[\"#" + seriesColors.replaceAll("[ ]*,[ ]*", "\",\"#") + "\"]");

		if (negativeSeriesColors != null)
			writer.write(",negativeSeriesColors:[\"#" + negativeSeriesColors.replaceAll("[ ]*,[ ]*", "\",\"#") + "\"]");

		if (legendPosition != null) {
			LegendPlacement legendPlacement = model.getLegendPlacement();
			writer.write(",legendPosition:\"" + legendPosition + "\"");

			if (model.getLegendCols() != 0)
				writer.write(",legendCols:" + model.getLegendCols());

			if (model.getLegendRows() != 0)
				writer.write(",legendRows:" + model.getLegendRows());

			if (legendPlacement != null)
				writer.write(",legendPlacement:\"" + legendPlacement + "\"");
		}

		if (!model.isMouseoverHighlight())
			writer.write(",highlightMouseOver:" + false);

		if (extender != null)
			writer.write(",extender:" + extender);

	}
}
