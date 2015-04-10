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

		var data = {
			labels : [ 'Week1', 'Week2', 'Week3', 'Week4', 'Week5', 'Week6' ],
			series : [ [ 5, 4, 3, 7, 5, 10 ], [ 3, 2, 9, 5, 4, 6 ], [ 2, 1, -3, -4, -2, 0 ] ]
		};

		// We are setting a few options for our chart and override the defaults
		var options = {			
		};

		// All you need to do is pass your configuration as third parameter to
		// the chart function
		new Chartist['Line'](this.jqId, data, options);

	},
});
