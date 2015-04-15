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

		this.chart = new Chartist[this.type](this.jqId, this.data, this.options);

		this.bindEvents();
	},
	bindEvents : function() {
		var $this = this;

		if (this.cfg.showTooltip)
			$this.tooltip();

		if (this.cfg.animateAdvanced)
			$this.animateAdvanced();

		if (this.cfg.animatePath)
			$this.animatePath();

		if (this.cfg.behaviors['itemSelect']) {
			if (this.type == 'Line') {
				this.jq.on('click', '.ct-point', function(event) {
					$this.invokeItemSelectBehavior(event, $(this).index() - 1, $(this).parent().parent().find(
							'.ct-series').index($(this).parent()))
				});
			} else if (this.type == 'Bar') {
				this.jq.on('click', '.ct-bar', function(event) {
					$this.invokeItemSelectBehavior(event, $(this).index(), $(this).parent().parent().find('.ct-series')
							.index($(this).parent()))
				});
			} else if (this.type == 'Pie') {
				this.jq.on('click', '.ct-slice', function(event) {
					var element = jQuery(this).parent();
					var reverseIndex = element.parent().children().length - (element.index() + 1);
					$this.invokeItemSelectBehavior(event, reverseIndex, reverseIndex)
				});
			}

		}
	},

	invokeItemSelectBehavior : function(event, itemIndex, seriesIndex) {
		if (this.cfg.behaviors) {
			var itemSelectBehavior = this.cfg.behaviors['itemSelect'];

			if (itemSelectBehavior) {
				var ext = {
					params : [ {
						name : 'itemIndex',
						value : itemIndex
					}, {
						name : 'seriesIndex',
						value : seriesIndex
					} ]
				};

				itemSelectBehavior.call(this, ext);
			}
		}
	},

	tooltip : function() {
		var $chart = this.jq;
		var $toolTip = $chart.append('<div class="ct-tooltip"></div>').find('.ct-tooltip').hide();
		var chartType = this.type;

		$chart.on('mouseenter', '.ct-point, .ct-bar, .ct-slice', function() {
			var $point = $(this), value = $point.attr('ct:value'), seriesName = $point.parent().attr('ct:series-name');
			var tooltipText = value;
			if (chartType !== 'Pie') {
				tooltipText = seriesName + '<br>' + value;
			}
			$toolTip.html(tooltipText).show();
		});

		$chart.on('mouseleave', '.ct-point, .ct-bar, .ct-slice', function() {
			$toolTip.hide();
		});

		$chart.on('mousemove', function(event) {
			$toolTip.css({
				left : (event.offsetX || event.originalEvent.layerX) - $toolTip.width() / 2 - 10,
				top : (event.offsetY || event.originalEvent.layerY) - $toolTip.height() - 40
			});
		});
	},

	animatePath : function() {
		var chart = this.chart;
		chart.on('draw', function(data) {
			if (data.type === 'line' || data.type === 'area') {
				data.element.animate({
					d : {
						begin : 1000 * data.index,
						dur : 2000,
						from : data.path.clone().scale(1, 0).translate(0, data.chartRect.height()).stringify(),
						to : data.path.clone().stringify(),
						easing : Chartist.Svg.Easing.easeOutQuint
					}
				});
			} else if (data.type === 'bar') {
				if (chart.options.horizontalBars) {
					data.element.animate({
						x2 : {
							begin : 500 * data.index,
							dur : 1000,
							from : data.x1,
							to : data.x2,
							easing : Chartist.Svg.Easing.easeOutQuint
						},
						opacity : {
							dur : 1000,
							from : 0,
							to : 1,
							easing : Chartist.Svg.Easing.easeOutQuint
						}
					});
				} else {
					data.element.animate({
						y2 : {
							begin : 500 * data.index,
							dur : 1000,
							from : data.y1,
							to : data.y2,
							easing : Chartist.Svg.Easing.easeOutCirc
						},
						opacity : {
							begin : 500 * data.index,
							dur : 1000,
							from : 0,
							to : 1,
							easing : Chartist.Svg.Easing.easeOutCirc
						}
					});
				}
			}
		});
	},

	animateAdvanced : function() {
		var chart = this.chart;
		// Let's put a sequence number aside so we can use it in the event
		// callbacks
		var seq = 0, delays = 80, durations = 500;

		// Once the chart is fully created we reset the sequence
		chart.on('created', function() {
			seq = 0;
		});

		// On each drawn element by Chartist we use the Chartist.Svg API to
		// trigger SMIL animations
		chart.on('draw', function(data) {
			seq++;
			if (data.type === 'line') {
				// If the drawn element is a line we do a simple opacity fade
				// in.
				// This could also be achieved using CSS3 animations.
				data.element.animate({
					opacity : {
						// The delay when we like to start the animation
						begin : seq * delays + 1000,
						// Duration of the animation
						dur : durations,
						// The value where the animation should start
						from : 0,
						// The value where it should end
						to : 1
					}
				});

			} else if (data.type === 'bar') {

				if (chart.options.horizontalBars) {
					data.element.animate({
						x2 : {
							begin : seq * delays + 1000,
							dur : 1000,
							from : data.x1,
							to : data.x2,
							easing : Chartist.Svg.Easing.easeOutQuint
						},
						opacity : {
							dur : 1000,
							from : 0,
							to : 1,
							easing : Chartist.Svg.Easing.easeOutQuint
						}
					});
				} else {
					data.element.animate({
						y2 : {
							begin : seq * delays + 1000,
							dur : 1000,
							from : data.y1,
							to : data.y2,
							easing : Chartist.Svg.Easing.easeOutQuint
						},
						opacity : {
							dur : 1000,
							from : 0,
							to : 1,
							easing : Chartist.Svg.Easing.easeOutQuint
						}
					});
				}

			} else if (data.type === 'label' && data.axis === 'x') {
				data.element.animate({
					y : {
						begin : seq * delays,
						dur : durations,
						from : data.y + 100,
						to : data.y,
						// We can specify an easing function from
						// Chartist.Svg.Easing
						easing : 'easeOutQuart'
					}
				});
			} else if (data.type === 'label' && data.axis === 'y') {
				data.element.animate({
					x : {
						begin : seq * delays,
						dur : durations,
						from : data.x - 100,
						to : data.x,
						easing : 'easeOutQuart'
					}
				});
			} else if (data.type === 'point') {
				data.element.animate({
					x1 : {
						begin : seq * delays,
						dur : durations,
						from : data.x - 10,
						to : data.x,
						easing : 'easeOutQuart'
					},
					x2 : {
						begin : seq * delays,
						dur : durations,
						from : data.x - 10,
						to : data.x,
						easing : 'easeOutQuart'
					},
					opacity : {
						begin : seq * delays,
						dur : durations,
						from : 0,
						to : 1,
						easing : 'easeOutQuart'
					}
				});
			} else if (data.type === 'grid') {
				// Using data.axis we get x or y which we can use to construct
				// our
				// animation definition objects
				var pos1Animation = {
					begin : seq * delays,
					dur : durations,
					from : data[data.axis + '1'] - 30,
					to : data[data.axis + '1'],
					easing : 'easeOutQuart'
				};

				var pos2Animation = {
					begin : seq * delays,
					dur : durations,
					from : data[data.axis + '2'] - 100,
					to : data[data.axis + '2'],
					easing : 'easeOutQuart'
				};

				var animations = {};
				animations[data.axis + '1'] = pos1Animation;
				animations[data.axis + '2'] = pos2Animation;
				animations['opacity'] = {
					begin : seq * delays,
					dur : durations,
					from : 0,
					to : 1,
					easing : 'easeOutQuart'
				};

				data.element.animate(animations);
			}
		});
	}

});
