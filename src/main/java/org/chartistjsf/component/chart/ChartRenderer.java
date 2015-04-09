package org.chartistjsf.component.chart;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.renderkit.CoreRenderer;

public class ChartRenderer extends CoreRenderer {
	public static final String RENDERER_TYPE = "org.chartistjsf.component.ChartRenderer";

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		Chart chart = (Chart) component;

		encodeMarkup(context, chart);
	}

	private void encodeMarkup(FacesContext context, Chart chart) throws IOException {
		ResponseWriter writer = context.getResponseWriter();

		writer.startElement("div", chart);
		writer.writeAttribute("id", chart.getClientId(), null);
		writer.writeAttribute("class", "ct-chart ct-perfect-fourth ", null);
		writer.endElement("div");
	}
}
