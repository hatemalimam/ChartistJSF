# ChartistJSF
***

**ChartistJSF**, Highly Customizable Responsive Charts for JavaServer Faces.

![ChartistJSF-Line](http://i.imgur.com/blsm9kw.gif?1)
![ChartistJSF-Bar](http://i.imgur.com/2lhouF9.gif?1)

### Overview
***

**ChartistJSF** is based on [Chartist.js](http://gionkunz.github.io/chartist-js/) charts, which is a product of a community that was disappointed about the abilities provided by other charting libraries. The components are built on top of [PrimeFaces](http://primefaces.org) providing the maximum harmony in todays modern JSF applications.

### Facts

***

* Great flexibility while using clear separation of concerns (Style with CSS & control with JS)
* Usage of SVG (Yes! SVG is the future of illustration in web!)
* Fully responsive and DPI independent
* Responsive configuration with media queries 
* Fully compatible with JSF, PrimeFaces components, and AJAX updates.


### Why ChartistJSF and Not PrimeFaces Charts

***
PrimeFaces relies on jqPlot to draw the charts, jqPlot uses canvas for drawing the charts which limits the full control over the generated DOM elements, therefore styling and full controls can be a headache.

From that point the necessity for another Chart library came into the way (along-side PrimeFaces), ChartistJSF relies on Chartist.js to generate the Chart elements in pure SVG, the SVG charts are defined in XML. As a result, every SVG element is appended to the Document Object Model (DOM) and can be manipulated using a combination of JavaScript and CSS. Moreover, you can attach an event handlers to a SVG element or update its properties based on another document event. Canvas, on the other hand, is a simple graphics API. It draws pixels and nothing more.

Responsive is built in mind from the start and with media-queries it's easy to control each case apart.


### Getting Started
***

ChartistJSF can be downloaded manually or via maven.  

##### Downloads

Version | Binary | Source | PrimeFaces Version
------------ | -------------  | ------------- | ------------- 
3.0| [Download](https://oss.sonatype.org/content/repositories/releases/org/chartistjsf/ChartistJSF/3.0/ChartistJSF-3.0.jar)  | [Download](https://oss.sonatype.org/content/repositories/releases/org/chartistjsf/ChartistJSF/3.0/ChartistJSF-3.0-sources.jar) | 6.x
1.0| [Download](https://oss.sonatype.org/content/repositories/releases/org/chartistjsf/ChartistJSF/1.0/ChartistJSF-1.0.jar)  | [Download](https://oss.sonatype.org/content/repositories/releases/org/chartistjsf/ChartistJSF/1.0/ChartistJSF-1.0-sources.jar) | 5.x

##### Maven
PrimeFaces 6.x
```xml
<dependency>
	<groupId>org.chartistjsf</groupId>
	<artifactId>ChartistJSF</artifactId>
	<version>3.0</version>		
</dependency>
```

PrimeFaces 5.x
```xml
<dependency>
	<groupId>org.chartistjsf</groupId>
	<artifactId>ChartistJSF</artifactId>
	<version>1.0</version>		
</dependency>
```

### Usage
***

##### Namespace

```xml
xmlns:ct="http://www.chartistjsf.org/charts"
```

##### Component

```xml
<ct:chart type="line" model="#{mainBean.lineModel}">
</ct:chart>
```
- - - -


## [Further Examples](https://chartistjsf-showcase.herokuapp.com/)
***

Please refer to the [showcase](https://chartistjsf-showcase.herokuapp.com/) website in order to see the full usage.


### Contribution
***
You are very welcome to contribute to this project, just fork and let me know :)

###  Developers
***
* [Hatem Alimam](http://hatemalimam.com)

### License
***
Licensed under the Apache License, Version 2.0 (the "License") [http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

### NOTICE
***
* This product includes software developed by [Prime Technology](http://www.prime.com.tr/)
* This product includes software developed by [The jQuery Project](http://jquery.com)
* This product includes software developed by [Gion Kunz](https://github.com/gionkunz/chartist-js)


