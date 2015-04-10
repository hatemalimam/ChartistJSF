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
package org.chartistjsf.model.chart;

/**
 * @author Hatem Alimam
 * @since 0.1
 */
public enum AspectRatio {

	SQUARE("ct-square", "1"), MINOR_SECOND("ct-minor-second", "15:16"), MAJOR_SECOND("ct-major-second", "8:9"), MINOR_THIRD(
			"ct-minor-third", "5:6"), MAJOR_THIRD("ct-major-third", "4:5"), PERFECT_FOURTH("ct-perfect-fourth", "3:4"), PERFECT_FIFTH(
			"ct-perfect-fifth", "2:3"), MINOR_SIXTH("ct-minor-sixth", "5:8"), GOLDEN_SECTION("ct-golden-section",
			"1:1.618"), MAJOR_SIXTH("ct-major-sixth", "3:5"), MINOR_SEVENTH("ct-minor-seventh", "9:16"), MAJOR_SEVENTH(
			"ct-major-seventh", "8:15"), OCTAVE("ct-octave", "1:2"), MAJOR_TENTH("ct-major-tenth", "2:5"), MAJOR_ELEVENTH(
			"ct-major-eleventh", "3:8"), MAJOR_TWELFTH("ct-major-twelfth", "1:3"), DOUBLE_OCTAVE("ct-double-octave",
			"1:4");

	private String styleClass;
	private String ratio;

	AspectRatio(String styleClass, String ratio) {
		this.styleClass = styleClass;
		this.ratio = ratio;
	}

	public String styleClass() {
		return this.styleClass;
	}

	@Override
	public String toString() {
		return this.styleClass + " " + this.ratio;
	}
}
