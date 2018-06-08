package net.reichholf.dreamdroid.tv.presenter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.Presenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.reichholf.dreamdroid.R;

/**
 * Created by Stephan on 16.10.2016.
 */

public class IconHeaderItemPresenter extends Presenter {
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
		LayoutInflater inflater = (LayoutInflater) viewGroup.getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View view = inflater.inflate(
				R.layout.tv_icon_header_item, null);

		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, Object o) {
		HeaderItem headerItem = ((ListRow) o).getHeaderItem();
		View rootView = viewHolder.view;

		ImageView iconView = rootView.findViewById(R.id.header_icon);
		Drawable icon = rootView.getResources().getDrawable(R.drawable.ic_action_folder, null);
		iconView.setImageDrawable(icon);

		TextView label = rootView.findViewById(R.id.header_label);
		label.setText(headerItem.getName());
	}

	@Override
	public void onUnbindViewHolder(ViewHolder viewHolder) {
		// no op
	}
}
