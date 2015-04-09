/*
 * Copyright 2015 ChartistJSF.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.chartistjsf.application;

import javax.faces.application.Application;
import javax.faces.application.ApplicationWrapper;

/**
 * <p>
 * This ChartistJSF application extends the standard JSF application.
 * <p>
 * This application is already registered by ChartistJSF' own
 * <code>faces-config.xml</code> and thus gets auto-initialized when the
 * ChartistJSF JAR is bundled in a web application, so end-users do not need to
 * register this application explicitly themselves.
 *
 * @author Hatem Alimam
 * @since 0.1
 */

public class ChartistJSFApplication extends ApplicationWrapper {

	private final Application wrapped;

	/**
	 * Construct a new ChartistJSF application around the given wrapped
	 * application.
	 * 
	 * @param wrapped
	 *            The wrapped application.
	 */
	public ChartistJSFApplication(Application wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public Application getWrapped() {
		return wrapped;
	}
}
