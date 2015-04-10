package org.chartistjsf.component.chart;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.chartistjsf.component.chart.renderer.BarRenderer;
import org.chartistjsf.component.chart.renderer.BaseChartistRenderer;
import org.chartistjsf.component.chart.renderer.LineRenderer;
import org.chartistjsf.component.chart.renderer.PieRenderer;
import org.primefaces.renderkit.CoreRenderer;

public class ChartRenderer extends CoreRenderer {
	
	public static final String RENDERER_TYPE = "org.chartistjsf.component.ChartRenderer";

	private final static String TYPE_LINE = "Line";
	private final static String TYPE_BAR = "Bar";
	private final static String TYPE_PIE = "Pie";

	final static Map<String, org.chartistjsf.component.chart.renderer.BaseChartistRenderer> CHART_RENDERERS;

	static {
		CHART_RENDERERS = new HashMap<String, org.chartistjsf.component.chart.renderer.BaseChartistRenderer>();
		CHART_RENDERERS.put(TYPE_LINE, new LineRenderer());
		CHART_RENDERERS.put(TYPE_BAR, new BarRenderer());
		CHART_RENDERERS.put(TYPE_PIE, new PieRenderer());
	}

	@Override
	public void decode(FacesContext context, UIComponent component) {
		super.decodeBehaviors(context, component);
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		Chart chart = (Chart) component;

		encodeMarkup(context, chart);
		encodeScript(context, chart);
	}

	protected void encodeMarkup(FacesContext context, Chart chart) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		String style = chart.getStyle();
		String styleClass = chart.getStyleClass();

		writer.startElement("div", null);
		writer.writeAttribute("id", chart.getClientId(context), null);
		if (style != null)
			writer.writeAttribute("style", style, "style");
		if (styleClass != null)
			writer.writeAttribute("class", styleClass, "styleClass");

		writer.endElement("div");
	}

	protected void encodeScript(FacesContext context, Chart chart) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		String type = chart.getType();
		BaseChartistRenderer chartistRenderer = CHART_RENDERERS.get(type);
		String clientId = chart.getClientId(context);

		startScript(writer, clientId);

		writer.write("$(function(){");
		writer.write("ChartistJSF.cw('Chart','" + chart.resolveWidgetVar() + "',{");
		writer.write("id:'" + clientId + "'");
		writer.write(",type:'" + type + "'");
		encodeClientBehaviors(context, chart);
		writer.write("});});");

		endScript(writer);
	}
}
