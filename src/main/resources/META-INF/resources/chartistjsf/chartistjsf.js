/**
 * @namespace ChartistJSF namespace.
 */

(function(ChartistJSF, $, undefined) {

	ChartistJSF.cw = function(widgetName, widgetVar, cfg) {
		createWidget(widgetName, widgetVar, cfg);
	}

	function createWidget(widgetName, widgetVar, cfg) {
		if (ChartistJSF.widget[widgetName]) {
			initWidget(widgetName, widgetVar, cfg);
		}
	}

	function initWidget(widgetName, widgetVar, cfg) {
		if (PrimeFaces.widgets[widgetVar]) {
			PrimeFaces.widgets[widgetVar].refresh(cfg);
		} else {
			PrimeFaces.widgets[widgetVar] = new ChartistJSF.widget[widgetName](cfg);
			if (PrimeFaces.settings.legacyWidgetNamespace) {
				window[widgetVar] = PrimeFaces.widgets[widgetVar];
			}
		}
	}

	/**
	 * @namespace Namespace for widgets.
	 */
	ChartistJSF.widget = {};

}(window.ChartistJSF = window.ChartistJSF || {}, jQuery));

ChartistJSF.widget.Chart = PrimeFaces.widget.BaseWidget.extend({
	init : function(cfg) {

		var that = this;
		this._super(cfg);
		this.type = this.cfg.type;
		this.data = this.cfg.data;
		this.options = this.cfg.options;
		
		new Chartist[this.type](this.jqId, this.data, this.options);
	},
});
