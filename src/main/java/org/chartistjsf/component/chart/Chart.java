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
package org.chartistjsf.component.chart;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponentBase;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.BehaviorEvent;
import javax.faces.event.FacesEvent;

import org.chartistjsf.ChartistJSF;
import org.chartistjsf.model.chart.ChartModel;
import org.primefaces.event.ItemSelectEvent;

/**
 * @author Hatem Alimam
 * @since 0.1
 */
@ResourceDependencies({ @ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
		@ResourceDependency(library = "primefaces", name = "core.js"),
		@ResourceDependency(library = "primefaces", name = "components.js"),
		@ResourceDependency(library = "chartistjsf", name = "chartist-js/chartist.min.css"),
		@ResourceDependency(library = "chartistjsf", name = "chartist-js/chartist.min.js"),
		@ResourceDependency(library = "chartistjsf", name = "chartistjsf.js") })
public class Chart extends UIComponentBase implements org.primefaces.component.api.Widget,
		javax.faces.component.behavior.ClientBehaviorHolder {
	public static final String COMPONENT_TYPE = "org.chartistjsf.component.Chart";

	protected enum PropertyKeys {

		widgetVar, type, model, style, styleClass;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {
		}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
		}
	}

	public Chart() {
		setRendererType(ChartRenderer.RENDERER_TYPE);
	}

	public String getFamily() {
		return ChartistJSF.COMPONENT_FAMILY;
	}

	public java.lang.String getWidgetVar() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.widgetVar, null);
	}

	public void setWidgetVar(java.lang.String _widgetVar) {
		getStateHelper().put(PropertyKeys.widgetVar, _widgetVar);
	}

	public java.lang.String getType() {
		String type = (java.lang.String) getStateHelper().eval(PropertyKeys.type, null);
		type = Character.toUpperCase(type.charAt(0)) + type.substring(1);
		return type;
	}

	public void setType(java.lang.String _type) {
		getStateHelper().put(PropertyKeys.type, _type);
	}

	public ChartModel getModel() {
		return (ChartModel) getStateHelper().eval(PropertyKeys.model, null);
	}

	public void setModel(ChartModel _model) {
		getStateHelper().put(PropertyKeys.model, _model);
	}

	public java.lang.String getStyle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.style, null);
	}

	public void setStyle(java.lang.String _style) {
		getStateHelper().put(PropertyKeys.style, _style);
	}

	public java.lang.String getStyleClass() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.styleClass, null);
	}

	public void setStyleClass(java.lang.String _styleClass) {
		getStateHelper().put(PropertyKeys.styleClass, _styleClass);
	}

	private final static String DEFAULT_EVENT = "itemSelect";

	private static final Collection<String> EVENT_NAMES = Collections.unmodifiableCollection(Arrays
			.asList(DEFAULT_EVENT));

	@Override
	public Collection<String> getEventNames() {
		return EVENT_NAMES;
	}

	@Override
	public String getDefaultEventName() {
		return DEFAULT_EVENT;
	}

	@Override
	public void queueEvent(FacesEvent event) {
		if (event instanceof AjaxBehaviorEvent) {
			BehaviorEvent behaviorEvent = (AjaxBehaviorEvent) event;
			Map<String, String> map = getFacesContext().getExternalContext().getRequestParameterMap();
			int itemIndex = Integer.parseInt(map.get("itemIndex"));
			int seriesIndex = Integer.parseInt(map.get("seriesIndex"));

			ItemSelectEvent itemSelectEvent = new ItemSelectEvent(this, behaviorEvent.getBehavior(), itemIndex,
					seriesIndex);

			super.queueEvent(itemSelectEvent);
		}
	}

	public String resolveWidgetVar() {
		FacesContext context = getFacesContext();
		String userWidgetVar = (String) getAttributes().get("widgetVar");

		if (userWidgetVar != null)
			return userWidgetVar;
		else
			return "widget_" + getClientId(context).replaceAll("-|" + UINamingContainer.getSeparatorChar(context), "_");
	}
}
