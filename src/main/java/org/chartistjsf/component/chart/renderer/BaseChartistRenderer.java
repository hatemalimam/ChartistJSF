package org.chartistjsf.component.chart.renderer;

import java.io.IOException;

import javax.faces.context.FacesContext;

import org.chartistjsf.component.chart.Chart;

public abstract class BaseChartistRenderer {
	
	public void render(FacesContext context, Chart chart) throws IOException {
		encodeData(context, chart);
		encodeOptions(context, chart);
	}

	protected abstract void encodeData(FacesContext context, Chart chart) throws IOException;

	protected void encodeOptions(FacesContext context, Chart chart) throws IOException {		

	}
}
