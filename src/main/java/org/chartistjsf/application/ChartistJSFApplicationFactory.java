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
import javax.faces.application.ApplicationFactory;
import javax.faces.application.ApplicationWrapper;

/**
 * This application factory takes care that the {@link ChartistJSFApplication} is properly initialized.
 * This factory is inspired by BalusC's Omnifaces application (https://github.com/omnifaces/omnifaces)
 *
 * @author Hatem Alimam
 * @see ChartistJSFApplication
 * @since 0.1
 */
public class ChartistJSFApplicationFactory extends ApplicationFactory {

	// Variables ------------------------------------------------------------------------------------------------------

	private final ApplicationFactory wrapped;
	private volatile Application application;

	// Constructors ---------------------------------------------------------------------------------------------------

	/**
	 * Construct a new ChartistJSF application factory around the given wrapped factory.
	 * @param wrapped The wrapped factory.
	 */
	public ChartistJSFApplicationFactory(ApplicationFactory wrapped) {
		this.wrapped = wrapped;
	}

	// Actions --------------------------------------------------------------------------------------------------------

	/**
	 * Returns an instance of {@link ChartistJSFApplication} which wraps the original application.
	 */
	@Override
	public Application getApplication() {
		return (application == null) ? createChartistJSFApplication(wrapped.getApplication()) : application;
	}

	/**
	 * Sets the given application instance as the current instance. If it's not an instance of {@link ChartistJSFApplication},
	 * nor wraps the {@link ChartistJSFApplication}, then it will be wrapped by a new instance of {@link ChartistJSFApplication}.
	 */
	@Override
	public void setApplication(Application application) {
		wrapped.setApplication(createChartistJSFApplication(application));
	}

	/**
	 * Returns the wrapped factory.
	 */
	@Override
	public ApplicationFactory getWrapped() {
		return wrapped;
	}

	// Helpers --------------------------------------------------------------------------------------------------------

	/**
	 * If the given application not an instance of {@link ChartistJSFApplication}, nor wraps the {@link ChartistJSFApplication}, then
	 * it will be wrapped by a new instance of {@link ChartistJSFApplication} and set as the current instance and returned.
	 * Additionally, it will check if all Application implementations properly extend from ApplicationWrapper.
	 */
	private synchronized Application createChartistJSFApplication(final Application application) {
		Application newApplication = application;

		while (!(newApplication instanceof ChartistJSFApplication) && newApplication instanceof ApplicationWrapper) {
			newApplication = ((ApplicationWrapper) newApplication).getWrapped();
		}

		if (!(newApplication instanceof ChartistJSFApplication)) {
			newApplication = new ChartistJSFApplication(application);
		}

		this.application = newApplication;
		return this.application;
	}

}