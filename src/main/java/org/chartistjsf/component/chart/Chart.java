package org.chartistjsf.component.chart;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;

import org.chartistjsf.ChartistJSF;

@ResourceDependencies({ @ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
		@ResourceDependency(library = "primefaces", name = "primefaces.js"),
		@ResourceDependency(library = "chartistjsf", name = "chartist-js/chartist.min.css"),
		@ResourceDependency(library = "chartistjsf", name = "chartist-js/chartist.min.js") })
public class Chart extends org.primefaces.component.chart.Chart {
	public static final String COMPONENT_TYPE = "org.chartistjsf.component.Chart";

	public Chart() {
		setRendererType(ChartRenderer.RENDERER_TYPE);
	}

	public String getFamily() {
		return ChartistJSF.COMPONENT_FAMILY;
	}
}
