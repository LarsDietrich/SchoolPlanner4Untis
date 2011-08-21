/* SchoolPlanner4Untis - Android app to manage your Untis timetable
    Copyright (C) 2011  Mathias Kub <mail@makubi.at>
			Sebastian Chlan <sebastian@schoolplanner.at>
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package edu.htl3r.schoolplanner.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import edu.htl3r.schoolplanner.R;
import edu.htl3r.schoolplanner.gui.settings.SettingsScreen;

/**
 * Diese Klasse erweitert die Standard Android-{@link Activity} um weitere Funktionalitaeten.
 * Dazu zaehlt unter Anderem das Hinzufuegen des Standard-Menues oder der Zugriff auf die ProgressBar am unteren Bildschirmrand.
 */
public abstract class SchoolPlannerActivity extends Activity {
	
	private ProgressBar progressWheel;
	private TextView loginProgressText;
	
	/**
	 * Zeigt einen Text und den Lade-Kreis in der ProgressBar am unteren Bildschirmrand an oder versteckt den Lade-Kreis.
	 * @param message Text, der angezeigt werden soll
	 * @param active Wenn 'true', wird der Lade-Kreis angezeigt, ansonsten wird er versteckt
	 */
	public void setInProgress(String message, boolean active) {
		loginProgressText.setText(message);
		if (active) {
			progressWheel.setVisibility(View.VISIBLE);
		} else {
			progressWheel.setVisibility(View.INVISIBLE);
		}
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		progressWheel = (ProgressBar) findViewById(R.id.loginProgress);
		loginProgressText = (TextView) findViewById(R.id.loginProgressText);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.default_menu, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.menu_settings:
	    	startActivity(new Intent(getApplicationContext(),SettingsScreen.class));
	        return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}
}
