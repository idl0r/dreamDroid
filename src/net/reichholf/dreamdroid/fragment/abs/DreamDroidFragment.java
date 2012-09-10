/* © 2010 Stephan Reichholf <stephan at reichholf dot net>
 * 
 * Licensed under the Create-Commons Attribution-Noncommercial-Share Alike 3.0 Unported
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

package net.reichholf.dreamdroid.fragment.abs;

import net.reichholf.dreamdroid.R;
import net.reichholf.dreamdroid.abstivities.MultiPaneHandler;
import net.reichholf.dreamdroid.fragment.ActivityCallbackHandler;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragment;

/**
 * @author sre
 * 
 */
public abstract class DreamDroidFragment extends SherlockFragment implements ActivityCallbackHandler {
	protected String mCurrentTitle;
	protected String mBaseTitle;
	protected MultiPaneHandler mMultiPaneHandler;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		mBaseTitle = mCurrentTitle = getString(R.string.app_name);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().setTitle(mCurrentTitle);
		mMultiPaneHandler = (MultiPaneHandler) getSherlockActivity();
	}

	@Override
	public void onResume() {
		super.onResume();
		((MultiPaneHandler) getSherlockActivity()).onDetailFragmentResume(this);
	}

	@Override
	public void onPause() {
		MultiPaneHandler mph = (MultiPaneHandler) getSherlockActivity();
		if (mph != null)
			mph.onDetailFragmentPause(this);
		super.onPause();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
		super.onSaveInstanceState(outState);
	}
}
