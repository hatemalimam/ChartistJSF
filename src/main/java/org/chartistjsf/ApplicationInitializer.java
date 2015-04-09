/*
 * Copyright 2015 ChartistJSF.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.chartistjsf;

import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * <p>
 * ChartistJSF application initializer. This runs when the servlet container
 * starts up. This performs the following tasks:
 * <ol>
 * <li>Log the ChartistJSF version.
 * </ol>
 *
 * @author Hatem Alimam
 * @since 0.1
 */
public class ApplicationInitializer implements ServletContainerInitializer {

	// Constants
	// ------------------------------------------------------------------------------------------------------

	private static final Logger logger = Logger.getLogger(ApplicationInitializer.class.getName());

	public void onStartup(Set<Class<?>> c, ServletContext servletContext) throws ServletException {
		logChartistJSFVersion();
	}

	private void logChartistJSFVersion() {
		logger.info("Using ChartistJSF version " + getClass().getPackage().getSpecificationVersion());
	}

}
