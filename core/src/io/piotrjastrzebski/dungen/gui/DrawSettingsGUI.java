/*******************************************************************************
 * Copyright 2015 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package io.piotrjastrzebski.dungen.gui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.StringBuilder;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.*;
import io.piotrjastrzebski.dungen.DrawSettings;
import io.piotrjastrzebski.dungen.GenSettings;

public class DrawSettingsGUI extends VisWindow {
	DrawSettings settings;

	public DrawSettingsGUI (final Restarter restarter) {
		super("Generator settings");
		settings = new DrawSettings();
		VisTable c = new VisTable(true);

		VisTextButton restart = new VisTextButton("Restart");
		restart.addListener(new ClickListener() {
			@Override public void clicked (InputEvent event, float x, float y) {
				restarter.update(settings);
			}
		});
		c.add(restart);
		c.row();
		c.add(new VisLabel("Hover on labels for tooltips")).colspan(3);
		c.row();

		add(c);
		pack();
	}

	public void setDefaults(DrawSettings settings) {
		this.settings.copy(settings);

		pack();
	}

	public DrawSettings getSettings () {
		return settings;
	}
}
